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
public enum admin_product_catagory {
    LAPTOP,PHONE,TAB,AC,ELECTRICAL,TV,PROJECTOR,CC_TV,CAR,MOTORBIKES;

    admin_product_catagory(){};


    public String value()
    {
        return name();
    }

    public static admin_product_catagory fromvalue(String v)
    {
        return valueOf(v);
    }
}
