/**
 * Created by Benki on 30.03.2016.
 */

function calcPrice() {
    var name = document.getElementById("name").value;
    /*   var email = document.getElementById("email").value;*/
    var number = document.getElementById("number").value;
    var quad = document.getElementById("quad").value;
    var thick = document.getElementById("thick").value;

    /*    var call = document.getElementById("call").value;*/
    var density = document.getElementById("density").value;
    var gridRadios = document.getElementById("gridRadios").value;

    var sht;



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
                gridRadios:gridRadios

            },
            success: function (data) {

                sht=JSON.parse ( JSON.stringify(data) )
                callback(data);
                console.log(sht.price);

            }

        });

    };
    respoajax(function allhtml(){

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

                sht=JSON.parse ( JSON.stringify(data) )
                callback(data);
                console.log(sht.password);

            }

        });

    };
    respoajax(function allhtml(){

       if(sht.password == "yes"){
           var url = "/admin.html";
           $(location).attr('href',url);
           console.log("ok")
       }else {

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
                console.log("olo");
            }
        });
    };
    respoajax(function allhtml() {




    });

};


function smska() {
    var sht;

    function respoajax(callback) {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/MyServletAll',
            dataType: "json",
            data: {name: name,
                email: email,
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

};













