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
public class mysell {
    private String name;
    private String brand;
    private Integer amount;
    private Integer price;
    private String ndate;

    public mysell(String name, String brand, Integer amount, Integer price, String ndate) {
        this.name = name;
        this.brand = brand;
        this.amount = amount;
        this.price = price;
        this.ndate = ndate;
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
     * @return the ndate
     */
    public String getNdate() {
        return ndate;
    }

    /**
     * @param ndate the ndate to set
     */
    public void setNdate(String ndate) {
        this.ndate = ndate;
    }

    
    
}
