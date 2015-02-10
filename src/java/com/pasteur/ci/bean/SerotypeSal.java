/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class SerotypeSal {
    private int idserotype_sal;
    private String design_serotype;
    private boolean visible;

    public int getIdserotype_sal() {
        return idserotype_sal;
    }

    public void setIdserotype_sal(int idserotype_sal) {
        this.idserotype_sal = idserotype_sal;
    }

    public String getDesign_serotype() {
        return design_serotype;
    }

    public void setDesign_serotype(String design_serotype) {
        this.design_serotype = design_serotype;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
