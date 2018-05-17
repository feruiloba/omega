
package soapreference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para crearBD complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="crearBD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombrebd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cont" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearBD", propOrder = {
    "nombrebd",
    "cont",
    "usuario"
})
public class CrearBD {

    protected String nombrebd;
    protected String cont;
    protected String usuario;

    /**
     * Obtiene el valor de la propiedad nombrebd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrebd() {
        return nombrebd;
    }

    /**
     * Define el valor de la propiedad nombrebd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrebd(String value) {
        this.nombrebd = value;
    }

    /**
     * Obtiene el valor de la propiedad cont.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCont() {
        return cont;
    }

    /**
     * Define el valor de la propiedad cont.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCont(String value) {
        this.cont = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
