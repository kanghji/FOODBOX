

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

// 새 비밀번호 유효성 검사

let newPwChk = "";

function inputNewPw(){

    // 비밀번호 10글자 이상, 영어/숫자/특수문자 포함
    let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{10,}$/;
    let newPw = $("#new_pw").val();

    if(newPw == "") {
        $("#newPwMsg").text("새 비밀번호를 입력해주세요");
        newPwChk = false;
    } else if (false === reg.test(newPw)) {
        $("#newPwMsg").text('최소 10글자 이상이어야하며, 영문/숫자/특수문자를 포함해야합니다');
        newPwChk = false;
    } else {
        $("#newPwMsg").text("");
        newPwChk = true;
    }
}


// 새 비밀번호 확인 유효성 검사

let pwConfirm = "";

function inputNewPwChk() {
    let newPwChk = $("#new_pw_chk").val();

    if ($("#new_pw").val() != newPwChk) {
        $("#checkPwMsg").text("동일한 비밀번호를 입력해주세요");
        pwConfirm = false;
        return;
    } else {
        $("#checkPwMsg").text("비밀번호가 일치합니다");
        $("#checkPwMsg").css({"color":"blue", "font-size":"13px"});
        pwConfirm = true;
        return;
    }

}

// 새 비밀번호 변경

function pwModifyBtn(user_id) {
        // let new_pw = $("#new_pw").val().trim();
        let new_pw = document.getElementById('new_pw').value;
        // let user_id = document.getElementById('header_userId').text;
        let user = {user_id: user_id, new_pw: new_pw};
        // alert(user);
        // alert(new_pw);
        // alert(JSON.stringify(user));
        // alert(user_id);

        $.ajax({
            url: '/user/user_pwModify',
            type: 'post',
            data: JSON.stringify(user),
            contentType: 'application/json; charset=utf8',
            success: function (result) {
                if (result > 0) {
                    alert("비밀번호가 변경되었습니다");
                    location.href = "/user/user_pwUpdataChkPage";
                }
            },
            error:function(){alert("비밀번호 변경 요청 실패");}
        });
}
