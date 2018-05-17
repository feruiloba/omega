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
@Path("usuario")
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
    @Produces(MediaType.APPLICATION_XML)
    public String getUsuario(@Context HttpServletRequest request) {
        crearBD("omegaBD","root","root");
        
        String username = request.getParameter("usuario");
        String pass = request.getParameter("cont");
        
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("pass",pass);
        
        String usuario = getUsuario(username);
        System.out.println(usuario);
        if (username != null) {
            HttpSession mySession = request.getSession();
            mySession.setAttribute("username", username);
        }
        
        return "<username>"+usuario+"</username>";
    }
    
    //Para insertar un usuario
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postUsuario(@FormParam("username") String username, @FormParam("name") String name, @FormParam("gender") String gender, @FormParam("pass") String pass, @FormParam("phone") String phone) {
        crearBD("omegaBD","root","root");
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
