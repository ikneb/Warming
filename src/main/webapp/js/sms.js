/**
 * Created by Benki on 04.04.2016.
 */
function smska() {
    var sht;

    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var number = document.getElementById("number").value;
    var sms = document.getElementById("sms").value;

    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServletSms',
            dataType: "json",
            data: {name: name,
                email: email,
                number: number,
                sms: sms
            },
            success: function (data) {
                sht = JSON.parse(JSON.stringify(data));
                callback(data);
                console.log("olo");
            }
        });
    };
    respoajax(function allhtml() {
        $('#myM').modal('show');
    });

};
