/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package level2term2;

/**
 *
 * @author User
 */
public enum shop_type_option {
    ELECTRONICS,ELECTRICAL,GROSSERY,STATIONARY,CAR,MOTORBIKES;

    shop_type_option(){};


    public String value()
    {
        return name();
    }

    public static shop_type_option fromvalue(String v)
    {
        return valueOf(v);
    }
}
