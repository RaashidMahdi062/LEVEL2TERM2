/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import static successful_message.tsp.valueOf;

/**
 *
 * @author User
 */
public enum incdec {
    INCREASE,DECREASE;

    incdec(){};


    public String value()
    {
        return name();
    }

    public static incdec fromvalue(String v)
    {
        return valueOf(v);
    }
}
