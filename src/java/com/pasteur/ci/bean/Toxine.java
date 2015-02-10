/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Toxine{
    
    private int idtoxine;
    private String design_toxine;
    private double conc_toxine_microcystine;
    private String type_toxine_microcystine;
    private boolean visible;

    public int getIdtoxine(){
        return idtoxine;
    }

    public void setIdtoxine(int idtoxine){
        this.idtoxine = idtoxine;
    }

    public String getDesign_toxine() {
        return design_toxine;
    }

    public void setDesign_toxine(String design_toxine) {
        this.design_toxine = design_toxine;
    }

    public double getConc_toxine_microcystine() {
        return conc_toxine_microcystine;
    }
    public void setConc_toxine_microcystine(double conc_toxine_microcystine){
        this.conc_toxine_microcystine = conc_toxine_microcystine;
    }
     public String getType_toxine_microcystine(){
        return type_toxine_microcystine;
    }
    public void setType_toxine_microcystine(String type_toxine_microcystine){
        
        this.type_toxine_microcystine = type_toxine_microcystine;
    }

    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
}
