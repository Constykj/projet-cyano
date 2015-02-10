/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class Salmonelles {
    
    private int idsalmonelle;
    private String design_salmonelle;

    public String getIdserotype_sal() {
        return idserotype_sal;
    }

    public void setIdserotype_sal(String idserotype_sal) {
        this.idserotype_sal = idserotype_sal;
    }
 
    private String idserotype_sal;
    private boolean visible;

    public int getIdsalmonelle() {
        return idsalmonelle;
    }

    public void setIdsalmonelle(int idsalmonelle) {
        this.idsalmonelle = idsalmonelle;
    }

    public String getDesign_salmonelle() {
        return design_salmonelle;
    }

    public void setDesign_salmonelle(String design_salmonelle) {
        this.design_salmonelle = design_salmonelle;
    }

  
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
