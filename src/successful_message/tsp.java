/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import static level2term2.shop_type_option.valueOf;

/**
 *
 * @author User
 */
public enum tsp {
    PICKUP,MOTORBIKES,TRUCK,CYCLE;

    tsp(){};


    public String value()
    {
        return name();
    }

    public static tsp fromvalue(String v)
    {
        return valueOf(v);
    }
}
