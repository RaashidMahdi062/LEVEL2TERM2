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
public enum price_range_all {
    
    FROM_1_TO_1000,FROM_1001_TO_10000,FROM_10001_TO_50000,FROM_50001_TO_300000,FROM_300001_TO_1000000,MORE_THAN_1000001;

    price_range_all(){};


    public String value()
    {
        return name();
    }

    public static price_range_all fromvalue(String v)
    {
        return valueOf(v);
    }
}
