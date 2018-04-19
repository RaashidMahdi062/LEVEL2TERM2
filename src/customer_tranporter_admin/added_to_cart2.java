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
public class added_to_cart2 {
    private String product_name;
    private String shop_name;
    private String district;
    private String road_location;

    public added_to_cart2(String product_name, String shop_name, String district, String road_location) {
        this.product_name = product_name;
        this.shop_name = shop_name;
        this.district = district;
        this.road_location = road_location;
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
     * @return the road_location
     */
    public String getRoad_location() {
        return road_location;
    }

    /**
     * @param road_location the road_location to set
     */
    public void setRoad_location(String road_location) {
        this.road_location = road_location;
    }
    
    
    
}
