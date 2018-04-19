/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import com.jfoenix.controls.JFXCheckBox;

/**
 *
 * @author User
 */
public class our_all_people {
    
    private String name;
    private String email;
    private String contact;
    private String district;
    private String location;
    private String nid;
    private String register_date;
    private Integer id;
    private JFXCheckBox ck;
    private String approve;

    public our_all_people(String name, String email, String contact, String district, String location, String nid, String register_date, Integer id, JFXCheckBox ck, String approve) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.district = district;
        this.location = location;
        this.nid = nid;
        this.register_date = register_date;
        this.id = id;
        this.ck = ck;
        this.approve = approve;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the nid
     */
    public String getNid() {
        return nid;
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(String nid) {
        this.nid = nid;
    }

    /**
     * @return the register_date
     */
    public String getRegister_date() {
        return register_date;
    }

    /**
     * @param register_date the register_date to set
     */
    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the ck
     */
    public JFXCheckBox getCk() {
        return ck;
    }

    /**
     * @param ck the ck to set
     */
    public void setCk(JFXCheckBox ck) {
        this.ck = ck;
    }

    /**
     * @return the approve
     */
    public String getApprove() {
        return approve;
    }

    /**
     * @param approve the approve to set
     */
    public void setApprove(String approve) {
        this.approve = approve;
    }

    
    
}
