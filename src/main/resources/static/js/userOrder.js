let userOrderObject = {
    init: function () {
        $("#btn-add-cart").on("click", () => {
            this.insertCart();
        });
    },
    insertCart:function (user_id) {
        $.ajax({
            type:"post",
            url:"/user/addCart" + user_id,
            data: {},
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            location = "/user/userOrderList";
        }).fail(function (error) {
            alert("에러발생 : " + error);
        });
    }
}