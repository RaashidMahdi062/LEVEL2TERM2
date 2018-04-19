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
public enum pin_catagory {
    
    CUSTOMER,SUPPLIER;
    pin_catagory(){};


    public String value()
    {
        return name();
    }

    public static pin_catagory fromvalue(String v)
    {
        return valueOf(v);
    }
    
}
