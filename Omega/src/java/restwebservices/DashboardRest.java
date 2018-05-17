/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restwebservices;

import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author PLEVERG
 */
@Path("dashboard")
public class DashboardRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DashboardRest
     */
    public DashboardRest() {
    }

    /**
     * Retrieves representation of an instance of restwebservices.DashboardRest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@Context HttpServletRequest request) {
        //TODO return proper representation object
        
        HttpSession session = request.getSession();
        
        session.setAttribute("username","Paloma");
        //session.invalidate();
        
        if(session.getAttribute("username") == null){
            return "<error>Session Expired</error>";
        }
        
        boolean a = crearBD("omegaBD","root","root");
        System.out.println(a+"");
        
        boolean nuevo = insertUsuario("aguila","Aguilar","femenino","perro","123456");
        String res;
        if(nuevo)
            res="Se creo el nuevo usuario";
        else
            res="No se creo el nuevo usuario";
        String usuario = getUsuario("aguila");
        editaUsuario("aguila","Aguilars","masx","gato","5545434");
        String usuario2 = getUsuario("palo");
        
        return "<root> <nuevo>" + res + "</nuevo>"+ " " +"<nuevo>usuario1:"+usuario+"usuario2:"+usuario2+"</nuevo> </root>";
        /*
        boolean a = crearBD("omegaBD","root","root");
        System.out.println(a+"");
        String usuario = getUsuario("pepemil");
        System.out.println(usuario);
        return usuario;
        */
      /*  String soapResponse = myFirstSoapCall("Aloha", 42);
        

    //    String q = request.getParameter("q");
    //    System.out.println(q);
        
        
        return "<superroot>" + "<response>" + soapResponse + "</response>" + "<otracosa>OTRACOSAA</otracosa>" +  "</superroot>";*/
      
    }

    /**
     * PUT method for updating or creating an instance of DashboardRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void postXml(String content, @PathParam("id") String id) {
        // localhost:8080/Omega/webasdasd/dashboard/78
        
        
        
    }
    
    //Para iniciar sesión
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/usuario")
    public String getUsuario(@Context HttpServletRequest request) {
        String username = request.getParameter("username");
        System.out.println(username);
        String usuario = getUsuario(username);
        if (username != null) {
            HttpSession mySession = request.getSession();
            mySession.setAttribute("username", username);
        }
        return usuario;
    }
    
    //Para insertar un usuario
    @POST
    @Produces("text/html")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Path("/usuario")
    public void postUsuario(@FormParam("username") String username, @FormParam("name") String name, @FormParam("gender") String gender, @FormParam("pass") String pass, @FormParam("phone") String phone) {
        
        boolean insertado = insertUsuario(username, name, gender, pass, phone);
        System.out.println(insertado);
    }
    
    

    private static String myFirstSoapCall(java.lang.String greeting, int myNumber) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.myFirstSoapCall(greeting, myNumber);
    }

    private static Boolean crearBD(java.lang.String nombrebd, java.lang.String cont, java.lang.String usuario) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.crearBD(nombrebd, cont, usuario);
    }

    private static String getUsuario(java.lang.String username) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.getUsuario(username);
    }

    private static Boolean insertUsuario(java.lang.String username, java.lang.String name, java.lang.String gender, java.lang.String pass, java.lang.String phone) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.insertUsuario(username, name, gender, pass, phone);
    }

    private static Boolean eliminaUsuario(java.lang.String username, java.lang.String pass) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.eliminaUsuario(username, pass);
    }

    private static String editaUsuario(java.lang.String username, java.lang.String name, java.lang.String gender, java.lang.String password, java.lang.String phone) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.editaUsuario(username, name, gender, password, phone);
    }
    
    
}
