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
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + nombrebd + ";create=true;", usuario, cont);
            Statement query = con.createStatement();

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
            }
            if(!tablas.contains("TIENE")) {
                QueryString = "create table tiene (id_tiene int not null, id_tabla int not null, username varchar(25) not null references usuarios, primary key(id_tiene))";
                query.executeUpdate(QueryString);
            }
            
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuario")
    public String getUsuario(@WebParam(name = "username") String username) {
        String QueryString;
        try {
            Statement query = con.createStatement();
            QueryString = "select * from usuarios where username='" + username + "'";
            ResultSet rs = query.executeQuery(QueryString);
            if (!rs.next()) {
                System.out.println("Ese usuario no existe");
            }
            return "<usuario>"
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

        }
        return "NO SE PUDO";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertUsuario")
    public Boolean insertUsuario(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "gender") String gender, @WebParam(name = "pass") String pass, @WebParam(name = "phone") String phone) {
        
        try {
            Statement query = con.createStatement();
            String QueryString = "INSERT INTO USUARIOS VALUES ('" + username + "','" + name + "','" + gender + "','" + pass + "','" + phone + "')";
            int res = query.executeUpdate(QueryString);
            return true;
        } catch (Exception e) {
            //Luego las imprimimos y asi
            return false;
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminaUsuario")
    public Boolean eliminaUsuario(@WebParam(name = "username") String username, @WebParam(name = "pass") String pass) {
        try{
        Statement query = con.createStatement();
        String QueryString = "DELETE FROM USUARIOS WHERE username='"+ username+"' AND password='"+pass+"'";
        query.executeUpdate(QueryString);
        return true;
        }catch(Exception e){
            System.err.println("ERRROOOOR " + e.getMessage());
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editaUsuario")
    public String editaUsuario(@WebParam(name = "username") String username, @WebParam(name = "name") String name, @WebParam(name = "gender") String gender, @WebParam(name = "password") String password, @WebParam(name = "phone") String phone) {
   try{
        Statement query = con.createStatement();
        /*
        Si el usuario no quiere cmabiar algo va a ser el mismo al anterior, se guardaran los parametros pasados
        */
        String QueryString = "UPDATE USUARIOS SET password='"+password+"', name='"+name+"', gender='"+gender+"', phone='"+phone+"' WHERE username='"+username+"'";
        query.executeUpdate(QueryString);
        return "El usuario:" + username +" Ha sido editado";
        }catch(Exception e){
            System.err.println("ERRROOOOR " + e.getMessage());
            return "Error al editar al usuario";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuarios")
    public String getUsuarios() {
        //TODO write your implementation code here:
        return null;
    }


}
