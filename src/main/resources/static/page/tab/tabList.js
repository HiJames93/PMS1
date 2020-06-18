layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#tabMenuList',
        url : '/tabMenu/getTabMenuListByPage',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "TabMenuListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:70},
            {field: 'tabId', title: '选项卡菜单ID', align:"center"},
            {field: 'tabName', title: '选项卡菜单名称', width:180, align:'center'},
            {field: 'tabMenuType', title: '选项卡菜单类型', width:180, align:'center'},
            {field: 'tabType', title: '选项卡类型', width:180, align:'center'},
            {field: 'tabNum', title: '选项卡信息数量', width:300, align:'center'},
            {field: 'tabOpen', title: '是否启用', width:100, align:'center'},
            {field: 'createTime', title: '创建时间', width:180, align:'center'},
            {field: 'lastTime', title: '最后修改', width:180, align:'center'},
            {title: '操作', fixed:"right",align:"center", width:240, sort: true, templet:'#tabListBar'}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("TabMenuListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    tabMenuName: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入选项卡名称");
        }
    });

    //添加
    function addTabMenu(edit){
        var index = layui.layer.open({
            title : "选项卡注册",
            type : 2,
            content : "/tabMenu/showAddTabMenu.html",
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
    $(".addTabMenu").click(function(){
        addTabMenu();
        return false;
    });

    // 编辑
    function updateStory(edit){
        var index=layui.layer.open({
            title:"更新故事",
            type:2,
            content:"/tabMenu/showEditTabMenu.html",
            success:function (layero,index) {
                var body = layui.layer.getChildFrame('body', index);//少了这个是不能从父页面向子页面传值的
                body.find(".tabId").val(edit.tabId);
                body.find(".tabName").val(edit.tabName);
                body.find(".tabMenuType").prop("select",edit.tabMenuType);
                body.find(".tabType").prop("select",edit.tabType);
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
    table.on('tool(tabMenuList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'editTab'){ //编辑
            updateStory(data);
        } else if(layEvent === 'removeTab'){ //停用

            layer.confirm('确定停用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/tabMenu/stopTab",data,function(res){
                    if (res == 2001){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'startTab'){ // 启用

            layer.confirm('确定启用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/tabMenu/startTab",data,function(res){
                    if (res == 3007){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'removeTab'){ //删除

            layer.confirm('确定删除此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/tabMenu/removeTab",data,function(res){
                    if (res == 3002){
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