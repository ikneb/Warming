/**
 * Created by Benki on 30.03.2016.
 */

function calcPrice() {
    var name = document.getElementById("name").value;
    /*   var email = document.getElementById("email").value;*/
    var number = document.getElementById("number").value;
    var quad = document.getElementById("quad").value;
    var thick = document.getElementById("thick").value;
    /*    var gridRadios = document.getElementById("gridRadios").value;*/
    /*    var call = document.getElementById("call").value;*/
    var density = document.getElementById("density").value;
    var gridRadios = document.getElementById("gridRadios").value;

    var sht;
    var repl;


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