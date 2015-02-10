/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class LigneHabitat {
    private int idhabitat;
    private int idmateriaux_construction;
    private int idligne_habitat;

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }
     public int getIdligne_habitat() {
        return idligne_habitat;
    }

    public void setIdligne_habitat(int idligne_habitat) {
        this.idligne_habitat = idligne_habitat;
    }


    public int getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    public void setIdmateriaux_construction(int idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }
}
