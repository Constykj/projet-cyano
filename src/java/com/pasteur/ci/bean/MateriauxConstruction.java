/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class MateriauxConstruction {

    private int idmateriaux_construction;
    private String lib_materiaux_construction;
    private boolean visible;

    public int getIdmateriaux_construction() {
        return idmateriaux_construction;
    }

    public void setIdmateriaux_construction(int idmateriaux_construction) {
        this.idmateriaux_construction = idmateriaux_construction;
    }

    public String getLib_materiaux_construction() {
        return lib_materiaux_construction;
    }

    public void setLib_materiaux_construction(String lib_materiaux_construction) {
        this.lib_materiaux_construction = lib_materiaux_construction;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
