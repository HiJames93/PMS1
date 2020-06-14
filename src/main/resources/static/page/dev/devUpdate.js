layui.use(['form','layer'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //实际使用时的提交数据
        /*var params = $("#dataFrm").serialize();
        params = decodeURIComponent(params,true);
        params = encodeURI(encodeURI(params));
        alert(params);*/
        //实际使用时的提交数据
        $.post("toUpdateDev", data.field, function (res) {
            if (res.code == 200) {
                top.layer.close(index);
                top.layer.msg(res.msg);
                //刷新父页面
                parent.location.reload();
            }
            layer.msg(res.msg)
        }, "json");
        return false;
    })

})