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
public class LigneGeneCyano {
    private int idligne_gene_cyano;
    private int idcyano;
    private int idgene_cyano;
    private double concentration_gene_cyano;

    public int getIdligne_gene_cyano() {
        return idligne_gene_cyano;
    }

    public void setIdligne_gene_cyano(int idligne_gene_cyano) {
        this.idligne_gene_cyano = idligne_gene_cyano;
    }

    public int getIdcyano() {
        return idcyano;
    }

    public void setIdcyano(int idcyano) {
        this.idcyano = idcyano;
    }

    public int getIdgene_cyano() {
        return idgene_cyano;
    }

    public void setIdgene_cyano(int idgene_cyano) {
        this.idgene_cyano = idgene_cyano;
    }

    /**
     * @return the concentration_gene_cyano
     */
    public double getConcentration_gene_cyano() {
        return concentration_gene_cyano;
    }

    /**
     * @param concentration_gene_cyano the concentration_gene_cyano to set
     */
    public void setConcentration_gene_cyano(double concentration_gene_cyano) {
        this.concentration_gene_cyano = concentration_gene_cyano;
    }
}
