/**
 * Created by Benki on 30.03.2016.
 */

function calcPrice() {
    var name = document.getElementById("name").value;
    var number = document.getElementById("number").value;
    var quad = document.getElementById("quad").value;
    var thick = document.getElementById("thick").value;
    var density = document.getElementById("density").value;
    var gridRadios = $('input[name=gridRadios]:radio:checked').val();

    var sht;

    switch (gridRadios) {

        case "styrofoam":
            if (name == 0 || number == 0 || quad == 0 || thick == 0 || density == 0) {
                $('#price').html('Заполните пожалуйчта пустое поле');
                $('#myModal').modal('show');
                throw "stop";
            }
            if (thick == 5 || thick == 10) {
                console.log("ok")
            } else {
                $('#price').html('Толщина 5 или 10');
                $('#myModal').modal('show');
                throw "stop";
            }
            if (density == 25 || density == 35) {
                console.log("ok")
            } else {
                $('#price').html('Плотность 25 или 35');
                $('#myModal').modal('show');
                throw "stop";
            }
            break;

        case "expanded_polystyrene":
            if (name == 0 || number == 0 || quad == 0 || thick == 0) {
                $('#price').html('Заполните пожалуйчта пустое поле');
                $('#myModal').modal('show');
                throw "stop";
            }
            if (density == 0)density = 1;

            if (thick == 5 || thick == 10 || thick == 3) {
                console.log("ok")
            } else {
                $('#price').html('Толщина 3, 5 или 10');
                $('#myModal').modal('show');
                throw "stop";
            }
            break;

        case "mineral_wool":
            if (name == 0 || number == 0 || quad == 0 || thick == 0) {
                $('#price').html('Заполните пожалуйчта пустое поле');
                $('#myModal').modal('show');
                throw "stop";
            }
            if (density == 0)density = 1;
            if (thick == 5 || thick == 10) {
                console.log("ok")
            } else {
                $('#price').html('Толщина 5 или 10');
                $('#myModal').modal('show');
                throw "stop";
            }
            break;
    }


    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServlet',
            dataType: "json",
            data: {
                name: name,
                number: number,
                quad: quad,
                thick: thick,
                density: density,
                gridRadios: gridRadios
            },
            success: function (data) {
                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.price);
            }
        });
    };
    respoajax(function allhtml() {
        $('#price').html(sht.price + 'грн');
        $('#myModal').modal('show');
    });

};


function passwordClic() {
    var password = document.getElementById("password").value;

    var sht;

    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServletPassword',
            dataType: "json",
            data: {
                password: password


            },
            success: function (data) {

                sht = JSON.parse(JSON.stringify(data))
                callback(data);
                console.log(sht.password);
            }

        });

    };
    respoajax(function allhtml() {

        if (sht.password == "yes") {
            var url = "/admin.html";
            $(location).attr('href', url);
            console.log("ok")
        } else {

            $('#myModal').modal('show');
        }

    });

};


function allall() {
    var sht;

    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServletAll',
            dataType: "json",
            data: {},

            success: function (data) {
                sht = JSON.parse(JSON.stringify(data));
                callback(data);

            }
        });
    };
    respoajax(function allhtml() {

        for (var i = 0; i < sht.count; i++) {
            var row = "<tr ><td>" + sht.name[i] + "</td><td>" + sht.number[i] + "</td><td>" + sht.quad[i] + "</td><td>" + sht.thick[i] + "</td><td>" + sht.material[i] + "</td><td>" + sht.densities[i] + "</td><td>" + sht.price[i] + "</td></tr>";
            $('#bodyTabl').append(row);
        }

    });
};


/*function smska() {
 var sht;

 var name = document.getElementById("name").value;
 var email = document.getElementById("email").value;
 var number = document.getElementById("number").value;
 var sms = document.getElementById("sms").value;

 function respoajax(callback) {
 $.ajax({
 type: 'GET',
 url: 'http://localhost:8080/MyServletAll',
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
 $('#myModal').modal('show');
 });

 };*/













