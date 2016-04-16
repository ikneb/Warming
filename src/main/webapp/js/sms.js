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
        jQuery.ajax({
            type: 'GET',
            url: 'http://warming.herokuapp.com/MyServletSms',
            dataType: "json",
            data: {
                name: name,
                email: email,
                number: number,
                sms: sms

            },
            success: function (data) {

                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.password);
            }

        });

    };


    respoajax( function allhtml() {
        jQuery('#myM').modal('show');
    });

};






function readSms() {
    var sht;
    function respoajax(callback) {
        jQuery.ajax({
            type: 'GET',
            url: 'http://warming.herokuapp.com/MyServletRead',
            dataType: "json",
            data: {


            },
            success: function (data) {

                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.password);
            }

        });

    };
    respoajax(function allhtml() {
        for (var i = 0; i < sht.count; i++) {
            var row = "<tr ><td>" + sht.name[i] + "</td><td>" + sht.email[i] + "</td><td>" + sht.number[i] + "</td><td>" + sht.sms[i] + "</td></tr>";
            jQuery('#bodySms').append(row);
        }
    });
};

function deleteSms() {
    var sht;
    function respoajax(callback) {
        jQuery.ajax({
            type: 'GET',
            url: 'http://warming.herokuapp.com/MyServletDelete',
            dataType: "json",
            data: {


            },
            success: function (data) {

                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.password);
            }

        });

    };
    respoajax(function allhtml() {
        jQuery('#bodySms').html('');
        jQuery('#myDelete').modal('show');
    });
};


