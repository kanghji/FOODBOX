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
        let order_qty = $("#order_qty").val();

        $.ajax({
            type: "post",
            url: "/user/addCart",
            data: JSON.stringify({user_id: user_id, prod_code: prod_code, order_qty: order_qty}),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            location = "/user/userCartList";
        }).fail(function (error) {
            alert("에러발생 : " + error);
        });
    }
}

userOrderObject.init();