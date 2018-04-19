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
public enum catagory {
    ControlOffice,Employee,Customer,Supplier,Transporter;

    catagory(){};


    public String value()
    {
        return name();
    }

    public static catagory fromvalue(String v)
    {
        return valueOf(v);
    }
}
