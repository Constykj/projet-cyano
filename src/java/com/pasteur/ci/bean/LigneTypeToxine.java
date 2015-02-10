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
public class LigneTypeToxine {

    private int idligne_type_toxine;
    private int idtype_toxine;
    private int idcyano;
    private double concentration_type_toxicite;

    public int getIdligne_type_toxine() {
        return idligne_type_toxine;
    }

    public void setIdligne_type_toxine(int idligne_type_toxine) {
        this.idligne_type_toxine = idligne_type_toxine;
    }

    public int getIdtype_toxine() {
        return idtype_toxine;
    }

    public void setIdtype_toxine(int idtype_toxine) {
        this.idtype_toxine = idtype_toxine;
    }

    public int getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(int idcyano) {
        this.idcyano = idcyano;
    }

    /**
     * @return the concentration_type_toxicite
     */
    public double getConcentration_type_toxicite() {
        return concentration_type_toxicite;
    }

    /**
     * @param concentration_type_toxicite the concentration_type_toxicite to set
     */
    public void setConcentration_type_toxicite(double concentration_type_toxicite) {
        this.concentration_type_toxicite = concentration_type_toxicite;
    }
}
