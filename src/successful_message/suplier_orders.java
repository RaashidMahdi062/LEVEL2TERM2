/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

/**
 *
 * @author User
 */
public class suplier_orders {
    private String NAME;
    private String BRAND;
    private Integer AMOUNT;
    private Integer PRICE;
    private Integer PIN;
    private String DATE;

    public suplier_orders(String NAME, String BRAND, Integer AMOUNT, Integer PRICE, Integer PIN, String DATE) {
        this.NAME = NAME;
        this.BRAND = BRAND;
        this.AMOUNT = AMOUNT;
        this.PRICE = PRICE;
        this.PIN = PIN;
        this.DATE = DATE;
    }

    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @param NAME the NAME to set
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return the BRAND
     */
    public String getBRAND() {
        return BRAND;
    }

    /**
     * @param BRAND the BRAND to set
     */
    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    /**
     * @return the AMOUNT
     */
    public Integer getAMOUNT() {
        return AMOUNT;
    }

    /**
     * @param AMOUNT the AMOUNT to set
     */
    public void setAMOUNT(Integer AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * @return the PRICE
     */
    public Integer getPRICE() {
        return PRICE;
    }

    /**
     * @param PRICE the PRICE to set
     */
    public void setPRICE(Integer PRICE) {
        this.PRICE = PRICE;
    }

    /**
     * @return the PIN
     */
    public Integer getPIN() {
        return PIN;
    }

    /**
     * @param PIN the PIN to set
     */
    public void setPIN(Integer PIN) {
        this.PIN = PIN;
    }

    /**
     * @return the DATE
     */
    public String getDATE() {
        return DATE;
    }

    /**
     * @param DATE the DATE to set
     */
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }
    
}
