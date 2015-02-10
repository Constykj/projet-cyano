/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class LigneHabitas {

    
    public String getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    public void setIdmateriaux_construction(String idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }

    public int getIdligne_habitat() {
        return idligne_habitat;
    }

    public void setIdligne_habitat(int idligne_habitat) {
        this.idligne_habitat = idligne_habitat;
    }
 

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }
    private int idhabitat;

    public int getIdhabitat() {
        return idhabitat;
    }
    private String idmateriaux_construction;
    private int idligne_habitat;
}
