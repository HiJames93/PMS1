layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#storyList',
        url : '/pro/getStoryListByPage',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "StoryListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:70},
            {field: 'story_id', title: 'ID', align:"center"},
            {field: 'story_name', title: '故事名称', width:180, align:'center'},
            {field: 'user_name', title: '作者', width:180, align:'center'},
            {field: 'story_desc', title: '故事简述', width:180, align:'center'},
            {field: 'story_info', title: '故事信息', width:300, align:'center'},
            {field: 'story_ideasSource', title: '灵感来源', width:180, align:'center'},
            {field: 'story_type', title: '灵感类型', width:180, align:'center'},
            {field: 'story_open', title: '是否启用', width:100, align:'center'},
            {field: 'createTime', title: '创建时间', width:180, align:'center'},
            {field: 'lastTime', title: '最后修改', width:180, align:'center'},
            {title: '操作', fixed:"right",align:"center", width:240, sort: true, templet:'#storyListBar'}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("StoryListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    story_name: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入故事名");
        }
    });

    //添加
    function addStory(edit){
        var index = layui.layer.open({
            title : "故事编辑",
            type : 2,
            content : "/pro/showAddStory.html",
            success : function(layero, index){
            }
        });
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addStory").click(function(){
        addStory();
        return false;
    });

    // 编辑
    function updateStory(edit){
        var index=layui.layer.open({
            title:"更新故事",
            type:2,
            content:"/pro/showUpdateStory.html",
            success:function (layero,index) {
                var body = layui.layer.getChildFrame('body', index);//少了这个是不能从父页面向子页面传值的
                body.find(".story_id").val(edit.story_id);
                body.find(".story_name").val(edit.story_name);
                body.find(".user_name").prop("select",edit.user_name);
                body.find(".story_desc").val(edit.story_desc);
                body.find(".story_info").val(edit.story_info);
                body.find(".story_ideasSource").val(edit.story_ideasSource);
                body.find(".story_type").val(edit.story_type);
                body.find(".story_open").prop("checked",edit.story_open);
                // form.render();
            }
        });
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        });
    }

    //列表操作
    table.on('tool(storyList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'editStory'){ //编辑
            updateStory(data);
        } else if(layEvent === 'stopStory'){ //删除

            layer.confirm('确定停用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/pro/stopStory",data,function(res){
                    if (res == 2001){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'startStory'){ //删除

            layer.confirm('确定启用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/pro/startStory",data,function(res){
                    if (res == 2002){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'removeStory'){ //删除

            layer.confirm('确定删除此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/pro/removeStory",data,function(res){
                    if (res == 1002){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }
    });
});