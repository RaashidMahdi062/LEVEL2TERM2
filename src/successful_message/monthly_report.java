/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import javafx.scene.control.CheckBox;

/**
 *
 * @author dell
 */
public class monthly_report {
    private String supplier_name;
    private String supplier_location;
    private String shop_name;
    private String shop_type;
    private Integer due_taka;
    private Integer id;
    private CheckBox ck;

    public monthly_report(String supplier_name, String supplier_location, String shop_name, String shop_type, Integer due_taka, Integer id) {
        this.supplier_name = supplier_name;
        this.supplier_location = supplier_location;
        this.shop_name = shop_name;
        this.shop_type = shop_type;
        this.due_taka = due_taka;
        this.id = id;
    }
    
    public monthly_report(String supplier_name, String supplier_location, String shop_name, String shop_type, Integer due_taka, Integer id,CheckBox CK) {
        this.supplier_name = supplier_name;
        this.supplier_location = supplier_location;
        this.shop_name = shop_name;
        this.shop_type = shop_type;
        this.due_taka = due_taka;
        this.id = id;
        this.ck = CK;
    }

    /**
     * @return the supplier_name
     */
    public String getSupplier_name() {
        return supplier_name;
    }

    /**
     * @param supplier_name the supplier_name to set
     */
    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    /**
     * @return the supplier_location
     */
    public String getSupplier_location() {
        return supplier_location;
    }

    /**
     * @param supplier_location the supplier_location to set
     */
    public void setSupplier_location(String supplier_location) {
        this.supplier_location = supplier_location;
    }

    /**
     * @return the shop_name
     */
    public String getShop_name() {
        return shop_name;
    }

    /**
     * @param shop_name the shop_name to set
     */
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    /**
     * @return the shop_type
     */
    public String getShop_type() {
        return shop_type;
    }

    /**
     * @param shop_type the shop_type to set
     */
    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    /**
     * @return the due_taka
     */
    public Integer getDue_taka() {
        return due_taka;
    }

    /**
     * @param due_taka the due_taka to set
     */
    public void setDue_taka(Integer due_taka) {
        this.due_taka = due_taka;
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
    public CheckBox getCk() {
        return ck;
    }

    /**
     * @param ck the ck to set
     */
    public void setCk(CheckBox ck) {
        this.ck = ck;
    }

    

    

    
    
}
