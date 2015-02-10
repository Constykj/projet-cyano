/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.utilisateur;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author HP USER
 */
public class CreerUtilisateurForm extends org.apache.struts.action.ActionForm {

    private String iduser;
    private String nom;
    private String prenoms;
    private String identifiant;
    private String mot_de_passe;
    private String mot_de_passeb;
    private boolean valide;
    private String droit;

    /**
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getNom() == null || getNom().length() < 1) {
            errors.add("nom", new ActionMessage("error.nom.required"));
        }
        if (getPrenoms() == null || getPrenoms().length() < 1) {
            errors.add("prenoms", new ActionMessage("error.prenoms.required"));
        }
        if (getIdentifiant() == null || getIdentifiant().length() < 1) {
            errors.add("login", new ActionMessage("error.login.required"));
        }
        if (getMot_de_passe() == null || getMot_de_passe().length() < 1) {
            errors.add("passwd", new ActionMessage("error.password.required"));
        }
        if (!getMot_de_passe().equals(getMot_de_passeb())) {
            errors.add("passwdb", new ActionMessage("error.passwordb.required"));
        }
        
        return errors;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenoms
     */
    public String getPrenoms() {
        return prenoms;
    }

    /**
     * @param prenoms the prenoms to set
     */
    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * @return the mot_de_passe
     */
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    /**
     * @param mot_de_passe the mot_de_passe to set
     */
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    /**
     * @return the iduser
     */
    public String getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    /**
     * @return the valide
     */
    public boolean isValide() {
        return valide;
    }

    /**
     * @param valide the valide to set
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public CreerUtilisateurForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the mot_de_passeb
     */
    public String getMot_de_passeb() {
        return mot_de_passeb;
    }

    /**
     * @param mot_de_passeb the mot_de_passeb to set
     */
    public void setMot_de_passeb(String mot_de_passeb) {
        this.mot_de_passeb = mot_de_passeb;
    }
     /**
     * @return the droit
     */
    public String getDroit() {
        return droit;
    }

    /**
     * @param droit the droit to set
     */
    public void setDroit(String droit) {
        this.droit = droit;
    }
    /**
     * @return the valide
     */
}
