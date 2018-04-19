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
public enum search_shop_type_option {
    ALL,ELECTRONICS,ELECTRICAL,GROSSERY,STATIONARY,CAR,MOTORBIKES;

    search_shop_type_option(){};


    public String value()
    {
        return name();
    }

    public static search_shop_type_option fromvalue(String v)
    {
        return valueOf(v);
    }
}
