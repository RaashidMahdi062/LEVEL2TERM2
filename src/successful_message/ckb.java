/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package successful_message;

import com.jfoenix.controls.JFXCheckBox;

/**
 *
 * @author User
 */
public class ckb {
    private JFXCheckBox ck1;
    private JFXCheckBox ck2;

    public ckb(JFXCheckBox ck1, JFXCheckBox ck2) {
        this.ck1 = ck1;
        this.ck2 = ck2;
    }

    /**
     * @return the ck1
     */
    public JFXCheckBox getCk1() {
        return ck1;
    }

    /**
     * @param ck1 the ck1 to set
     */
    public void setCk1(JFXCheckBox ck1) {
        this.ck1 = ck1;
    }

    /**
     * @return the ck2
     */
    public JFXCheckBox getCk2() {
        return ck2;
    }

    /**
     * @param ck2 the ck2 to set
     */
    public void setCk2(JFXCheckBox ck2) {
        this.ck2 = ck2;
    }
    
}
