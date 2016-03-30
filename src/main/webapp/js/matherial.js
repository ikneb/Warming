/**
 * Created by Benki on 30.03.2016.
 */

function calcPrice() {
    var name = document.getElementById("name");
    /*   var email = document.getElementById("email");*/
    var number = document.getElementById("number");
    var quad = document.getElementById("quad");
    var thick = document.getElementById("thick");
    /*    var gridRadios = document.getElementById("gridRadios");*/
    var call = document.getElementById("call");
    var density = document.getElementById("density");
    console.log("ololo");
    $.ajax({
        type: 'GET',
        url: '/',
        dataType: "json",
        data: {
            name: name,
            number: number,
            quad: quad,
            thick: thick,
            call: call,
            density: density

        },
        success: function (data) {
            //тут будет чудо
            console.log(data);
        }
    });
    console.log("ololo123");
}
