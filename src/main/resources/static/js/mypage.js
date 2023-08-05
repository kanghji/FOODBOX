

$(function (){
    // 마이페이지 클릭 이벤트
    $(".mypage .mypage__submenu").hide();
    $(".mypage").click(function (){
        $(".mypage .mypage__submenu").toggle();
    });
});

// 비밀번호 재확인 버튼 클릭 이벤트
function userInfoBtn() {

    let pwInput = $("#user_pw_input").val();
    let userDTO = $("#user_pw_db").val();

    // 비밀번호를 입력하지 않은 경우
    if (!pwInput|| pwInput.trim() == "") {
        alert("현재 비밀번호를 입력해주세요");
        $("#user_pw_input").focus();
        return;
    }
    // 입력한 비밀번호와 데이터에 저장된 비밀번호 불일치 여부
    if (pwInput != userDTO) {
        alert("비밀번호가 일치하지 않습니다");
        $("#user_pw_input").focus();
        return;
    }
    // 일치하면 비밀번호 변경 페이지로 이동
    document.userinfo_input.submit();

}

// 회원정보 수정 유효성 검사



