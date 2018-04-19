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
public class supplier_placed_orders {
    private String name;
    private String brand;
    private Integer amount;
    private Integer price;
    private Integer pin;
    private String date;
    private Integer tran_id;
    private Integer order_id;
    private String status;
    private JFXCheckBox ckb;

    public supplier_placed_orders(String name, String brand, Integer amount, Integer price, Integer pin, String date, Integer tran_id, Integer order_id, String status, JFXCheckBox ckb) {
        this.name = name;
        this.brand = brand;
        this.amount = amount;
        this.price = price;
        this.pin = pin;
        this.date = date;
        this.tran_id = tran_id;
        this.order_id = order_id;
        this.status = status;
        this.ckb = ckb;
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
     * @return the pin
     */
    public Integer getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(Integer pin) {
        this.pin = pin;
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
     * @return the tran_id
     */
    public Integer getTran_id() {
        return tran_id;
    }

    /**
     * @param tran_id the tran_id to set
     */
    public void setTran_id(Integer tran_id) {
        this.tran_id = tran_id;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ckb
     */
    public JFXCheckBox getCkb() {
        return ckb;
    }

    /**
     * @param ckb the ckb to set
     */
    public void setCkb(JFXCheckBox ckb) {
        this.ckb = ckb;
    }

    
}
