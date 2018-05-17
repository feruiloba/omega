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

        
        <h1>Aplicación Omega!</h1>
        <div id="demo"></div>
        
        <form><!-- action="http://localhost:8080/Omega/webresources/dashboard/usuario" method="GET">-->
            <h1>Iniciar sesion</h1>
            <input id="user" type="text" name="usuario" value="Juan" />
            <input id="cont" type="password" name="cont" value="123" />
            <input id="log" type="button" onclick="getUsuario()" value="Iniciar sesión" />
        </form>

        <form><!-- action="http://localhost:8080/Omega/webresources/usuario" method="POST">-->
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
                <input id="phone" type="number" placeholder="teléfono" />
            </div>
            <input id="reg" type="button" onclick="postUsuario()" value="Registrarse" /><!--onclick="postUsuario()"-->
        </form>
        
        
        
        <script>
        
            function getData(url, handler) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        handler(xhttp);
                    }
                };
                xhttp.open("GET", url, true);
                xhttp.send();
            }

            function postData(url, handler, data) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        handler(xhttp);
                    }
                };

                xhttp.open("POST", url, true);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                console.log(data);
                xhttp.send(JSON.stringify(data));
            }

            var getUsuario = function() {
                //console.log("Picado!");
                getData("/Omega/webresources/usuario", getUsuarioHandler);
            };

            function getUsuarioHandler(xhr) {
                var xmlDoc = xhr.responseXML;
                console.log(xmlDoc  );
                var root = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                document.getElementById("demo").innerHTML = root;
            }
            
            var postUsuario = function() {
                var genders = document.getElementsByName("gender");
                var i = 0;
                while(!genders[i].checked)
                    i++;
                var selected = genders[i].value;
                data = {
                    username: document.getElementById("username").value,
                    name: document.getElementById("name").value,
                    gender: selected,
                    phone: document.getElementById("phone").value
                };
                console.log(data);
                postData("/Omega/webresources/usuario", postUsuarioHandler,data);
            };
            
            function postUsuarioHandler(xhr) {
                var xmlDoc = xhr.responseXML;
                console.log(xmlDoc  );
                var root = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                document.getElementById("demo").innerHTML = root;
            }
            
        </script>
        
    </body>
    
    
    
</html>
