
package soapreference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para updateTabla complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="updateTabla"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nomTabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="columnas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTabla", propOrder = {
    "nomTabla",
    "valores",
    "columnas"
})
public class UpdateTabla {

    protected String nomTabla;
    protected String valores;
    protected String columnas;

    /**
     * Obtiene el valor de la propiedad nomTabla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomTabla() {
        return nomTabla;
    }

    /**
     * Define el valor de la propiedad nomTabla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomTabla(String value) {
        this.nomTabla = value;
    }

    /**
     * Obtiene el valor de la propiedad valores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValores() {
        return valores;
    }

    /**
     * Define el valor de la propiedad valores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValores(String value) {
        this.valores = value;
    }

    /**
     * Obtiene el valor de la propiedad columnas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnas() {
        return columnas;
    }

    /**
     * Define el valor de la propiedad columnas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnas(String value) {
        this.columnas = value;
    }

}
