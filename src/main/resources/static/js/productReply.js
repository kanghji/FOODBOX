let replyFunc = (() => {

    function getList(param, cb) {
        let reply_prod_code = param.reply_prod_code;
        let viewPage = param.viewPage;

        $.ajax({
            url: "/user/productReply" + reply_prod_code + '/' + viewPage,
            type: "get",
            success: (result) => {
                if (cb) cb(result);
            },
            error: () => {
                alert("요청실패")
            }
        });
    }


    return{
        getList: getList,
    }

})();