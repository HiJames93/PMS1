layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#devList',
        url : '/getDevLists',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        id : "devListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', align:"center"},
            {field: 'title', title: '设备名称', align:'center'},
            {field: 'info', title: '设备信息',  align:'center'},
            {field: 'num', title: '设备个数', align:'center'},
            {field: 'isCalled', title: '是否可用', align:'center'},
            {field: 'calledTime', title: '调用时间', align:'center'},
            {field: 'other', title: '备注', align:'center'},
            {field: 'bid', title: '业务代码'},
            // {title: '操作', width:170, templet:'#devListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("devListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    title: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });


    //列表操作
    table.on('tool(devList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            // updateDev(data);
        }
    });

    function addDevz(edit){
        layer.open({
            type: 2,
            anim: 5,
            area: ['550px', '400px'], //宽高

            content: "/addDevz"
        });
    }
    $(".addDev").click(function () {
        addDevz();
    });

    function removeDevz(edit){
        layer.open({
            type: 2,
            anim: 5,
            skin: 'layui-layer-rim', //加上边框
            area: ['1000px', '400px'], //宽高

            content: "/removeDevz"
        });
    }
    $(".removeDev").click(function () {
        removeDevz();
    });
})