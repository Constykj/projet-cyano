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
public class LigneTypeGeneToxicite {

    private int idcyano;
    private int idlignetype_toxicite;
    private int idtyp_gene_toxicite;
    private double concentration_gene_toxicite;

    public int getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(int idcyano) {
        this.idcyano = idcyano;
    }

    public int getIdlignetype_toxicite() {
        return idlignetype_toxicite;
    }

    public void setIdlignetype_toxicite(int idlignetype_toxicite) {
        this.idlignetype_toxicite = idlignetype_toxicite;
    }

    public int getIdtyp_gene_toxicite() {
        return idtyp_gene_toxicite;
    }

    public void setIdtyp_gene_toxicite(int idtyp_gene_toxicite) {
        this.idtyp_gene_toxicite = idtyp_gene_toxicite;
    }

    /**
     * @return the concentration_gene_toxicite
     */
    public double getConcentration_gene_toxicite() {
        return concentration_gene_toxicite;
    }

    /**
     * @param concentration_gene_toxicite the concentration_gene_toxicite to set
     */
    public void setConcentration_gene_toxicite(double concentration_gene_toxicite) {
        this.concentration_gene_toxicite = concentration_gene_toxicite;
    }
}
