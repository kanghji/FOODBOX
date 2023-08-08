function orderBtn(orderList) {

    let pg;
    let payMethod;
    let buyerEmail = document.getElementById('user_email').textContent;
    let buyerName = document.getElementById('user_name').textContent;
    let buyerTel = document.getElementById('user_tel').textContent;
    let buyerAddr = document.getElementById('user_addr').textContent;
    let buyerPostcode = document.getElementById('user_zipcode').textContent;
    let amount = document.getElementById('cartTotPrice').value;
    let merchantUid;
    let name;

    requestPay();

    // function paymentRecord() {
    //     // pg = document.getElementById('pg')[document.getElementById('pg')
    //     //     .selectedIndex].value.toUpperCase();
    //     // if (pg == '결제 방법 선택') {
    //     //     alert('결제 방법을 선택해주세요');
    //     //     preventDefault();
    //     // }
    //     // payMethod = document.getElementById('payMethod')[document.getElementById('payMethod')
    //     //     .selectedIndex].value.toUpperCase();
    //     // if (payMethod == '결제 수단 선택') {
    //     //     alert('결제 수단을 선택해주세요');
    //     //     preventDefault();
    //     // }
    //     buyerEmail = document.getElementById('user_email').textContent;
    //     buyerName = document.getElementById('user_name').textContent;
    //     buyerTel = document.getElementById('user_tel').textContent;
    //     buyerAddr = document.getElementById('user_addr').textContent;
    //     buyerPostcode = document.getElementById('user_zipcode').textContent;
    //
    //     let data = {
    //         method: 'POST',
    //         body: JSON.stringify({
    //             // pg,
    //             // payMethod,
    //             buyerEmail,
    //             buyerName,
    //             buyerTel,
    //             buyerAddr,
    //             buyerPostcode
    //         }),
    //         headers: {
    //             'Content-Type': 'application/json',
    //         }
    //     };
    //     const onSuccess = res => {
    //         res.json()
    //             .then((json) => {
    //                 amount = json.amount;
    //                 merchantUid = json.merchantUid;
    //             })
    //     }
    //     const onFailure = res => {
    //         return res.json()
    //             .then(json => {
    //                 alert(json.message);
    //                 preventDefault();
    //             })
    //     }
    //
    //     fetch(`/api/v1/payment/record`, data)
    //         .then(res => {
    //             if (!res.ok) {
    //                 throw res;
    //             }
    //             return res
    //         })
    //         .then(onSuccess, onFailure)
    //         .catch(err => {
    //             console.log(err.message);
    //         });
    // };

    function requestPay() {

        let user_id = $("#user_id").val()
        let user_name = $("#user_name").text();

        IMP.init("");
        IMP.request_pay({
                pg: "html5_inicis",
                pay_method: "card",
                merchant_uid: 'merchant_' + new Date().getTime(),
                amount: amount,
                name: buyerName,
                buyer_email: buyerEmail,
                buyer_name: buyerName,
                buyer_tel: buyerTel,
                buyer_addr: buyerAddr,
                buyer_postcode: buyerPostcode
            },
            function () {
                // if (rsp.success) {
                    $.ajax({
                        url: "/payment/complete",
                        method: "post",
                        headers: {"Content-Type": "application/json"},
                        data: {
                            // imp_uid: rsp.imp_uid,
                            // merchant_uid: rsp.merchant_uid
                            orderList: orderList
                        }
                    }).done(function (data) {
                        // location.replace('/user/order/payment-result');
                    });
                // } else {
                //     alert("결제에 실패하였습니다. 에러 : " + rsp.error_msg);
                // }
            });
    }
}