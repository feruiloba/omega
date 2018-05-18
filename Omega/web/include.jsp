<%-- 
    Document   : include
    Created on : 18/05/2018, 01:21:27 PM
    Author     : FRUILOBAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 id="demo">Hello World!</h1>
        <script>
            
            function sendData(url, handler, data, type) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        handler(xhttp);
                    }
                };
                
                url = url + "?";
                for(var key in data){
                    url = url + key + "=" + data[key] + "&";
                }
                url = url.substring(0, url.length - 1);
                console.log(url);
                xhttp.open(type, url, true);
                xhttp.setRequestHeader("Content-type", "text/html");
                xhttp.send();
            }

            var putTabla = function(data) {
                //console.log("Picado!");
                /*
                var data = {
                    username: document.getElementById("user").value,
                    pass: document.getElementById("cont").value
                };
                */
                sendData("/Omega/webresources/tabla", putTablaHandler, data, "PUT");
            };

            function putTablaHandler(xhr) {
                var xmlDoc = xhr.responseXML;
                console.log(xmlDoc);
                var user = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                if(user!=="NO SE PUDO"){
                    document.getElementById("extae").submit();
                }
                document.getElementById("demo").innerHTML = user;
            }
            
            
            function editaTabla(nomTabla, numero){
                var tamCells = document.getElementById("tabla").rows[numero+1].cells.length-1;
                var valores = "";
                var columnas = "";
                //console.log(document.getElementById("header").rows[0].cells[1].childNodes[0]);
                for(var i=0; i<tamCells; i++){
                    valores = valores + document.getElementById("tabla").rows[numero+1].cells[i].childNodes[0].value +":";
                    columnas = columnas + document.getElementById("tabla").rows[0].cells[i].childNodes[0].textContent +":";
                }
                data={nomTabla: nomTabla, valores: valores, columnas: columnas};
                putTabla(data);
            }
        </script>
    </body>
</html>
