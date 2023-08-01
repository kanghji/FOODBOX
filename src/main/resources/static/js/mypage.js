
// 마이페이지 클릭 이벤트
$(function (){
    $(".mypage .mypage__submenu").hide();
    $(".mypage").click(function (){
        $(".mypage .mypage__submenu").toggle();
    });
});
