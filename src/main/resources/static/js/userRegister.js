// 아이디 유효성 검사

let idChk = "";
function inputId(){

    // 아이디 6글자 이상 16이하, 영어/숫자만 가능
    let regId = /^[a-zA-Z0-9]{6,16}$/;
    let id = $("#user_id").val();

    if(id == "") {
        $("#idMsg").text("아이디를 입력해주세요.");
        idChk = false;
        return;
    } else if (false === regId.test(id)) {
        $("#idMsg").text('6자이상~16자이하, 영문/숫자만 사용해주세요.');
        idChk = false;
        return;
    } else {
        $('#idMsg').text("  ");
        idChk = true;
    }
}


// 비밀번호 유효성 검사

let pwChk = "";
function inputPw(){

    // 비밀번호 10글자 이상 20글자 이내, 영어/숫자/특수문자 포함
    let regPw = /^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{10,20}$/;
    let pw = $("#user_pw").val();

    if(pw == "") {
        $("#pwMsg").text("비밀번호를 입력해주세요.");
        pwChk = false;
        return;
    } else if (false === regPw.test(pw)) {
        $("#pwMsg").text('10자이상~20자이하, 영문/숫자/특수문자를 포함하여 사용해주세요.');
        pwChk = false;
        return;
    } else {
        $('#pwMsg').text("  ");
        pwChk = true;
    }
}

// 비밀번호 확인 유효성 검사

let pwConfirm = "";

function inputPwChk() {

    let PwChk = $("#user_pw").val();

    if ($("#user_pw2").val() != PwChk) {
        $("#checkPwMsg").text("동일한 비밀번호를 입력해주세요");
        pwConfirm = false;
        return;
    } else {
        $("#checkPwMsg").text("비밀번호가 일치합니다");
        $("#checkPwMsg").css({"color": "blue", "font-size": "13px"});
        pwConfirm = true;
        return;
    }
}

// 이름 유효성 검사

    let nameChk = "";

    function inputName() {

        // 특수문자,영어,숫자는 사용불가 한글만 입력가능
        let regName = /^[가-힣]{2,15}$/;
        let name = $("#user_name").val();

        if (name == "") {
            $("#nameMsg").text("이름을 입력해주세요.");
            nameChk = false;
            return;
        } else if (false === regName.test(name)) {
            $("#nameMsg").text('2자이상~15자이하의 한글만 입력해주세요.');
            nameChk = false;
            return;
        } else {
            $('#nameMsg').text("  ");
            nameChk = true;
        }
}

// 이메일 유효성 검사

let emailChk = "";

function inputEmail() {

    // 이메일 영문자/숫자/_/./- @ 영문자/숫자/- . 영문자/숫자/-
    let regEmail = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+$/;
    let email = $("#user_email").val();


    if (email == "") {
        $("#emailMsg").text("이메일을 입력해주세요.");
        emailChk = false;
        return;
    } else if (false === regEmail.test(email)) {
        $("#emailMsg").text('올바른 이메일 형식이 아닙니다.');
        emailChk = false;
        return;
    } else {
        $('#emailMsg').text("  ");
        emailChk = true;
    }
}

// 우편번호 유효성 검사

let postCodeChk = "";

function inputPostCode() {


    let postCode = $("#user_postcode").val();


    if (postCode == "") {
        $("#postCodeMsg").text("주소를 입력해주세요.");
        postCodeChk = false;
        return;

    } else {
        $('#postCodeMsg').text("  ");
        postCodeChk = true;
    }
}


// 전화번호 유효성 검사


let telChk = "";

function inputTel() {

    // 이메일 영문자/숫자/_/./- @ 영문자/숫자/- . 영문자/숫자/-
    let regTel = /^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$/;
    let tel = $("#user_tel").val();


    if (tel == "") {
        $("#emailMsg").text("전화번호를 입력해주세요.");
        telChk = false;
        return;
    } else if (false === regTel.test(tel)) {
        $("#telMsg").text('올바른 번호 형식이 아닙니다.');
        telChk = false;
        return;
    } else {
        $('#telMsg').text("  ");
        telChk = true;
    }
}

// 생년월일 유효성 검사

let birthDayChk = "";

function inputBirthDay() {


    let birthDay = $("#user_birthday").val();


    if (birthDay == "") {
        $("#birthDayMsg").html("생년월일을 입력해주세요.");
        $("#birthDayMsg").css({"color": "red", "font-size": "11px"});
        birthDay.focus();
        return;
    }


}