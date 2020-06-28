layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //史诗列表
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
            {field: 'demand_id', title: '史诗ID', align:"center"},
            {field: 'demand_name', title: '史诗名称', width:180, align:'center'},
            {field: 'user_name', title: '作者', width:180, align:'center'},
            {field: 'demand_desc', title: '史诗简述', width:180, align:'center'},
            {field: 'demand_info', title: '史诗信息', width:300, align:'center'},
            {field: 'demand_ideasSource', title: '来源', width:180, align:'center'},
            {field: 'demand_type', title: '史诗类型', width:100, align:'center'},
            {field: 'demand_open', title: '是否启用', width:100, align:'center'},
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
                    demand_name: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入史诗");
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
            content:"/demand/showUpdateDemand.html",
            success:function (layero,index) {
                var body = layui.layer.getChildFrame('body', index);//少了这个是不能从父页面向子页面传值的
                body.find(".demand_id").val(edit.demand_id);
                body.find(".demand_name").val(edit.demand_name);
                body.find(".user_name").prop("select",edit.user_name);
                body.find(".demand_desc").val(edit.demand_desc);
                body.find(".demand_info").val(edit.demand_info);
                body.find(".demand_ideasSource").val(edit.demand_ideasSource);
                body.find(".demand_type").val(edit.demand_type);
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
    table.on('tool(demandList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'editDemand'){ //编辑
            updateStory(data);
        } else if(layEvent === 'stopDemand'){ //停用

            layer.confirm('确定停用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/demand/stopDemand",data,function(res){
                    if (res == 4007){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'startDemand'){ //启用

            layer.confirm('确定启用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/demand/startDemand",data,function(res){
                    if (res == 4006){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'removeDemand'){ //删除

            layer.confirm('确定删除此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("/demand/removeDemand",data,function(res){
                    if (res == 4002){
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