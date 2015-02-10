/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author HP USER
 */
public class RapportEchantillon {

    private String idEchantillon;
    private String stationPrelev;
    private String pointPrelev;
    private String planEau;

    /**
     * @return the idEchantillon
     */
    public String getIdEchantillon() {
        return idEchantillon;
    }

    /**
     * @param idEchantillon the idEchantillon to set
     */
    public void setIdEchantillon(String idEchantillon) {
        this.idEchantillon = idEchantillon;
    }

    /**
     * @return the stationPrelev
     */
    public String getStationPrelev() {
        return stationPrelev;
    }

    /**
     * @param stationPrelev the stationPrelev to set
     */
    public void setStationPrelev(String stationPrelev) {
        this.stationPrelev = stationPrelev;
    }

    /**
     * @return the pointPrelev
     */
    public String getPointPrelev() {
        return pointPrelev;
    }

    /**
     * @param pointPrelev the pointPrelev to set
     */
    public void setPointPrelev(String pointPrelev) {
        this.pointPrelev = pointPrelev;
    }

    /**
     * @return the planEau
     */
    public String getPlanEau() {
        return planEau;
    }

    /**
     * @param planEau the planEau to set
     */
    public void setPlanEau(String planEau) {
        this.planEau = planEau;
    }
    

}
