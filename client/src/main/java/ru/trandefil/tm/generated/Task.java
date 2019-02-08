
package ru.trandefil.tm.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for task complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="task"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://generated.tm.trandefil.ru/}baseEntity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="assignee" type="{http://generated.tm.trandefil.ru/}user" minOccurs="0"/&gt;
 *         &lt;element name="begin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="executer" type="{http://generated.tm.trandefil.ru/}user" minOccurs="0"/&gt;
 *         &lt;element name="project" type="{http://generated.tm.trandefil.ru/}project" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "task", propOrder = {
    "assignee",
    "begin",
    "description",
    "end",
    "executer",
    "project"
})
public class Task
    extends BaseEntity
{

    protected User assignee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar begin;
    protected String description;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar end;
    protected User executer;
    protected Project project;

    /**
     * Gets the value of the assignee property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getAssignee() {
        return assignee;
    }

    /**
     * Sets the value of the assignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setAssignee(User value) {
        this.assignee = value;
    }

    /**
     * Gets the value of the begin property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBegin() {
        return begin;
    }

    /**
     * Sets the value of the begin property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBegin(XMLGregorianCalendar value) {
        this.begin = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the executer property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getExecuter() {
        return executer;
    }

    /**
     * Sets the value of the executer property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setExecuter(User value) {
        this.executer = value;
    }

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link Project }
     *     
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link Project }
     *     
     */
    public void setProject(Project value) {
        this.project = value;
    }

}
