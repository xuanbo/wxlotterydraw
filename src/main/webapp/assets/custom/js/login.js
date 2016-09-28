(function ($) {

    $(function () {
        $('#loginSubmit').on('click', function () {
            var loginName = $('#loginName').val();
            var password = $('#password').val();
            var verificationCode = $('#verificationCode').val();
            var adminInfo = {
                admin: {
                    loginName: loginName,
                    password: password
                },
                verificationCode: verificationCode
            };
            adminInfo = JSON.stringify(adminInfo);
            $.ajax({
                type: 'POST',
                url: '/login',
                contentType: 'application/json',
                dataType: 'json',
                data: adminInfo,
                success: function (result) {
                    if (result.flag) {
                        $("#error").hide();
                        window.location.assign('/admin/index');
                    } else {
                        $("#error").html(result.msg).show();
                    }
                }
            });
        });

        $(".codeImg").on("click", function () {
            $(this).attr("src", "/verificationCode?" + Math.random());
        });
    })

})(jQuery);