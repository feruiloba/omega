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
import javax.ws.rs.QueryParam;
/**
 * REST Web Service
 *
 * @author PLEVERG
 */
@Path("usuario")
public class UserRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DashboardRest
     */
    public UserRest() {
    }

    /**
     * Retrieves representation of an instance of restwebservices.DashboardRest
     * @param request
     * @return an instance of java.lang.String
    
    @GET
    @Produces(MediaType.APPLICATION_XML )
    public String getHtml(@Context HttpServletRequest request) {
        
        //session.invalidate();
        HttpSession session = request.getSession();
        if(session.getAttribute("username") == null){
            return "<user>Session Expired</user>";
        }
        
        String usuario = getUsuario(session.getAttribute("username").toString());
       
        return "<user>"+usuario+"</user>";
    }
    * 
    */
    
    //Para iniciar sesión
    @GET
    @Consumes("text/html")
    @Produces(MediaType.APPLICATION_XML)
    public String getUsuario(@Context HttpServletRequest request, @QueryParam("username") String username, @QueryParam("pass") String pass){//@Context HttpServletRequest request) {
        crearBD("omegaBD","root","root");
        System.out.println("Está creando BD");
        String usuario = getUsuario(username);
        System.out.println("Usuario obtenido: "+usuario);
        
        if (usuario != null && !usuario.equals("NO SE PUDO")) {
            HttpSession mySession = request.getSession();
            mySession.setAttribute("username", username);
        }
        
        return "<username>"+usuario+"</username>";
    }
    
    //Para insertar un usuario
    @POST
    @Consumes("text/html")
    public void postUsuario(@QueryParam("username") String username, @QueryParam("name") String name, @QueryParam("gender") String gender, @QueryParam("pass") String pass, @QueryParam("phone") String phone) {
        
        System.out.println("Está creando BD");
        System.out.println("POST: ");
        System.out.println(username+" "+ name+" "+ gender+" "+pass+" "+ phone);
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
