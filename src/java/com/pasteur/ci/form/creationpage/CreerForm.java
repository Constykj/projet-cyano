/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.form.creationpage;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class CreerForm extends org.apache.struts.action.ActionForm {

    //Projet
    
  private String num_echantillon;
  private int   selGenreCy_1;
  private int   selEspCy_1;
  private int   textGenreCy_1;

    public int getSelGenreCy_1() {
        return selGenreCy_1;
    }

    public void setSelGenreCy_1(int selGenreCy_1) {
        this.selGenreCy_1 = selGenreCy_1;
    }

    public int getSelEspCy_1() {
        return selEspCy_1;
    }

    public void setSelEspCy_1(int selEspCy_1) {
        this.selEspCy_1 = selEspCy_1;
    }

    public int getTextGenreCy_1() {
        return textGenreCy_1;
    }

    public void setTextGenreCy_1(int textGenreCy_1) {
        this.textGenreCy_1 = textGenreCy_1;
    }
    
    
    private int idprojet;
    private String design_projet;

    private int idpratique;
    private String pratique;
    private int idligne_genre_algue;
    private int idligne_espece_algue;
    private int idespece_algue;
    private int idgenre_algue;
    private int idfamille;
    private int idp_phy_chim;
    private int ideclairage;
    private double phosphore;
    private double phosphate;
    private double azote_totale;
    private double oxygene_dissout;
    private double transparence;
    private double ph;
    private double temperature;
    private double salinite;
    private double conductivite;
    private double nitrate;
    private double chlorophyle_a;
    private double tubidite;
    private double fer;
    private double cadmium;
    private double plomb;
    private double seleniuml;
    private double nickel;
    private double arsenic;
    private double mercure;
    private double zinc;
    private double cuivre;

    private int idparasite;
    private int cryptosporidium;
    private int giardia;
    private int helminthe;

    private int idtype_toxine;
    private String design_toxine;

    private int idgene_cyano;
    private String design_gene_cyano;
  private double couleur_eau_brute;
    private double potentiel_redox;
    private double amminium;
    private double MES;
    private double hydrogene_sulfure;
    private double DCO;
    private double DBO5;
    private double COT;
    private double manganese;

    public double getCouleur_eau_brute() {
        return couleur_eau_brute;
    }

    public void setCouleur_eau_brute(double couleur_eau_brute) {
        this.couleur_eau_brute = couleur_eau_brute;
    }

    public double getPotentiel_redox() {
        return potentiel_redox;
    }

    public void setPotentiel_redox(double potentiel_redox) {
        this.potentiel_redox = potentiel_redox;
    }

    public double getAmminium() {
        return amminium;
    }

    public void setAmminium(double amminium) {
        this.amminium = amminium;
    }

    public double getMES() {
        return MES;
    }

    public void setMES(double MES) {
        this.MES = MES;
    }

    public double getHydrogene_sulfure() {
        return hydrogene_sulfure;
    }

    public void setHydrogene_sulfure(double hydrogene_sulfure) {
        this.hydrogene_sulfure = hydrogene_sulfure;
    }

    public double getDCO() {
        return DCO;
    }

    public void setDCO(double DCO) {
        this.DCO = DCO;
    }

    public double getDBO5() {
        return DBO5;
    }

    public void setDBO5(double DBO5) {
        this.DBO5 = DBO5;
    }

    public double getCOT() {
        return COT;
    }

    public void setCOT(double COT) {
        this.COT = COT;
    }

    public double getManganese() {
        return manganese;
    }

    public void setManganese(double manganese) {
        this.manganese = manganese;
    }
    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public String getDesign_projet() {
        return design_projet;
    }

    public void setDesign_projet(String design_projet) {
        this.design_projet = design_projet;
    }

    //Point de prelevenment
    private int idpoint_prelevement;
    private double profondeur;

    public int getIdpoint_prelevement() {
        return idpoint_prelevement;
    }

    public void setIdpoint_prelevement(int idpoint_prelevement) {
        this.idpoint_prelevement = idpoint_prelevement;
    }

    public double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

    private String num_echan;
    private String date_creat;
    private String date_prelevement;

    public String getDate_prelevement() {
        return date_prelevement;
    }

    public void setDate_prelevement(String date_prelevement) {
        this.date_prelevement = date_prelevement;
    }
    
    

    /**
     * @return the num_echan
     */
    public String getNum_echan() {
        return num_echan;
    }

    /**
     * @param num_echan the num_echan to set
     */
    public void setNum_echan(String num_echan) {
        this.num_echan = num_echan;
    }

    /**
     * @return the date_creat
     */
    public String getDate_creat() {
        return date_creat;
    }

    /**
     * @param date_creat the date_creat to set
     */
    public void setDate_creat(String date_creat) {
        this.date_creat = date_creat;
    }

    public int getIdligne_genre_algue() {
        return idligne_genre_algue;
    }

    public void setIdligne_genre_algue(int idligne_genre_algue) {
        this.idligne_genre_algue = idligne_genre_algue;
    }

    public int getIdespece_algue() {
        return idespece_algue;
    }

    public void setIdespece_algue(int idespece_algue) {
        this.idespece_algue = idespece_algue;
    }

    public int getIdgenre_algue() {
        return idgenre_algue;
    }

    public void setIdgenre_algue(int idgenre_algue) {
        this.idgenre_algue = idgenre_algue;
    }

    public int getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(int idfamille) {
        this.idfamille = idfamille;
    }

    public int getIdligne_espece_algue() {
        return idligne_espece_algue;
    }

    public void setIdligne_espece_algue(int idligne_espece_algue) {
        this.idligne_espece_algue = idligne_espece_algue;
    }

    public int getIdligne_famille() {
        return idligne_famille;
    }

    public void setIdligne_famille(int idligne_famille) {
        this.idligne_famille = idligne_famille;
    }

    private int idligne_famille;
    private int idautre_algue;

    public int getIdautre_algue() {
        return idautre_algue;
    }

    public void setIdautre_algue(int idautre_algue) {
        this.idautre_algue = idautre_algue;
    }

    public int getIdpratique() {
        return idpratique;
    }

    public void setIdpratique(int idpratique) {
        this.idpratique = idpratique;
    }

    public String getPratique() {
        return pratique;
    }

    public void setPratique(String pratique) {
        this.pratique = pratique;
    }

    public int getIdp_phy_chim() {
        return idp_phy_chim;
    }

    public void setIdp_phy_chim(int idp_phy_chim) {
        this.idp_phy_chim = idp_phy_chim;
    }

    public int getIdeclairage() {
        return ideclairage;
    }

    public void setIdeclairage(int ideclairage) {
        this.ideclairage = ideclairage;
    }

    public double getPhosphore() {
        return phosphore;
    }

    public void setPhosphore(double phosphore) {
        this.phosphore = phosphore;
    }

    public double getPhosphate() {
        return phosphate;
    }

    public void setPhosphate(double phosphate) {
        this.phosphate = phosphate;
    }

    public double getAzote_totale() {
        return azote_totale;
    }

    public void setAzote_totale(double azote_totale) {
        this.azote_totale = azote_totale;
    }

    public double getOxygene_dissout() {
        return oxygene_dissout;
    }

    public void setOxygene_dissout(double oxygene_dissout) {
        this.oxygene_dissout = oxygene_dissout;
    }

    public double getTransparence() {
        return transparence;
    }

    public void setTransparence(double transparence) {
        this.transparence = transparence;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSalinite() {
        return salinite;
    }

    public void setSalinite(double salinite) {
        this.salinite = salinite;
    }

    public double getConductivite() {
        return conductivite;
    }

    public void setConductivite(double conductivite) {
        this.conductivite = conductivite;
    }

    public double getNitrate() {
        return nitrate;
    }

    public void setNitrate(double nitrate) {
        this.nitrate = nitrate;
    }

    public double getChlorophyle_a() {
        return chlorophyle_a;
    }

    public void setChlorophyle_a(double chlorophyle_a) {
        this.chlorophyle_a = chlorophyle_a;
    }

    public double getTubidite() {
        return tubidite;
    }

    public void setTubidite(double tubidite) {
        this.tubidite = tubidite;
    }

    public double getFer() {
        return fer;
    }

    public void setFer(double fer) {
        this.fer = fer;
    }

    public double getCadmium() {
        return cadmium;
    }

    public void setCadmium(double cadmium) {
        this.cadmium = cadmium;
    }

    public double getPlomb() {
        return plomb;
    }

    public void setPlomb(double plomb) {
        this.plomb = plomb;
    }

    public double getSeleniuml() {
        return seleniuml;
    }

    public void setSeleniuml(double seleniuml) {
        this.seleniuml = seleniuml;
    }

    public double getNickel() {
        return nickel;
    }

    public void setNickel(double nickel) {
        this.nickel = nickel;
    }

    public double getArsenic() {
        return arsenic;
    }

    public void setArsenic(double arsenic) {
        this.arsenic = arsenic;
    }

    public double getMercure() {
        return mercure;
    }

    public void setMercure(double mercure) {
        this.mercure = mercure;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public double getCuivre() {
        return cuivre;
    }

    public void setCuivre(double cuivre) {
        this.cuivre = cuivre;
    }

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

    private int idvirus;
    private int enterovirus;

    public int getIdvirus() {
        return idvirus;
    }

    public void setIdvirus(int idvirus) {
        this.idvirus = idvirus;
    }

    public int getEnterovirus() {
        return enterovirus;
    }

    public void setEnterovirus(int enterovirus) {
        this.enterovirus = enterovirus;
    }

    private int idautre_bacterie;
    private int coliforme_tx;
    private int coliforme_thermo;
    private int autre_salm;
    private int vibrio;
    private int serotype_vibrio;
    private int serotype_salm;
    private int streptocoques_fecaux;
    private int anaerobie_sulfo_red;
    private int e_coli;
    private int salmonelle;

    public int getSalmonelle() {
        return salmonelle;
    }

    /**
     * @param salmonelle the salmonelle to set
     */
    public void setSalmonelle(int salmonelle) {
        this.salmonelle = salmonelle;
    }

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
     * @return the serotype_vibrio
     */
    /**
     *
     */
    public CreerForm() {
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

        return errors;
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

    private int idespece_cyano;
    private String design_espece_cyano;
    private int idgenre_cyano;
    private String design_genre_cyano;
    private int denombrement_esp_cyano;

    /**
     * @return the idespece_cyano
     */
    public int getIdespece_cyano() {
        return idespece_cyano;
    }

    /**
     * @param idespece_cyano the idespece_cyano to set
     */
    public void setIdespece_cyano(int idespece_cyano) {
        this.idespece_cyano = idespece_cyano;
    }

    /**
     * @return the design_espece_cyano
     */
    public String getDesign_espece_cyano() {
        return design_espece_cyano;
    }

    /**
     * @param design_espece_cyano the design_espece_cyano to set
     */
    public void setDesign_espece_cyano(String design_espece_cyano) {
        this.design_espece_cyano = design_espece_cyano;
    }

    /**
     * @return the idgenre_cyano
     */
    public int getIdgenre_cyano() {
        return idgenre_cyano;
    }

    /**
     * @param idgenre_cyano the idgenre_cyano to set
     */
    public void setIdgenre_cyano(int idgenre_cyano) {
        this.idgenre_cyano = idgenre_cyano;
    }

    /**
     * @return the design_genre_cyano
     */
    public String getDesign_genre_cyano() {
        return design_genre_cyano;
    }

    /**
     * @param design_genre_cyano the design_genre_cyano to set
     */
    public void setDesign_genre_cyano(String design_genre_cyano) {
        this.design_genre_cyano = design_genre_cyano;
    }

    /**
     * @return the idgene_cyano
     */
    public int getIdgene_cyano() {
        return idgene_cyano;
    }

    /**
     * @param idgene_cyano the idgene_cyano to set
     */
    public void setIdgene_cyano(int idgene_cyano) {
        this.idgene_cyano = idgene_cyano;
    }

    /**
     * @return the design_gene_cyano
     */
    public String getDesign_gene_cyano() {
        return design_gene_cyano;
    }

    /**
     * @param design_gene_cyano the design_gene_cyano to set
     */
    public void setDesign_gene_cyano(String design_gene_cyano) {
        this.design_gene_cyano = design_gene_cyano;
    }

    private int idtyp_gene_toxicite;
    private String design_typ_gene_toxicite;

    /**
     * @return the idtyp_gene_toxicite
     */
    public int getIdtyp_gene_toxicite() {
        return idtyp_gene_toxicite;
    }

    /**
     * @param idtyp_gene_toxicite the idtyp_gene_toxicite to set
     */
    public void setIdtyp_gene_toxicite(int idtyp_gene_toxicite) {
        this.idtyp_gene_toxicite = idtyp_gene_toxicite;
    }

    /**
     * @return the design_typ_gene_toxicite
     */
    public String getDesign_typ_gene_toxicite() {
        return design_typ_gene_toxicite;
    }

    /**
     * @param design_typ_gene_toxicite the design_typ_gene_toxicite to set
     */
    public void setDesign_typ_gene_toxicite(String design_typ_gene_toxicite) {
        this.design_typ_gene_toxicite = design_typ_gene_toxicite;
    }

    /**
     * @return the idtype_toxine
     */
    public int getIdtype_toxine() {
        return idtype_toxine;
    }

    /**
     * @param idtype_toxine the idtype_toxine to set
     */
    public void setIdtype_toxine(int idtype_toxine) {
        this.idtype_toxine = idtype_toxine;
    }

    /**
     * @return the design_toxine
     */
    public String getDesign_toxine() {
        return design_toxine;
    }

    /**
     * @param design_toxine the design_toxine to set
     */
    public void setDesign_toxine(String design_toxine) {
        this.design_toxine = design_toxine;
    }

    private String listeGenreCyano;
    private String listeGeneCyano;
    private String listeTypeGeneToxicite;
    private String listeTypeToxicite;

    /**
     * @return the listeGenreCyano
     */
    public String getListeGenreCyano() {
        return listeGenreCyano;
    }

    /**
     * @param listeGenreCyano the listeGenreCyano to set
     */
    public void setListeGenreCyano(String listeGenreCyano) {
        this.listeGenreCyano = listeGenreCyano;
    }

    /**
     * @return the listeGeneCyano
     */
    public String getListeGeneCyano() {
        return listeGeneCyano;
    }

    /**
     * @param listeGeneCyano the listeGeneCyano to set
     */
    public void setListeGeneCyano(String listeGeneCyano) {
        this.listeGeneCyano = listeGeneCyano;
    }

    /**
     * @return the listeTypeGeneToxicite
     */
    public String getListeTypeGeneToxicite() {
        return listeTypeGeneToxicite;
    }

    /**
     * @param listeTypeGeneToxicite the listeTypeGeneToxicite to set
     */
    public void setListeTypeGeneToxicite(String listeTypeGeneToxicite) {
        this.listeTypeGeneToxicite = listeTypeGeneToxicite;
    }

    /**
     * @return the listeTypeToxicite
     */
    public String getListeTypeToxicite() {
        return listeTypeToxicite;
    }

    /**
     * @param listeTypeToxicite the listeTypeToxicite to set
     */
    public void setListeTypeToxicite(String listeTypeToxicite) {
        this.listeTypeToxicite = listeTypeToxicite;
    }

    /**
     * @return the denombrement_esp_cyano
     */
    public int getDenombrement_esp_cyano() {
        return denombrement_esp_cyano;
    }

    /**
     * @param denombrement_esp_cyano the denombrement_esp_cyano to set
     */
    public void setDenombrement_esp_cyano(int denombrement_esp_cyano) {
        this.denombrement_esp_cyano = denombrement_esp_cyano;
    }

    private int concentration_gene_cyano;

    /**
     * @return the concentration_gene_cyano
     */
    public int getConcentration_gene_cyano() {
        return concentration_gene_cyano;
    }

    /**
     * @param concentration_gene_cyano the concentration_gene_cyano to set
     */
    public void setConcentration_gene_cyano(int concentration_gene_cyano) {
        this.concentration_gene_cyano = concentration_gene_cyano;
    }

    private int concentration_gene_toxicite;

    /**
     * @return the concentration_gene_toxicite
     */
    public int getConcentration_gene_toxicite() {
        return concentration_gene_toxicite;
    }

    /**
     * @param concentration_gene_toxicite the concentration_gene_toxicite to set
     */
    public void setConcentration_gene_toxicite(int concentration_gene_toxicite) {
        this.concentration_gene_toxicite = concentration_gene_toxicite;
    }

    private int concentration_type_toxicite;

    /**
     * @return the concentration_type_toxicite
     */
    public int getConcentration_type_toxicite() {
        return concentration_type_toxicite;
    }

    /**
     * @param concentration_type_toxicite the concentration_type_toxicite to set
     */
    public void setConcentration_type_toxicite(int concentration_type_toxicite) {
        this.concentration_type_toxicite = concentration_type_toxicite;
    }

    private String genreAlgue;

    /**
     * @return the genreAlgue
     */
    public String getGenreAlgue() {
        return genreAlgue;
    }

    /**
     * @param genreAlgue the genreAlgue to set
     */
    public void setGenreAlgue(String genreAlgue) {
        this.genreAlgue = genreAlgue;
    }

    private String algue_fam_genre1;
    private String algue_fam_genre2;
    private String algue_fam_genre3;
    private String algue_fam_genre4;
    private String algue_fam_genre5;
    private String algue_fam_genre6;
    private String algue_fam_genre7;
    private String algue_fam_genre8;
    private String algue_fam_genre9;
    private String algue_fam_genre10;

    /**
     * @return the algue_fam_genre1
     */
    public String getAlgue_fam_genre1() {
        return algue_fam_genre1;
    }

    /**
     * @param algue_fam_genre1 the algue_fam_genre1 to set
     */
    public void setAlgue_fam_genre1(String algue_fam_genre1) {
        this.algue_fam_genre1 = algue_fam_genre1;
    }

    /**
     * @return the algue_fam_genre2
     */
    public String getAlgue_fam_genre2() {
        return algue_fam_genre2;
    }

    /**
     * @param algue_fam_genre2 the algue_fam_genre2 to set
     */
    public void setAlgue_fam_genre2(String algue_fam_genre2) {
        this.algue_fam_genre2 = algue_fam_genre2;
    }

    /**
     * @return the algue_fam_genre3
     */
    public String getAlgue_fam_genre3() {
        return algue_fam_genre3;
    }

    /**
     * @param algue_fam_genre3 the algue_fam_genre3 to set
     */
    public void setAlgue_fam_genre3(String algue_fam_genre3) {
        this.algue_fam_genre3 = algue_fam_genre3;
    }

    /**
     * @return the algue_fam_genre4
     */
    public String getAlgue_fam_genre4() {
        return algue_fam_genre4;
    }

    /**
     * @param algue_fam_genre4 the algue_fam_genre4 to set
     */
    public void setAlgue_fam_genre4(String algue_fam_genre4) {
        this.algue_fam_genre4 = algue_fam_genre4;
    }

    /**
     * @return the algue_fam_genre5
     */
    public String getAlgue_fam_genre5() {
        return algue_fam_genre5;
    }

    /**
     * @param algue_fam_genre5 the algue_fam_genre5 to set
     */
    public void setAlgue_fam_genre5(String algue_fam_genre5) {
        this.algue_fam_genre5 = algue_fam_genre5;
    }

    /**
     * @return the algue_fam_genre6
     */
    public String getAlgue_fam_genre6() {
        return algue_fam_genre6;
    }

    /**
     * @param algue_fam_genre6 the algue_fam_genre6 to set
     */
    public void setAlgue_fam_genre6(String algue_fam_genre6) {
        this.algue_fam_genre6 = algue_fam_genre6;
    }

    /**
     * @return the algue_fam_genre7
     */
    public String getAlgue_fam_genre7() {
        return algue_fam_genre7;
    }

    /**
     * @param algue_fam_genre7 the algue_fam_genre7 to set
     */
    public void setAlgue_fam_genre7(String algue_fam_genre7) {
        this.algue_fam_genre7 = algue_fam_genre7;
    }

    /**
     * @return the algue_fam_genre8
     */
    public String getAlgue_fam_genre8() {
        return algue_fam_genre8;
    }

    /**
     * @param algue_fam_genre8 the algue_fam_genre8 to set
     */
    public void setAlgue_fam_genre8(String algue_fam_genre8) {
        this.algue_fam_genre8 = algue_fam_genre8;
    }

    /**
     * @return the algue_fam_genre9
     */
    public String getAlgue_fam_genre9() {
        return algue_fam_genre9;
    }

    /**
     * @param algue_fam_genre9 the algue_fam_genre9 to set
     */
    public void setAlgue_fam_genre9(String algue_fam_genre9) {
        this.algue_fam_genre9 = algue_fam_genre9;
    }

    /**
     * @return the algue_fam_genre10
     */
    public String getAlgue_fam_genre10() {
        return algue_fam_genre10;
    }

    /**
     * @param algue_fam_genre10 the algue_fam_genre10 to set
     */
    public void setAlgue_fam_genre10(String algue_fam_genre10) {
        this.algue_fam_genre10 = algue_fam_genre10;
    }

    public String getNum_echantillon() {
        return num_echantillon;
    }

    public void setNum_echantillon(String num_echantillon) {
        this.num_echantillon = num_echantillon;
    }
 
}
