/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_tranporter_admin;

/**
 *
 * @author User
 */
public class transporter_table_data {
    
    private String supplier_district;
    private String supplier_location;
    private String shop_name;
    private String customer_district;
    private String customer_location;
    private String product_name;
    private String brand;
    private Integer amount;
    private Integer price;
    private String supplier_status;
    private String customer_status;
    private Integer order_id;

    public transporter_table_data(String supplier_district, String supplier_location, String shop_name, String customer_district, String customer_location, String product_name, String brand, Integer amount, Integer price, String supplier_status, String customer_status, Integer order_id) {
        this.supplier_district = supplier_district;
        this.supplier_location = supplier_location;
        this.shop_name = shop_name;
        this.customer_district = customer_district;
        this.customer_location = customer_location;
        this.product_name = product_name;
        this.brand = brand;
        this.amount = amount;
        this.price = price;
        this.supplier_status = supplier_status;
        this.customer_status = customer_status;
        this.order_id = order_id;
    }

    /**
     * @return the supplier_district
     */
    public String getSupplier_district() {
        return supplier_district;
    }

    /**
     * @param supplier_district the supplier_district to set
     */
    public void setSupplier_district(String supplier_district) {
        this.supplier_district = supplier_district;
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
     * @return the customer_district
     */
    public String getCustomer_district() {
        return customer_district;
    }

    /**
     * @param customer_district the customer_district to set
     */
    public void setCustomer_district(String customer_district) {
        this.customer_district = customer_district;
    }

    /**
     * @return the customer_location
     */
    public String getCustomer_location() {
        return customer_location;
    }

    /**
     * @param customer_location the customer_location to set
     */
    public void setCustomer_location(String customer_location) {
        this.customer_location = customer_location;
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
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return the supplier_status
     */
    public String getSupplier_status() {
        return supplier_status;
    }

    /**
     * @param supplier_status the supplier_status to set
     */
    public void setSupplier_status(String supplier_status) {
        this.supplier_status = supplier_status;
    }

    /**
     * @return the customer_status
     */
    public String getCustomer_status() {
        return customer_status;
    }

    /**
     * @param customer_status the customer_status to set
     */
    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    /**
     * @return the order_id
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    
    
    
    
    
    
}
