/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class AutreBacterie {
    private  int idautre_bacterie;
    private int coliforme_tx;
    private int streptocoques_fecaux;
    private int anaerobie_sulfo_red;
    private int e_coli;
    private int coliforme_thermo;
    private int  autre_salm;
    private int salmonelle;
    private int vibrio ;
    private int serotype_salm;
    private int serotype_vibrio;
    
    private Boolean visible;

    public int getIdautre_bacterie() {
        return idautre_bacterie;
    }

    public void setIdautre_bacterie(int idautre_bacterie) {
        this.idautre_bacterie = idautre_bacterie;
    }

    public int getColiforme_tx() {
        return coliforme_tx;
    }

    public void setColiforme_tx(int coliforme_tx) {
        this.coliforme_tx = coliforme_tx;
    }

    public int getStreptocoques_fecaux() {
        return streptocoques_fecaux;
    }

    public void setStreptocoques_fecaux(int streptocoques_fecaux) {
        this.streptocoques_fecaux = streptocoques_fecaux;
    }

    public int getAnaerobie_sulfo_red() {
        return anaerobie_sulfo_red;
    }

    public void setAnaerobie_sulfo_red(int anaerobie_sulfo_red) {
        this.anaerobie_sulfo_red = anaerobie_sulfo_red;
    }
     public int getE_coli() {
        return e_coli;
    }

    public void setE_coli(int e_coli) {
        this.e_coli = e_coli;
    }

    public boolean isVisible() {
        return getVisible();
    }

    public void setVisible(boolean visible) {
        this.setVisible((Boolean) visible);
    }

    /**
     * @return the coliforme_thermo
     */
    public int getColiforme_thermo() {
        return coliforme_thermo;
    }

    /**
     * @param coliforme_thermo the coliforme_thermo to set
     */
    public void setColiforme_thermo(int coliforme_thermo) {
        this.coliforme_thermo = coliforme_thermo;
    }

    /**
     * @return the autre_salm
     */
    public int getAutre_salm() {
        return autre_salm;
    }

    /**
     * @param autre_salm the autre_salm to set
     */
    public void setAutre_salm(int autre_salm) {
        this.autre_salm = autre_salm;
    }

    /**
     * @return the salmonelle
     */
    public int getSalmonelle() {
        return salmonelle;
    }

    /**
     * @param salmonelle the salmonelle to set
     */
    public void setSalmonelle(int salmonelle) {
        this.salmonelle = salmonelle;
    }

    /**
     * @return the vibrio
     */
    public int getVibrio() {
        return vibrio;
    }

    /**
     * @param vibrio the vibrio to set
     */
    public void setVibrio(int vibrio) {
        this.vibrio = vibrio;
    }

    /**
     * @return the serotype_salm
     */
    public int getSerotype_salm() {
        return serotype_salm;
    }

    /**
     * @param serotype_salm the serotype_salm to set
     */
    public void setSerotype_salm(int serotype_salm) {
        this.serotype_salm = serotype_salm;
    }

    /**
     * @return the serotype_vibrio
     */
    public int getSerotype_vibrio() {
        return serotype_vibrio;
    }

    /**
     * @param serotype_vibrio the serotype_vibrio to set
     */
    public void setSerotype_vibrio(int serotype_vibrio) {
        this.serotype_vibrio = serotype_vibrio;
    }

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
