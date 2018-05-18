/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restwebservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author PLEVERG
 */
@Path("tabla")
public class TablaRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TablaResource
     */
    public TablaRest() {
    }

    /**
     * Retrieves representation of an instance of restwebservices.TablaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @Consumes("text/html")
    public void postUsuario(@QueryParam("username") String username, @QueryParam("params") String params, @QueryParam("types") String tipos, @QueryParam("name") String users) {

        System.out.println("POST: ");
        System.out.println(username+params+tipos+users);
        
        agregaTabla(username,users,params,tipos);
    }
    
    /**
     * PUT method for updating or creating an instance of TablaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    private static Boolean agregaTabla(java.lang.String username, java.lang.String nombre, java.lang.String params, java.lang.String tipos) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.agregaTabla(username, nombre, params, tipos);
    }
    
    
}
