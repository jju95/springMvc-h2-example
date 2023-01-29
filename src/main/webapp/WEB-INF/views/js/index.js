function formPost(){
    validatePassword();
    let formData = $("#joinForm").serialize();

    $.post("/member/register"),
        {formData},
        function (data, status){
            alert("회원가입 성공하였습니다. ");
        }

}
