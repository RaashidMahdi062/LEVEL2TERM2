/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

/**
 *
 * @author dell
 */
public class productwisereport {
    private String PRODUCT;
    private String BRAND;
    private Integer SELL;
    private String CATAGORY;
    private Integer PRICE;

    public productwisereport(String PRODUCT, String BRAND, Integer SELL, String CATAGORY, Integer PRICE) {
        this.PRODUCT = PRODUCT;
        this.BRAND = BRAND;
        this.SELL = SELL;
        this.CATAGORY = CATAGORY;
        this.PRICE = PRICE;
    }

    /**
     * @return the PRODUCT
     */
    public String getPRODUCT() {
        return PRODUCT;
    }

    /**
     * @param PRODUCT the PRODUCT to set
     */
    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
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
     * @return the SELL
     */
    public Integer getSELL() {
        return SELL;
    }

    /**
     * @param SELL the SELL to set
     */
    public void setSELL(Integer SELL) {
        this.SELL = SELL;
    }

    /**
     * @return the CATAGORY
     */
    public String getCATAGORY() {
        return CATAGORY;
    }

    /**
     * @param CATAGORY the CATAGORY to set
     */
    public void setCATAGORY(String CATAGORY) {
        this.CATAGORY = CATAGORY;
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

    
    
    
}


