
function orderBtn () {
    requestPay();

    function requestPay() {
        IMP.init("");
        IMP.request_pay({
                pg: "html5_inicis",		//KG이니시스 pg파라미터 값
                pay_method: "card",		//결제 방법
                merchant_uid: "1234578",//주문번호
                name: "당근 10kg",		//상품 명
                amount: 200,			//금액
                buyer_email: "gildong@gmail.com",
                buyer_name: "홍길동",
                buyer_tel: "010-4242-4242",
                buyer_addr: "서울특별시 강남구 신사동",
                buyer_postcode: "01181"
            },
            function (rsp) {
                //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
                if (rsp.success) {
                    alert("결제성공");
                    //서버 검증 요청 부분
                } else {
                    alert("결제에 실패하였습니다. 에러 : " + rsp.error_msg);
                }
            }
        );
    }
}