<%-- 
    Document   : include2
    Created on : 18/05/2018, 01:31:22 PM
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
        <TITLE> Add/Remove dynamic rows in HTML table </TITLE>

        
        <script>
    function addRow(tableID) {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);
        
        var cell2 = row.insertCell(1);
        cell2.innerHTML = rowCount ;

        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text"; 
        element2.name = "txtbox[]";
        cell3.appendChild(element2);

        var cell4 = row.insertCell(3);
        var element3 = document.createElement("select");
        element3.name = "tipos";
        var option  = document.createElement('option');
        var option1 = document.createElement('option');
        var option2 = document.createElement('option');
        var option3 = document.createElement('option');
        var option4 = document.createElement('option');
        option.text   = "varchar25" ;
        option.value  = "varchar25" ;
        option1.text  = "varchar50" ;
        option1.value = "varchar50" ;
        option2.text  = "Integer" ;
        option2.value = "Integer" ;
        option3.text  = "Double"  ;
        option3.value = "Double"  ;
        option4.text  = "boolean" ;
        option4.value = "boolean" ;
        element3.add (option,0);
        element3.add (option1,1);
        element3.add (option2,2);
        element3.add (option3,3);
        element3.add (option4,4);
        cell4.appendChild(element3);
 }

    function deleteRow(tableID) {
        try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if(null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
          }
        }
      }catch(e) {
            alert(e);
        }
    }
          
      
          
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
    var postTabla = function(params, types) {
                /*
                var genders = document.getElementsByName("gender");
                var i = 0;
                while(!genders[i].checked)
                    i++;
                var selected = genders[i].value;
        */
                var data = {
                    params: '',
                    types: '',
                    name: document.getElementById("nombretablas").value,
                    username: document.getElementById("usuario").innerHTML
                };
                for(var p in params){
                    data.params += params[p] + ',' ;
                    data.types += types[p] + ',';
                }
                data.params = data.params.substring(0, data.params.length -1);
                data.types = data.types.substring(0, data.types.length -1);
                /*
                var data = {
                    username: document.getElementById("username").value,
                    name: document.getElementById("name").value,
                    gender: selected,
                    pass: document.getElementById("pass").value,
                    phone: document.getElementById("phone").value
                };
                */
                //console.log(data);
                sendData("/Omega/webresources/tabla", postTablaHandler, data, "POST");
            }
            
    function postTablaHandler(xhr) {
        var xmlDoc = xhr.responseXML;
        console.log(xmlDoc);
        var root = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
        document.getElementById("demo").innerHTML = root;
    }
          
    function createStrings(tableID){
        try {
            var table = document.getElementById('dataTable'); 
            var params = [];
            var types = []; 

            for(var r in table.rows){ 
                    if(['length', 'item', 'namedItem'].indexOf(r) == -1 && r > 0){  
                    if(table.rows[r].cells[2].childNodes[0].value && table.rows[r].cells[3].childNodes[0].value){ 
                            params.push(table.rows[r].cells[2].childNodes[0].value); 
                            types.push(table.rows[r].cells[3].childNodes[0].value);
                                    }
                                }
                            }
                            console.log(params, types);
                            postTabla(params, types);
                        } catch (e) {
                            alert(e);
                        }
        }
        
        </script>

        <INPUT type="button" value="Add Row" onclick="addRow('dataTable')" />
        <INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" />

        <TABLE id="dataTable" width="350px" border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>#</th>
                    <th>Parametro </th>
                    <th>Tipo</th>
                </tr>
            </thead>" 
        </TABLE>

        <br>   
        Nombre de la tabla: <INPUT type="text" name="tablename" id="nombretablas" />
        <INPUT type="button" value="Create" onclick="createStrings('dataTable')" />


        
    </body>
</html>
