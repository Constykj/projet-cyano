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
public class TypeGeneCyano {

    private int idtyp_gene_cyano;
    private String design_typ_gene_cyano;
  
    private boolean visible;

    public int getIdtyp_gene_cyano() {
        return idtyp_gene_cyano;
    }

    public void setIdtyp_gene_cyano(int idtyp_gene_cyano) {
        this.idtyp_gene_cyano = idtyp_gene_cyano;
    }

    public String getDesign_typ_gene_cyano() {
        return design_typ_gene_cyano;
    }

    public void setDesign_typ_gene_cyano(String design_typ_gene_cyano) {
        this.design_typ_gene_cyano = design_typ_gene_cyano;
    }


    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
