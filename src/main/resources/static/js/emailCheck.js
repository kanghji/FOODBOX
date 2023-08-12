<!-- 이메일 인증-->
let serverUUID = "";
let isEmailChk = false;
function emailCheck(){
    let uEmail = $("#user_email").val();


    $.ajax({
        url:"/user/emailConfirm",
        type: "get",
        data: {"uEmail":uEmail},
        success: function(ePw){
            if(ePw != "fail"){
                serverUUID = ePw;
                console.log("이메일 인증코드 : " + ePw);
                // $("#confirmEmail").html('<div class="content_box">'
                //     +'<input class="register_content_box" value="인증번호를 입력해주세요." type="text" id="confirmUUID"/></div>'
                //     +'<div>'
                //     +'<span onclick="emailConfirm()"> 인증코드확인</span></div>'
                // $("#confirmEmail").html(
                //     +'<div class="content_box">'
                //     +'<input class="register_content_box" value="인증번호를 입력해주세요." type="text" id="confirmUUID"/></div>'
                //     +'<div class="register_content03">'
                //     +'<div class="content_button">'
                //     +'<span onclick="emailConfirm()">인증코드확인</span></div>'
                //     +'</div>'
                //     +'</div>'
                // );
                $('#confirmEmail').show();
                $("#confirmEmail").html('<div class="register_content01">'
                    +'<span class="must_write03">이메일 인증</span>'
                    +'<span class="must_write04">&ast;</span>'
                    +'</div>'
                    +'<div class="register_content02">'
                    +'<div class="content_box">'
                    +'<input class="register_content_box" type="text" id="confirmUUID" maxLength="16" placeholder="인증번호를 입력해주세요."/>'
                    +'<p class="chkMsg"></p>'
                    +'</div>'
                    +'</div>'
                    +'<div class="register_content03">'
                    +'<div class="content_button">'
                    +'<input class="register_content_button" type="button" onclick="emailConfirm()" value="이메일인증"/>'
                    +'</div>'
                    +'</div>');


            }else{
                alert("이메일을 다시 확인하세요!!");
                $("#user_email").select();
            }
        },
        error:function(){
            alert("인증 실패!!");
        }
    });
}

function emailConfirm(){
    let confirmUUID = $("#confirmUUID").val();

    if(confirmUUID == null || confirmUUID ==""){
        alert("인증 코드 확인하세요!!!");
        $("#confirmUUID").select();
    }else if(serverUUID == confirmUUID){
        alert("인증 성공!!");
        isEmailChk = true;
    }else{
        alert("인증코드를 다시 확인하세요!!");
        $("#confirmUUID").select();
        return;
    }
}
$('#allCheck').click(function(){
    let checked = $('#allCheck').is(':checked');
    if(checked)
        $('input:checkbox').prop('checked',true);
    if(!checked)
        $('input:checkbox').prop('checked',false);
});
$('#ToU').click(function(){
    let touchk = $('#ToU').is(':checked');
    let privacychk = $('#privacy').is(':checked');
    if(touchk&&!privacychk)
        $('#allCheck').prop('checked',false);
    if(!touchk)
        $('#allCheck').prop('checked',false);
    if(touchk&&privacychk)
        $('#allCheck').prop('checked',true);
});
$('#privacy').click(function(){
    let touchk = $('#ToU').is(':checked');
    let privacychk = $('#privacy').is(':checked');
    if(privacychk&&!touchk)
        $('#allCheck').prop('checked',false);
    if(!privacychk)
        $('#allCheck').prop('checked',false);
    if(touchk&&privacychk)
        $('#allCheck').prop('checked',true);
});
function userJoin(){
    // if(idChk=="false") return;
    let ToU = document.getElementById('ToU');
    if(ToU.checked===false) {
        alert("이용약관 동의는 필수사항입니다");
        return;
    }
    document.user_register_form.submit();
}