layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#demandList',
        url : '/demand/getDemandListByPage',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "DemandListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:70},
            {field: 'demandId', title: '灵感ID', align:"center"},
            {field: 'demandName', title: '灵感名称', width:180, align:'center'},
            {field: 'demandDesc', title: '灵感ID', width:180, align:'center'},
            {field: 'demandInfo', title: '灵感简述', width:180, align:'center'},
            {field: 'ideasSource', title: '灵感来源', width:300, align:'center'},
            {field: 'demandType', title: '灵感类型', width:180, align:'center'},
            {field: 'demandOpen', title: '是否启用', width:100, align:'center'},
            {field: 'createTime', title: '创建时间', width:180, align:'center'},
            {field: 'lastTime', title: '最后修改', width:180, align:'center'},
            {title: '操作', fixed:"right",align:"center", width:240, sort: true, templet:'#demandListBar'}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("DemandListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    storyName: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入故事名");
        }
    });

    //添加
    function addDemand(edit){
        var index = layui.layer.open({
            title : "故事编辑",
            type : 2,
            content : "/demand/showAddDemand.html",
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
    $(".addDemand").click(function(){
        addDemand();
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
                body.find(".storyId").val(edit.storyId);
                body.find(".storyName").val(edit.storyName);
                body.find(".userName").prop("select",edit.userName);
                body.find(".storyDesc").val(edit.storyDesc);
                body.find(".storyInfo").val(edit.storyInfo);
                body.find(".ideasSource").val(edit.ideasSource);
                body.find(".storyOpen").prop("checked",edit.storyOpen);
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