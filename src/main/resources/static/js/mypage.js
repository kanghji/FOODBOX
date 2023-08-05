
// 마이페이지 클릭 이벤트
$(function (){
    $(".mypage .mypage__submenu").hide();
    $(".mypage").click(function (){
        $(".mypage .mypage__submenu").toggle();
    });
});

// 비밀번호 재확인 버튼 클릭 이벤트
function userInfoBtn() {

    $.ajax({
        type: 'post',
        url: '/user_infoUpdateChk',
        success: function (data) {

            let infoPwChk = $("#user_pw").val();


            if(infoPwChk == "") {
                $("#infoPwChk_text").css("color", "red");
                $("#infoPwChk_text").text("현재 비밀번호를 입력해주세요");
                user_pw = false;
            }
            else if(password == true && $("#password").val() == infoPwChk) {
                // $("#infoPwChk_text").css("color", "blue");
                // $("#infoPwChk_text").text("비밀번호가 일치합니다");
                // user_pw = true;
                // 비밀번호 변경 페이지로 이동하기

            }else {
                $("#infoPwChk_text").css("color", "red");
                $("#infoPwChk_text").text("비밀번호를 다시 확인해주세요");
                $("#user_pw").val("");
                user_pw = false;
            }
        }
    });
}



// $("#password_check").blur(function() {
//     if($("#password_check").val() == "") {
//         $("#pwdcheck_blank2").css("color", "red");
//         $("#pwdcheck_blank2").text("필수정보예요.");
//         password_check = false;
//     }
//     else if(password == true && $("#password").val() == $("#password_check").val()) {
//         $("#pwdcheck_blank2").css("color", "blue");
//         $("#pwdcheck_blank2").text("비밀번호가 일치합니다!");
//         password_check = true;
//     }else {
//         $("#pwdcheck_blank2").css("color", "red");
//         $("#pwdcheck_blank2").text("비밀번호를 다시 확인해주세요");
//         $("#password_check").val("");
//         password_check = false;
//     }
// });
