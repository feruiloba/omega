<%-- 
    Document   : index
    Created on : 11/05/2018, 06:00:29 PM
    Author     : PLEVERG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="demo"></div>
        
        <form><!-- action="http://localhost:8080/Omega/webresources/dashboard/usuario" method="GET">-->
            <h1>Iniciar sesion</h1>
            <input id="user" type="text" name="usuario" value="Juan" />
            <input id="cont" type="password" name="cont" value="123" />
            <input type="button" onclick="getUsuario()" value="Iniciar sesión" /><!--onclick="postUsuario()"-->
        </form>

        <form action="http://localhost:8080/Omega/webresources/dashboard/usuario" method="POST">
            <h1>Registrarse</h1>
            <div>
                <input id="username" placeholder="usuario" type="text" name="username" />
            </div>
            <div>
                <input id="pass" placeholder="contraseña" type="password" name="pass" />
            </div>
            <div>
                <input id="name" placeholder="nombre" type="text" name="name" />
            </div>
            <div>
                <input type="radio" name="gender" value="masculino" />Masculino
                <input type="radio" name="gender" value="femenino" />Femenino
                <input type="radio" name="gender" value="noze" />No te digo
            </div>
            <div>
                <input type="number" placeholder="teléfono" name="phone" />
            </div>
            <input type="button" value="Registrarse" /><!--onclick="postUsuario()"-->
        </form>
        
    </body>
    
    <script>
        
        
        function getData(url, handler) {
            var xhttp = new XMLHttpRequest();
            
            xhttp.onreadystatechange = function() {
              if (this.readyState == 4 && this.status == 200) {
 
                handler(xhttp);
                console.log("Hola");
              }
            };
            xhttp.open("GET", url, true);
            xhttp.send();
          }
          
        function postData(url, handler, data) {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
              if (this.readyState == 4 && this.status == 200) {


                    handler(xhttp);

                }
            };

            xhttp.open("POST", url, true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            /* data se pasa en json.
             data = {
             nombre: document.getElementById("nameInput").text,
             apellido: "asdasd"
             }
             */
            console.log(data);
            xhttp.send(JSON.stringify(data));
        }

        function getUsuario() {
            getData("/Omega/webresources/dashboard/usuario", nuevoUsuarioHandler);
        }
        
        function nuevoUsuarioHandler(){
            var xmlDoc = xhr.responseXML;
            var root = xmlDoc.getElementsByTagName("response")[0].childNodes[0].nodeValue;
            document.getElementById("demo").innerHTML = root;
        }
        
    </script>
    
</html>
