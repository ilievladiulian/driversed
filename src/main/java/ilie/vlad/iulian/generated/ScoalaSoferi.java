//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.12 at 11:18:42 PM EET 
//


package ilie.vlad.iulian.generated;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for scoalaSoferi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="scoalaSoferi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informatie" type="{}informatie"/&gt;
 *         &lt;element name="studenti" type="{}studenti"/&gt;
 *         &lt;element name="instructori" type="{}instructori"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scoalaSoferi", propOrder = {
    "informatie",
    "studenti",
    "instructori"
})
@XmlRootElement(name = "scoalaSoferi")
public class ScoalaSoferi {

    @XmlElement(required = true)
    protected Informatie informatie;
    @XmlElement(required = true)
    protected Studenti studenti;
    @XmlElement(required = true)
    protected Instructori instructori;

    /**
     * Gets the value of the informatie property.
     * 
     * @return
     *     possible object is
     *     {@link Informatie }
     *     
     */
    public Informatie getInformatie() {
        return informatie;
    }

    /**
     * Sets the value of the informatie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Informatie }
     *     
     */
    public void setInformatie(Informatie value) {
        this.informatie = value;
    }

    /**
     * Gets the value of the studenti property.
     * 
     * @return
     *     possible object is
     *     {@link Studenti }
     *     
     */
    public Studenti getStudenti() {
        return studenti;
    }

    /**
     * Sets the value of the studenti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Studenti }
     *     
     */
    public void setStudenti(Studenti value) {
        this.studenti = value;
    }

    /**
     * Gets the value of the instructori property.
     * 
     * @return
     *     possible object is
     *     {@link Instructori }
     *     
     */
    public Instructori getInstructori() {
        return instructori;
    }

    /**
     * Sets the value of the instructori property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instructori }
     *     
     */
    public void setInstructori(Instructori value) {
        this.instructori = value;
    }

}