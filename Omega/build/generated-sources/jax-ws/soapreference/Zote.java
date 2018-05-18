
package soapreference;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Zote", targetNamespace = "http://soapwebservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Zote {


    /**
     * 
     * @param nombrebd
     * @param usuario
     * @param cont
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "crearBD", targetNamespace = "http://soapwebservice/", className = "soapreference.CrearBD")
    @ResponseWrapper(localName = "crearBDResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.CrearBDResponse")
    @Action(input = "http://soapwebservice/Zote/crearBDRequest", output = "http://soapwebservice/Zote/crearBDResponse")
    public Boolean crearBD(
        @WebParam(name = "nombrebd", targetNamespace = "")
        String nombrebd,
        @WebParam(name = "cont", targetNamespace = "")
        String cont,
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsuario", targetNamespace = "http://soapwebservice/", className = "soapreference.GetUsuario")
    @ResponseWrapper(localName = "getUsuarioResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.GetUsuarioResponse")
    @Action(input = "http://soapwebservice/Zote/getUsuarioRequest", output = "http://soapwebservice/Zote/getUsuarioResponse")
    public String getUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username);

    /**
     * 
     * @param password
     * @param gender
     * @param phone
     * @param name
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editaUsuario", targetNamespace = "http://soapwebservice/", className = "soapreference.EditaUsuario")
    @ResponseWrapper(localName = "editaUsuarioResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.EditaUsuarioResponse")
    @Action(input = "http://soapwebservice/Zote/editaUsuarioRequest", output = "http://soapwebservice/Zote/editaUsuarioResponse")
    public String editaUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "gender", targetNamespace = "")
        String gender,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "phone", targetNamespace = "")
        String phone);

    /**
     * 
     * @param gender
     * @param pass
     * @param phone
     * @param name
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertUsuario", targetNamespace = "http://soapwebservice/", className = "soapreference.InsertUsuario")
    @ResponseWrapper(localName = "insertUsuarioResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.InsertUsuarioResponse")
    @Action(input = "http://soapwebservice/Zote/insertUsuarioRequest", output = "http://soapwebservice/Zote/insertUsuarioResponse")
    public Boolean insertUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "gender", targetNamespace = "")
        String gender,
        @WebParam(name = "pass", targetNamespace = "")
        String pass,
        @WebParam(name = "phone", targetNamespace = "")
        String phone);

    /**
     * 
     * @param pass
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminaUsuario", targetNamespace = "http://soapwebservice/", className = "soapreference.EliminaUsuario")
    @ResponseWrapper(localName = "eliminaUsuarioResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.EliminaUsuarioResponse")
    @Action(input = "http://soapwebservice/Zote/eliminaUsuarioRequest", output = "http://soapwebservice/Zote/eliminaUsuarioResponse")
    public Boolean eliminaUsuario(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "pass", targetNamespace = "")
        String pass);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://soapwebservice/", className = "soapreference.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.HelloResponse")
    @Action(input = "http://soapwebservice/Zote/helloRequest", output = "http://soapwebservice/Zote/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param greeting
     * @param myNumber
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "myFirstSoapCall", targetNamespace = "http://soapwebservice/", className = "soapreference.MyFirstSoapCall")
    @ResponseWrapper(localName = "myFirstSoapCallResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.MyFirstSoapCallResponse")
    @Action(input = "http://soapwebservice/Zote/myFirstSoapCallRequest", output = "http://soapwebservice/Zote/myFirstSoapCallResponse")
    public String myFirstSoapCall(
        @WebParam(name = "greeting", targetNamespace = "")
        String greeting,
        @WebParam(name = "myNumber", targetNamespace = "")
        int myNumber);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsuarios", targetNamespace = "http://soapwebservice/", className = "soapreference.GetUsuarios")
    @ResponseWrapper(localName = "getUsuariosResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.GetUsuariosResponse")
    @Action(input = "http://soapwebservice/Zote/getUsuariosRequest", output = "http://soapwebservice/Zote/getUsuariosResponse")
    public String getUsuarios();

    /**
     * 
     * @param tipos
     * @param params
     * @param nombre
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "agregaTabla", targetNamespace = "http://soapwebservice/", className = "soapreference.AgregaTabla")
    @ResponseWrapper(localName = "agregaTablaResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.AgregaTablaResponse")
    @Action(input = "http://soapwebservice/Zote/agregaTablaRequest", output = "http://soapwebservice/Zote/agregaTablaResponse")
    public Boolean agregaTabla(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "params", targetNamespace = "")
        String params,
        @WebParam(name = "tipos", targetNamespace = "")
        String tipos);

    /**
     * 
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTabla", targetNamespace = "http://soapwebservice/", className = "soapreference.GetTabla")
    @ResponseWrapper(localName = "getTablaResponse", targetNamespace = "http://soapwebservice/", className = "soapreference.GetTablaResponse")
    @Action(input = "http://soapwebservice/Zote/getTablaRequest", output = "http://soapwebservice/Zote/getTablaResponse")
    public String getTabla(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

}
