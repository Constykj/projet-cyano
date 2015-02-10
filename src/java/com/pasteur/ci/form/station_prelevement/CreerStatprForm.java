/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.station_prelevement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
 

/**
 *
 * @author Abouchou
 */
public class CreerStatprForm extends org.apache.struts.action.ActionForm {
    
    private String idstat_prelevement;

    public int getIdstat() {
        return idstat;
    }

    public void setIdstat(int idstat) {
        this.idstat = idstat;
    }
    private int idstat;

    public double getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(double gps_lat) {
        this.gps_lat = gps_lat;
    }

    public double getGps_long() {
        return gps_long;
    }

    public void setGps_long(double gps_long) {
        this.gps_long = gps_long;
    }
    
    private double gps_lat;
     private double gps_long;
    private int idplan_eau;
     private int idhabitat;

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }
    private boolean visible;

    public String getIdstat_prelevement() {
        return idstat_prelevement;
    }

    public void setIdstat_prelevement(String idstat_prelevement) {
        this.idstat_prelevement = idstat_prelevement;
    }

  

    public int getIdplan_eau() {
        return idplan_eau;
    }

    public void setIdplan_eau(int idplan_eau) {
        this.idplan_eau = idplan_eau;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

     
    public CreerStatprForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getIdstat_prelevement()== null || getIdstat_prelevement().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
