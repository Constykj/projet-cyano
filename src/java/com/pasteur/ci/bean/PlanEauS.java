/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

import java.util.ArrayList;

/**
 *
 * @author HP USER
 */
public class PlanEauS {

    private int idplan_eau;
    private String designation;
    private String region;
    private String quartier;
    private String commune;
    private String type_plan_eau;
    private int idesignation;
    private int idregion;
    private int idquartier;
    private int idcommune;
    private int idtype_plan_eau;
    private int idligne_pratique;
    private int[] idpratique;
    private String pratiquer;

    private ArrayList pratiques;
    private double superficie;
    private String commentaire;
    private boolean matiere_fecale;
    private boolean visible;

    public String getPratiquer() {
        return pratiquer;
    }

    public void setPratiquer(String pratiquer) {
        this.pratiquer = pratiquer;
    }

    public int getIdesignation() {
        return idesignation;
    }

    public void setIdesignation(int idesignation) {
        this.idesignation = idesignation;
    }

    public int getIdregion() {
        return idregion;
    }

    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    public int getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(int idquartier) {
        this.idquartier = idquartier;
    }

    public int getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(int idcommune) {
        this.idcommune = idcommune;
    }

    public int getIdtype_plan_eau() {
        return idtype_plan_eau;
    }

    public void setIdtype_plan_eau(int idtype_plan_eau) {
        this.idtype_plan_eau = idtype_plan_eau;
    }

    public int getIdligne_pratique() {
        return idligne_pratique;
    }

    public void setIdligne_pratique(int idligne_pratique) {
        this.idligne_pratique = idligne_pratique;
    }

    public int[] getIdpratique() {
        return idpratique;
    }

    public void setIdpratique(int[] idpratique) {
        this.idpratique = idpratique;
    }

    public ArrayList getPratiques() {
        return pratiques;
    }

    public void setPratiques(ArrayList pratiques) {
        this.pratiques = pratiques;
    }

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getType_plan_eau() {
        return type_plan_eau;
    }

    public void setType_plan_eau(String type_plan_eau) {
        this.type_plan_eau = type_plan_eau;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isMatiere_fecale() {
        return matiere_fecale;
    }

    public void setMatiere_fecale(boolean matiere_fecale) {
        this.matiere_fecale = matiere_fecale;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
