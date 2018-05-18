/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restwebservices;

import java.io.Serializable;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * REST Web Service
 *
 * @author FRUILOBAP
 */
@Path("asdasd")
public class JSONRest {
    
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Data implements Serializable{
        public String params;
        public String types;

        public Data() {
        }
                
        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }

        public String getTypes() {
            return types;
        }

        public void setTypes(String types) {
            this.types = types;
        }

        
        
    }

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DashboardResource
     */
    public JSONRest() {
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
    
    @POST
    @Consumes(MediaType.TEXT_HTML)
    public void postTabla(Data data) {
        
        System.out.println("Está creando BD");
        System.out.println("POST: ");
        System.out.println("" + data);
        //boolean insertado = insertUsuario(username, name, gender, pass, phone);
        //System.out.println(insertado);
    }
    
    /**
     * PUT method for updating or creating an instance of DashboardResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
        
        
    }
}
