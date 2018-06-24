function checkPasswordStrength() {
    $.ajax({
        url: 'check_password_strength',
        data: ({password: $('#password').val()}),
        success: function (data) {
            $('#strength-value').html(data);
        }
    });
}