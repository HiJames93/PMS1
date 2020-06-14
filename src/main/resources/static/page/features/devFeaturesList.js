layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //功能列表
    var tableIns = table.render({
        elem: '#devFeaturesList',
        url : '/getDevFeaturesLists',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [10,15,20,25],
        id : "devFeaturesListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'fid', title: 'ID', align:"center"},
            {field: 'featuresName', title: '功能名称', align:'center'},
            {field: 'featuresDesc', title: '功能简述',  align:'center'},
            {field: 'enableFeatures', title: '是否启用', align:'center'},
            {field: 'featuresType', title: '功能属性', align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {title: '操作', fixed:"right",align:"center", templet:function(){
                    return '<a class="layui-btn layui-btn-xs" lay-event="editFeatures">编辑</a>' +
                        '<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="startFeatures">启用</a>' +
                        '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="stopFeatures">停用</a>';
                }}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("devFeaturesListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    featuresType: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });


    //添加
    function updateFeatures(edit){
        var index = layer.open({
            title : "更新功能",
            type : 2,
            area : ["300px","385px"],
            content : "showUpdateFeatures",
            success : function(layero, index){
                var body = $($(".layui-layer-iframe",parent.document).find("iframe")[0].contentWindow.document.body);
                if(edit){
                    body.find(".fid").val(edit.fid);
                    body.find(".featuresName").val(edit.featuresName);
                    body.find(".featuresDesc").val(edit.featuresDesc);
                    body.find(".featuresType").val(edit.featuresType);
                    form.render();
                }
            }
        })
    }
    
    //添加
    function addFeatures(edit){
        var index = layer.open({
            title : "新增功能",
            type : 2,
            area : ["300px","385px"],
            content : "showAddFeatures",
            success : function(layero, index){
            }
        })
    }
    $("#addFeatures").click(function(){
        addFeatures();
    })

    //批量删除
    $("#removeFeatures").click(function(){
        var checkStatus = table.checkStatus('devFeaturesListTable'),
            data = checkStatus.data,
            linkId = [];
        if(data.length > 0) {
            for (var i in data) {
                linkId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的友链？', {icon: 3, title: '提示信息'}, function (index) {
                $.post("删除友链接口",{
                    linkId : linkId  //将需要删除的linkId作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的文章");
        }
    })

    // 提交新增功能
    form.on("submit(addFeatures)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post("addFeatures",data.field,function(res){
            if (res == 1004){
                top.layer.close(index);
                top.layer.msg(res.msg);
                layer.closeAll("iframe");
                //刷新父页面
                $(".layui-tab-item.layui-show",parent.document).find("iframe")[0].contentWindow.location.reload();
            }else if (res == -1040){
                top.layer.close(index);
                layer.msg(res.msg)
            }else {
                top.layer.close(index);
                layer.msg(res.msg);
            }
        });
        return false;
    });

    // 提交更新功能信息
    form.on("submit(updateFeatures)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post("updateFeatures",data.field,function(res){
            if (res == 1004){
                top.layer.close(index);
                top.layer.msg(res.msg);
                layer.closeAll("iframe");
                //刷新父页面
                $(".layui-tab-item.layui-show",parent.document).find("iframe")[0].contentWindow.location.reload();
            }else if (res == -1040){
                top.layer.close(index);
                layer.msg(res.msg)
            }else {
                top.layer.close(index);
                layer.msg(res.msg);
            }
        });
        return false;
    });

    //列表操作
    table.on('tool(devFeaturesList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'editFeatures'){ //编辑
            updateFeatures(data);
        } else if(layEvent === 'stopFeatures'){ //删除

            layer.confirm('确定停用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("stopFeatures",data,function(res){
                    if (res == 2001){
                        layer.msg(res.msg);
                        layer.close(index);
                        tableIns.reload();
                    }
                    layer.msg(res.msg);
                });
            });
        }else if(layEvent === 'startFeatures'){ //删除

            layer.confirm('确定启用此功能么？',{icon:3, title:'提示信息'},function(index){
                $.post("startFeatures",data,function(res){
                    if (res == 2002){
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