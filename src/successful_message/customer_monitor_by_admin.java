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
public class customer_monitor_by_admin {
    
    private Integer id;
    private String name;
    private String district;
    private String road;
    private Integer buy;

    public customer_monitor_by_admin(Integer id, String name, String district, String road, Integer buy) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.road = road;
        this.buy = buy;
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
     * @return the road
     */
    public String getRoad() {
        return road;
    }

    /**
     * @param road the road to set
     */
    public void setRoad(String road) {
        this.road = road;
    }

    /**
     * @return the buy
     */
    public Integer getBuy() {
        return buy;
    }

    /**
     * @param buy the buy to set
     */
    public void setBuy(Integer buy) {
        this.buy = buy;
    }
    
    
    
}
