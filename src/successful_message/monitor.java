/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import com.jfoenix.controls.JFXCheckBox;

/**
 *
 * @author dell
 */
public class monitor {
    private String supplier_name;
    private String customer_name;
    private String transporter_name;
    private String product_name;
    private Integer money;
    private JFXCheckBox success;
    private Integer trans_id;
    private Integer cust_id;
    private Integer supp_id;
    private Integer amount;
    private Integer ORDER;
    private String date;
    private String DELIVERY;

    public monitor(String supplier_name, String customer_name, String transporter_name, String product_name, Integer money, JFXCheckBox success, Integer trans_id, Integer cust_id, Integer supp_id, Integer amount, Integer ORDER, String date, String DELIVERY) {
        this.supplier_name = supplier_name;
        this.customer_name = customer_name;
        this.transporter_name = transporter_name;
        this.product_name = product_name;
        this.money = money;
        this.success = success;
        this.trans_id = trans_id;
        this.cust_id = cust_id;
        this.supp_id = supp_id;
        this.amount = amount;
        this.ORDER = ORDER;
        this.date = date;
        this.DELIVERY = DELIVERY;
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
     * @return the customer_name
     */
    public String getCustomer_name() {
        return customer_name;
    }

    /**
     * @param customer_name the customer_name to set
     */
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    /**
     * @return the transporter_name
     */
    public String getTransporter_name() {
        return transporter_name;
    }

    /**
     * @param transporter_name the transporter_name to set
     */
    public void setTransporter_name(String transporter_name) {
        this.transporter_name = transporter_name;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * @return the money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * @return the success
     */
    public JFXCheckBox getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(JFXCheckBox success) {
        this.success = success;
    }

    /**
     * @return the trans_id
     */
    public Integer getTrans_id() {
        return trans_id;
    }

    /**
     * @param trans_id the trans_id to set
     */
    public void setTrans_id(Integer trans_id) {
        this.trans_id = trans_id;
    }

    /**
     * @return the cust_id
     */
    public Integer getCust_id() {
        return cust_id;
    }

    /**
     * @param cust_id the cust_id to set
     */
    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    /**
     * @return the supp_id
     */
    public Integer getSupp_id() {
        return supp_id;
    }

    /**
     * @param supp_id the supp_id to set
     */
    public void setSupp_id(Integer supp_id) {
        this.supp_id = supp_id;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return the ORDER
     */
    public Integer getORDER() {
        return ORDER;
    }

    /**
     * @param ORDER the ORDER to set
     */
    public void setORDER(Integer ORDER) {
        this.ORDER = ORDER;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the DELIVERY
     */
    public String getDELIVERY() {
        return DELIVERY;
    }

    /**
     * @param DELIVERY the DELIVERY to set
     */
    public void setDELIVERY(String DELIVERY) {
        this.DELIVERY = DELIVERY;
    }

    
    
    
}
