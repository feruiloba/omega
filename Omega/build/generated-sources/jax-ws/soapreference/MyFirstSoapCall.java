
package soapreference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para myFirstSoapCall complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="myFirstSoapCall"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="greeting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="myNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myFirstSoapCall", propOrder = {
    "greeting",
    "myNumber"
})
public class MyFirstSoapCall {

    protected String greeting;
    protected int myNumber;

    /**
     * Obtiene el valor de la propiedad greeting.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * Define el valor de la propiedad greeting.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreeting(String value) {
        this.greeting = value;
    }

    /**
     * Obtiene el valor de la propiedad myNumber.
     * 
     */
    public int getMyNumber() {
        return myNumber;
    }

    /**
     * Define el valor de la propiedad myNumber.
     * 
     */
    public void setMyNumber(int value) {
        this.myNumber = value;
    }

}
