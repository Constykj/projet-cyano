/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author abouchou
 */
public class TypeToxine {

    private int idtype_toxine;
    private String design_toxine;

    private boolean visible;

    public int getIdtype_toxine() {
        return idtype_toxine;
    }

    public void setIdtype_toxine(int idtype_toxine) {
        this.idtype_toxine = idtype_toxine;
    }

    public String getDesign_toxine() {
        return design_toxine;
    }

    public void setDesign_toxine(String design_toxine) {
        this.design_toxine = design_toxine;
    }

  

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
