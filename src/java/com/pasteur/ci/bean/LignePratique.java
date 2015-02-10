/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class LignePratique {

    private int idpratique;
    private int idplan_eau;
    private  int idligne_pratique;
    
     public int getIdligne_pratique() {
        return idligne_pratique;
    }

    public void setIdligne_pratique(int idligne_pratique) {
        this.idligne_pratique = idligne_pratique;
    }

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public int getIdpratique() {
        return idpratique;
    }

    public void setIdpratique(int idpratique) {
        this.idpratique = idpratique;
    }
}
