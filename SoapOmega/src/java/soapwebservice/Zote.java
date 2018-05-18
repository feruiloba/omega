/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapwebservice;


import com.sun.org.apache.xpath.internal.operations.Bool;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author PLEVERG
 */
@WebService(serviceName = "Zote")
@Stateless()
public class Zote {
   static Connection con;
   static String nombrebd, cont, usuario;
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "myFirstSoapCall")
    public String myFirstSoapCall(@WebParam(name = "greeting") String greeting, @WebParam(name = "myNumber") int myNumber) {
        
        
        
       /*
        Acceder a la db para buscar con llave primaria myNumber....
        
        Armar un xml....
        
        regresarlo..
        
        
        */
       
       return greeting + " and the number is " + myNumber ;
    }

    
    
        /**
     * Crear la base de datos
     */
    @WebMethod(operationName = "crearBD")
    public Boolean crearBD(@WebParam(name = "nombrebd") String nombrebd, @WebParam(name = "cont") String cont, @WebParam(name = "usuario") String usuario) {
        boolean resp;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd + ";create=true;", usuario, cont);
            this.nombrebd = nombrebd;
            this.cont = cont;
            this.usuario = usuario;
            
            Statement query = con.createStatement();
            System.out.println("Base de datos creada");
            String QueryString;
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getTables(null, null, null, new String[]{"TABLE"});
            ArrayList<String> tablas = new ArrayList<String>();
            while (res.next()) {
                tablas.add(res.getString("TABLE_NAME"));
            }

            res.close();
            
            if (!tablas.contains("USUARIOS")) {
                QueryString = "create table usuarios (username varchar(25) not null, name varchar(25), gender varchar(20), password varchar(25), phone varchar(20), primary key(username))";
                query.executeUpdate(QueryString);
                System.out.println("Creando usuarios");
            }
            else{
                System.out.println("Tabla usuarios ya existe");
            }
            if(!tablas.contains("TIENE")) {
                QueryString = "create table tiene (username varchar(25) not null, nombre_tabla varchar(25) not null)";
                query.executeUpdate(QueryString);
                System.out.println("Creando tabla tiene");
            }
            else
                System.out.println("Tabla tiene ya existe");
            
            resp= true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            resp= false;
        }
        
        try{
            con.close();
        }catch(Exception e){}
        return resp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuario")
    public String getUsuario(@WebParam(name = "username") String username) {
        String QueryString;
        String resp;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            Statement query = con.createStatement();
            QueryString = "select * from usuarios where username='" + username + "'";
            ResultSet rs = query.executeQuery(QueryString);
            if (!rs.next()) {
                System.out.println("SOAP: Ese usuario no existe");
                return "NO SE PUDO";
            }
            resp= "<usuario>"
                     +"<username>" 
                        +rs.getString("username")
                     +"</username>"
                     +"<name>"
                        +rs.getString("name")
                     +"</name>"
                     +"<gender>"
                        +rs.getString("gender")
                     +"</gender>"
                     +"<phone>"
                        +rs.getString("phone")
                     +"</phone>"
                   + "</usuario>";
                    
        } catch (Exception e) {
            resp= "NO SE PUDO";
        }
        try{
            con.close();
        }catch(Exception e){}
        return resp;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertUsuario")
    public Boolean insertUsuario(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "gender") String gender, @WebParam(name = "pass") String pass, @WebParam(name = "phone") String phone) {
        boolean resp;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            Statement query = con.createStatement();
            String QueryString = "INSERT INTO USUARIOS VALUES ('" + username + "','" + name + "','" + gender + "','" + pass + "','" + phone + "')";
            int res = query.executeUpdate(QueryString);
            resp = true;
        } catch (Exception e) {
            //Luego las imprimimos y asi
            resp = false;
        }
        try{
            con.close();
        }catch(Exception e){}
        return resp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminaUsuario")
    public Boolean eliminaUsuario(@WebParam(name = "username") String username, @WebParam(name = "pass") String pass) {
        boolean resp;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
        Statement query = con.createStatement();
        String QueryString = "DELETE FROM USUARIOS WHERE username='"+ username+"' AND password='"+pass+"'";
        query.executeUpdate(QueryString);
        resp= true;
        }catch(Exception e){
            System.err.println("ERRROOOOR " + e.getMessage());
            resp= false;
        }
        
        try{
            con.close();
        }catch(Exception e){}
        return resp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editaUsuario")
    public String editaUsuario(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "gender") String gender, @WebParam(name = "password") String password, @WebParam(name = "phone") String phone) {
        String resp;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            Statement query = con.createStatement();
            /*
        Si el usuario no quiere cmabiar algo va a ser el mismo al anterior, se guardaran los parametros pasados
             */
            String QueryString = "UPDATE USUARIOS SET password='" + password + "', name='" + name + "', gender='" + gender + "', phone='" + phone + "' WHERE username='" + username + "'";
            query.executeUpdate(QueryString);
            con.close();
            resp = "El usuario:" + username + " Ha sido editado";
        } catch (Exception e) {
            System.err.println("ERRROOOOR " + e.getMessage());
            resp = "Error al editar al usuario";
        }
        try {
            con.close();
        } catch (Exception e) {
        }
        return resp;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuarios")
    public String getUsuarios() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "agregaTabla")
    public Boolean agregaTabla(@WebParam(name = "username") String username, @WebParam(name = "nombre") String nombre, @WebParam(name = "params") String params, @WebParam(name = "tipos") String tipos) {
        //TODO write your implementation code here:
        
        boolean resp;
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            
            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getTables(null, null, null, new String[]{"TABLE"});
            ArrayList<String> tablas = new ArrayList<String>();
            while (res.next()) {
                tablas.add(res.getString("TABLE_NAME"));
            }

            res.close();
            
            if (!tablas.contains(nombre)) {

                String[] parametros = params.split(",");
                String[] type = tipos.split(",");

                StringBuilder addparams = new StringBuilder();
                addparams.append("create table");
                addparams.append(" " + nombre + " (id int not null, ");

                for (int i = 0; i < parametros.length; i++) {
                    addparams.append(parametros[i] + " ");
                    switch (type[i]) {
                        case ("varchar25"):
                            addparams.append("varchar(25),");
                            break;
                        case ("Integer"):
                            addparams.append("int,");
                            break;
                        case ("Double"):
                            addparams.append("double,");
                            break;
                        case ("varchar50"):
                            addparams.append("varchar(50),");
                            break;

                    }
                }
                addparams.append(" primary key(id))");
                System.out.println(addparams.toString());
                //tam parametros = tam type

                Statement query = con.createStatement();
                query.executeUpdate(addparams.toString());
                System.out.println("Se agregó la tabla");
                //crearBD("omegaBD","root","root");
                System.out.println("se va a insertar en tiene: " + username + " y " + nombre);
                String queryTiene = "insert into TIENE values('" + username + "','" + nombre + "')";
                Statement query2 = con.createStatement();
                query2.executeUpdate(queryTiene);
                System.out.println("Si insertó en tiene");
                resp = true;
            }
            else{
                System.out.println("La tabla "+nombre+" ya existe");
                resp = false;
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
            resp = false;
        }
        try{
            con.close();
        }catch(Exception e){}
        return resp;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTabla")
    public String getTabla(@WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        String resp="";
        String QueryString;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            Statement query = con.createStatement();
            
            QueryString = "select * from "+nombre;
            ResultSet rs = query.executeQuery(QueryString);
            
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            System.out.println("Num columnas: "+columnCount);
            int renglones =0;
            while(rs.next()){
                renglones++;
                if(renglones==1){
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.println("Columna " + i + "es: " + metadata.getColumnName(i));
                        resp += metadata.getColumnName(i)+",";
                    }
                    resp+="&";
                }
                for (int i = 1; i <= columnCount; i++) {
                        System.out.println("Columna " + i + "es: " + metadata.getColumnName(i));
                        resp += rs.getString(i)+",";
                }
            }
            if(renglones==0){
                System.out.println("SOAP: Esa tabla no tiene datos");
                resp = "NO HAY DATOS EN ESTA TABLA";
            }
            
            
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            resp = "NO SE PUDO";
        }
        try{con.close();}catch(Exception e){}
        return resp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateTabla")
    public Boolean updateTabla(@WebParam(name = "nomTabla") String nomTabla, @WebParam(name = "valores") String valores, @WebParam(name = "columnas") String columnas) {
        //TODO write your implementation code here:
        System.out.println("SOAP:");
        System.out.println(nomTabla);
        System.out.println(valores);
        System.out.println(columnas);
        
        String[] vals = valores.split(":");
        String[] cols = columnas.split(":");
        String QueryString;
        
        boolean resp;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd, usuario, cont);
            Statement query = con.createStatement();
            /*
        Si el usuario no quiere cmabiar algo va a ser el mismo al anterior, se guardaran los parametros pasados
             */
            QueryString = "UPDATE "+nomTabla+" SET ";
            for(int i=0; i<cols.length; i++){
                QueryString = QueryString + cols[i]+"='" + vals[i] + "', ";
            }
            QueryString = QueryString.substring(0,QueryString.length()-2);
            System.out.println(QueryString);
            
            ResultSet rsColumns = null;
            DatabaseMetaData meta = con.getMetaData();
            rsColumns = meta.getColumns(null, null, nomTabla, null);
            while (rsColumns.next()) {
                System.out.println(rsColumns.getString("TYPE_NAME"));
                System.out.println("Que pasaaa");
            }
            //query.executeUpdate(QueryString);
            con.close();
            resp=true;
        } catch (Exception e) {
            System.err.println("ERRROOOOR " + e.getMessage());
            resp=false;
        }
        try {
            con.close();
        } catch (Exception e) {
        }
        return resp;
        
    }
    

}
