
package ru.trandefil.tm.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for command complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="command"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="projectList" type="{http://generated.tm.trandefil.ru/}project" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="taskList" type="{http://generated.tm.trandefil.ru/}task" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="userList" type="{http://generated.tm.trandefil.ru/}user" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "command", propOrder = {
    "projectList",
    "taskList",
    "userList"
})
public class Domain {

    @XmlElement(nillable = true)
    protected List<Project> projectList;
    @XmlElement(nillable = true)
    protected List<Task> taskList;
    @XmlElement(nillable = true)
    protected List<User> userList;

    /**
     * Gets the value of the projectList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the projectList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProjectList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Project }
     * 
     * 
     */
    public List<Project> getProjectList() {
        if (projectList == null) {
            projectList = new ArrayList<Project>();
        }
        return this.projectList;
    }

    /**
     * Gets the value of the taskList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Task }
     * 
     * 
     */
    public List<Task> getTaskList() {
        if (taskList == null) {
            taskList = new ArrayList<Task>();
        }
        return this.taskList;
    }

    /**
     * Gets the value of the userList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link User }
     * 
     * 
     */
    public List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<User>();
        }
        return this.userList;
    }

}
