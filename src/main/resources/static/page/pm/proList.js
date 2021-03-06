layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //项目列表
    var tableIns = table.render({
        elem: '#PMList',
        url : '/pro/getList.html',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        id : "PMListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'pro_id', title: 'ID', align:"center", width:180},
            {field: 'pro_name', title: '项目名称', align:'center', width:180},
            {field: 'pro_organizerName', title: '发起人', align:'center', width:180},
            {field: 'pro_desc', title: '项目简述',  align:'center', width:180},
            {field: 'pro_info', title: '项目信息', align:'center', width:180},
            {field: 'pro_type', title: '项目类型', align:'center', width:180},
            {field: 'pro_list_demand', title: '史诗列表', align:'center', width:180},
            {field: 'pro_open', title: '是否启用', align:'center', width:180},
            {field: 'pro_createTime', title: '创建时间', width:180},
            {field: 'pro_lastTime', title: '修改时间', width:180},
            {title: '操作', fixed:"right",align:"center", width:180, templet:function(){
                    return '<a class="layui-btn layui-btn-xs" lay-event="editFeatures">编辑</a>' +
                        '<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="startPM">启用</a>' +
                        '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="stopPM">停用</a>';
                        '<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="downloadPM">导出</a>';
                }}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(event){
        if($(".searchVal").val() != ''){
            table.reload("PMListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    pName: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入项目名");
        }
    });


    //列表操作
    table.on('tool(PMList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            // updateDev(data);
        }
    });

    function addPros(edit){
        layer.open({
            type: 2,
            anim: 5,
            area: ['550px', '400px'], //宽高

            content: "/showAddPM"
        });
    }
    $(".addPro").click(function () {
        addPros();
    });

    function stopPros(edit){
        layer.open({
            type: 2,
            anim: 5,
            skin: 'layui-layer-rim', //加上边框
            area: ['1000px', '400px'], //宽高

            content: "/stopPros"
        });
    }
    $(".stopPro").click(function () {
        stopPros();
    });
})