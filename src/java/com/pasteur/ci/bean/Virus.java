/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Virus {

    private int idvirus;
    private int enterovirus;
    private boolean visible;
   
    
    public int getIdvirus() {
        return idvirus;
    }

    public void setIdvirus(int idvirus) {
        this.idvirus = idvirus;
    }

    public int getEnterovirus(){
        return enterovirus;
    }

    public void setEnterovirus(int enterovirus) {
        this.enterovirus = enterovirus;
    }

    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
