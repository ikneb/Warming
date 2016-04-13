/**
 * Created by Benki on 04.04.2016.
 */
function smska() {
    var sht;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var number = document.getElementById("number").value;
    var sms = document.getElementById("sms").value;
    responseAjax("MyServletSms", {
        name: name,
        email: email,
        number: number,
        sms: sms
    }, function allhtml() {
        $('#myM').modal('show');
    });

};

function readSms() {
    var sht;
    responseAjax("MyServletRead", {}, function allhtml() {
        for (var i = 0; i < sht.count; i++) {
            var row = "<tr ><td>" + sht.name[i] + "</td><td>" + sht.email[i] + "</td><td>" + sht.number[i] + "</td><td>" + sht.sms[i] + "</td></tr>";
            $('#bodySms').append(row);
        }
    });
};

function deleteSms() {
    var sht;
    responseAjax('MyServletDelete', {}, function allhtml() {
        $('#bodySms').html('');
        $('#myDelete').modal('show');
    });
};

function responseAjax(type, data, callback) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/' + "type",
        dataType: "json",
        data: data,
        success: function (data) {
            sht = JSON.parse(JSON.stringify(data));
            callback(data);
        }
    });
};


