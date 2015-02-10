/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.bean;

/**
 *
 * @author Abouchou
 */
public class Parasite {

    private int idparasite;
    private int cryptosporidium;
    private int giardia;
    private int helminthe;
    private boolean visible;
    
    public int getIdparasite() {
        return idparasite;
    }

    public void setIdparasite(int idparasite) {
        this.idparasite = idparasite;
    }

    public int getCryptosporidium() {
        return cryptosporidium;
    }

    public void setCryptosporidium(int cryptosporidium) {
        this.cryptosporidium = cryptosporidium;
    }

    public int getGiardia() {
        return giardia;
    }

    public void setGiardia(int giardia) {
        this.giardia = giardia;
    }
    public int getHelminthe() {
        return helminthe;
    }

    public void setHelminthe(int helminthe) {
        this.helminthe = helminthe;
    }
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
