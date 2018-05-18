/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restwebservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author FRUILOBAP
 */
@Path("tabla")
public class TablaRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DashboardResource
     */
    public TablaRest() {
    }

    /**
     * Retrieves representation of an instance of restwebservices.DashboardResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DashboardResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(@QueryParam("nomTabla") String nomTabla, @QueryParam("valores") String valores, @QueryParam("columnas") String columnas) {
        System.out.println("PUT:");
        System.out.println(valores);
        System.out.println(columnas);
        System.out.println(nomTabla);
        updateTabla(nomTabla, valores, columnas);
    }

    private static Boolean updateTabla(java.lang.String nomTabla, java.lang.String valores, java.lang.String columnas) {
        soapreference.Zote_Service service = new soapreference.Zote_Service();
        soapreference.Zote port = service.getZotePort();
        return port.updateTabla(nomTabla, valores, columnas);
    }
    
    
}
