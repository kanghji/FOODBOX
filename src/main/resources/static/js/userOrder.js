let userOrderObject = {
    init: function () {
        $("#cart").on("click", () => {
            this.insertCart();
        });
    },
    insertCart: function (prod_code, user_id, prod_thumbnail) {

        // let prod_info = {
        //     prod_thumbnail: $("#prod_thumbnail").val(),
        //     prod_price: $("#prod_price").val(),
        //     order_qty: $("#order_qty").val()
        // }
        let prod_price = $("#prod_price").text();
        let order_qty = $("#order_qty").val();

        $.ajax({
            type: "post",
            url: "/user/addCart",
            data: JSON.stringify({user_id: user_id, prod_code: prod_code, prod_thumbnail: prod_thumbnail, prod_price: prod_price, order_qty: order_qty}),
            contentType: "application/json; charset=utf-8"
            // data: {user_id: user_id, prod_code: prod_code}
        }).done(function (response) {
            location = "/user/productPage";
        }).fail(function (error) {
            alert("에러발생 : " + error);
        });
    }
}

userOrderObject.init();