let userOrderObject = {
    init: function () {
        $("#cart").on("click", () => {
            this.insertCart();
        });
    },
    insertCart: function (prod_code, user_id) {
        // let prod_info = {
        //     prod_thumbnail: $("#prod_thumbnail").val(),
        //     prod_price: $("#prod_price").val(),
        //     order_qty: $("#order_qty").val()
        // }
        let prod_thumbnail = $("#prod_thumbnail").val();
        let prod_price = $("#prod_price").val();
        let order_qty = $("#order_qty").val();


        $.ajax({
            type: "post",
            url: "/user/addCart/" + user_id,
            // data: JSON.stringify({prod_info, user_id: $("#user_id"), prod_code: 1})
            data: {user_id: $("#user_id"), prod_code: 1, prod_thumbnail: prod_thumbnail, prod_price: prod_price, order_qty: order_qty}
            // contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            location = "/user/userCartList" + user_id;
        }).fail(function (error) {
            alert("에러발생 : " + error);
        });
    }
}

userOrderObject.init();