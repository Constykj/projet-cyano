/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class StatPrelevement {

    private int idstat;
    private String idstat_prelevement;
    private int idplan_eau;
    private int idhabitat;
    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }

    public double getGps_long() {
        return gps_long;
    }

    public void setGps_long(double gps_long) {
        this.gps_long = gps_long;
    }

    public double getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(double gps_lat) {
        this.gps_lat = gps_lat;
    }
    private double gps_long;
    private double gps_lat;
    private boolean visible;

    public int getIdstat() {
        return idstat;
    }

    public void setIdstat(int idstat) {
        this.idstat = idstat;
    }

    public String getIdstat_prelevement() {
        return idstat_prelevement;
    }

    public void setIdStat_prelevement(String idstat_prelevement) {
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
}
