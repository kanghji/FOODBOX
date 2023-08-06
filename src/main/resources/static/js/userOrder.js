let userOrderObject = {

    insertCart: function (prod_code, user_id) {

        let order_qty = $("#order_qty").val();

        $.ajax({
            type: "post",
            url: "/user/addCart",
            data: JSON.stringify({user_id: user_id, prod_code: prod_code, order_qty: order_qty}),
            contentType: "application/json; charset=utf-8"
        }).done(function (response) {
            location.href = "/user/userCartList/" + user_id;
        }).fail(function () {
            alert("로그인이 필요합니다!");
        });
    },

    deleteCart: function (cart_no) {
        if(confirm("장바구니에서 삭제하시겠습니까?") == true) {
            $.ajax({
                type: "post",
                url: "/user/userCartDelete",
                data: JSON.stringify({cart_no: cart_no}),
                contentType: "application/json; charset=utf-8"
            }).done(function (response) {
                alert("삭제되었습니다");
                document.location.href = document.location.href;
            }).fail(function (error) {
                alert("에러발생 : " + error);
            });
        } else {
            return;
        }
    }

}
