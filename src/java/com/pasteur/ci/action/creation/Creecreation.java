/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.autre_algue.dao.AutreAlgueDAOImplement;
import com.pasteur.ci.autre_bacterie.dao.AutreBacterieDAOImplement;
import com.pasteur.ci.bean.AutreAlgue;
import com.pasteur.ci.bean.AutreBacterie;
import com.pasteur.ci.bean.Cyanobacterie;
import com.pasteur.ci.bean.Echantillon;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.bean.LigneFamille;
import com.pasteur.ci.bean.LigneGeneCyano;
import com.pasteur.ci.bean.LigneGenreAlgue;
import com.pasteur.ci.bean.LigneGenreCyano;
import com.pasteur.ci.bean.LigneTypeGeneToxicite;
import com.pasteur.ci.bean.LigneTypeToxine;
import com.pasteur.ci.bean.PPhyChim;
import com.pasteur.ci.bean.Parasite;
import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Projet;
import com.pasteur.ci.bean.Virus;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.cyanobacterie.dao.CyanobacterieDAOImplement;
import com.pasteur.ci.echantillon.dao.EchantillonDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.ligne_famille.dao.LigneFamilleDAOimplement;
import com.pasteur.ci.ligne_gene_cyano.dao.LigneGeneCyanoDAOImplement;
import com.pasteur.ci.ligne_genre_algue.dao.LigneGenreAlgueDAOImplement;
import com.pasteur.ci.ligne_genre_cyano.dao.LigneGenreCyanoDAOImplement;
import com.pasteur.ci.ligne_type_gene_toxicite.dao.LigneTypeGeneToxiciteDAOImplement;
import com.pasteur.ci.ligne_type_toxine.dao.LigneTypeToxineDAOImplement;
import com.pasteur.ci.p_phy_chim.dao.PPhyChimDAOImplement;
import com.pasteur.ci.parasite.dao.ParasiteDAOImplement;
import com.pasteur.ci.virus.dao.VirusDAOImplement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class Creecreation extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//-------projet----------------------------------------------------------------
        int idprojet = (Integer) PropertyUtils.getProperty(form, "idprojet");

        Projet projet = new Projet();
        projet.setIdprojet(idprojet);

//-------Point de prelevement--------------------------------------------------
        int idpoint_prelevement = (Integer) PropertyUtils.getProperty(form, "idpoint_prelevement");
        PointPrelevement pointPrelevement = new PointPrelevement();
        pointPrelevement.setIdpoint_prelevement(idpoint_prelevement);

// ---------Proprietes physica chimique ------------------------------------------------
        double phosphore = (Double) PropertyUtils.getProperty(form, "phosphore");
        double phosphate = (Double) PropertyUtils.getProperty(form, "phosphate");
        double azote_totale = (Double) PropertyUtils.getProperty(form, "azote_totale");
        double oxygene_dissout = (Double) PropertyUtils.getProperty(form, "oxygene_dissout");
        double transparence = (Double) PropertyUtils.getProperty(form, "transparence");
        double ph = (Double) PropertyUtils.getProperty(form, "ph");
        double temperature = (Double) PropertyUtils.getProperty(form, "temperature");
        int ideclairage = (Integer) PropertyUtils.getProperty(form, "ideclairage");
        double salinite = (Double) PropertyUtils.getProperty(form, "salinite");
        double chlorophyle_a = (Double) PropertyUtils.getProperty(form, "chlorophyle_a");
        double nitrate = (Double) PropertyUtils.getProperty(form, "nitrate");
        double tubidite = (Double) PropertyUtils.getProperty(form, "tubidite");
        double fer = (Double) PropertyUtils.getProperty(form, "fer");
        double cadmium = (Double) PropertyUtils.getProperty(form, "cadmium");
        double plomb = (Double) PropertyUtils.getProperty(form, "plomb");
        double seleniuml = (Double) PropertyUtils.getProperty(form, "seleniuml");
        double nickel = (Double) PropertyUtils.getProperty(form, "nickel");
        double arsenic = (Double) PropertyUtils.getProperty(form, "arsenic");
        double mercure = (Double) PropertyUtils.getProperty(form, "mercure");
        double zinc = (Double) PropertyUtils.getProperty(form, "zinc");
        double cuivre = (Double) PropertyUtils.getProperty(form, "cuivre");
        double conductivite = (Double) PropertyUtils.getProperty(form, "conductivite");
        double couleur_eau_brute = (Double) PropertyUtils.getProperty(form, "couleur_eau_brute");
        double potentiel_redox = (Double) PropertyUtils.getProperty(form, "potentiel_redox");
        double amminium = (Double) PropertyUtils.getProperty(form, "amminium");
        double MES = (Double) PropertyUtils.getProperty(form, "MES");
        double hydrogene_sulfure = (Double) PropertyUtils.getProperty(form, "hydrogene_sulfure");
        double DCO = (Double) PropertyUtils.getProperty(form, "DCO");
        double DBO5 = (Double) PropertyUtils.getProperty(form, "DBO5");
        double COT = (Double) PropertyUtils.getProperty(form, "COT");
        double manganese = (Double) PropertyUtils.getProperty(form, "manganese");
     
        PPhyChim pphychimie = new PPhyChim();

        pphychimie.setArsenic(arsenic);
        pphychimie.setAzote_totale(azote_totale);
        pphychimie.setCadmium(cadmium);
        pphychimie.setChlorophyle_a(chlorophyle_a);
        pphychimie.setConductivite(conductivite);
        pphychimie.setCuivre(cuivre);
        pphychimie.setFer(fer);
        pphychimie.setIdeclairage(ideclairage);
        pphychimie.setMercure(mercure);
        pphychimie.setNickel(nickel);
        pphychimie.setNitrate(nitrate);
        pphychimie.setPlomb(plomb);
        pphychimie.setSalinite(salinite);
        pphychimie.setSeleniuml(seleniuml);
        pphychimie.setTemperature(temperature);
        pphychimie.setTransparence(transparence);
        pphychimie.setTubidite(tubidite);
        pphychimie.setZinc(zinc);
        pphychimie.setPh(ph);
        pphychimie.setPhosphate(phosphate);
        pphychimie.setPhosphore(phosphore);
        pphychimie.setOxygene_dissout(oxygene_dissout);
        pphychimie.setCouleur_eau_brute(couleur_eau_brute);
        pphychimie.setCOT(COT);
        pphychimie.setMES(MES);
        pphychimie.setDBO5(DBO5);
        pphychimie.setManganese(manganese);
        pphychimie.setHydrogene_sulfure(hydrogene_sulfure);
        pphychimie.setAmminium(amminium);
        pphychimie.setPotentiel_redox(potentiel_redox);
        pphychimie.setDCO(DCO);

        PPhyChimDAOImplement ppcdaoi = new PPhyChimDAOImplement(DAOFactory.getInstance());

//        cle propriete physico chimique
        pphychimie = (PPhyChim) ppcdaoi.create(pphychimie);

        //------------Autre bacterie------------------------------------------------------------
        int coliforme_tx = (Integer) PropertyUtils.getProperty(form, "coliforme_tx");
        int e_coli = (Integer) PropertyUtils.getProperty(form, "e_coli");
        int coliforme_thermo = (Integer) PropertyUtils.getProperty(form, "coliforme_thermo");
        int streptocoques_fecaux = (Integer) PropertyUtils.getProperty(form, "streptocoques_fecaux");
        int anaerobie_sulfo_red = (Integer) PropertyUtils.getProperty(form, "anaerobie_sulfo_red");
        int autre_salm = (Integer) PropertyUtils.getProperty(form, "autre_salm");
        int salmonelle = (Integer) PropertyUtils.getProperty(form, "salmonelle");
        int vibrio = (Integer) PropertyUtils.getProperty(form, "vibrio");
        int serotype_salm = (Integer) PropertyUtils.getProperty(form, "serotype_salm");
        int serotype_vibrio = (Integer) PropertyUtils.getProperty(form, "serotype_vibrio");

        AutreBacterie autreBacterie = new AutreBacterie();
        autreBacterie.setColiforme_tx(coliforme_tx);
        autreBacterie.setE_coli(e_coli);
        autreBacterie.setAnaerobie_sulfo_red(anaerobie_sulfo_red);
        autreBacterie.setColiforme_thermo(coliforme_thermo);
        autreBacterie.setStreptocoques_fecaux(streptocoques_fecaux);
        autreBacterie.setAutre_salm(autre_salm);
        autreBacterie.setSalmonelle(salmonelle);
        autreBacterie.setVibrio(vibrio);
        autreBacterie.setSerotype_salm(serotype_salm);
        autreBacterie.setSerotype_vibrio(serotype_vibrio);
        autreBacterie.setVisible(true);
        AutreBacterieDAOImplement abdaoi = new AutreBacterieDAOImplement(DAOFactory.getInstance());
        autreBacterie = (AutreBacterie) abdaoi.create(autreBacterie);

        //------------------------parasite-----------------------------------------------------
        int cryptosporidium = (Integer) PropertyUtils.getProperty(form, "cryptosporidium");
        int giardia = (Integer) PropertyUtils.getProperty(form, "giardia");
        int helminthe = (Integer) PropertyUtils.getProperty(form, "helminthe");

        Parasite parasite = new Parasite();

        parasite.setGiardia(giardia);
        parasite.setCryptosporidium(cryptosporidium);
        parasite.setHelminthe(helminthe);

        ParasiteDAOImplement pdaoic = new ParasiteDAOImplement(DAOFactory.getInstance());
        parasite = (Parasite) pdaoic.create(parasite);

        //------------------Virus---------------------------------------------------------------
        int enterovirus = (int) PropertyUtils.getProperty(form, "enterovirus");

        Virus virus = new Virus();
        virus.setEnterovirus(enterovirus);

        VirusDAOImplement vdaoi = new VirusDAOImplement(DAOFactory.getInstance());
        virus = (Virus) vdaoi.create(virus);

        //--------------------table Cyanobacterie--------------------------------------------------
        Cyanobacterie cyanobacterie = new Cyanobacterie();
        CyanobacterieDAOImplement cyanobacterieDAOImplement = new CyanobacterieDAOImplement(DAOFactory.getInstance());
        cyanobacterie = (Cyanobacterie) cyanobacterieDAOImplement.create(cyanobacterie);

        //-------------------Cyanobacetrie genre-------------------------------------------------------
        String listGenreCya = (String) PropertyUtils.getProperty(form, "listeGenreCyano");
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + listGenreCya);
        ArrayList<Object> ligne_genre_cyanof = partitionneGenreCyano(listGenreCya);

        LigneGenreCyanoDAOImplement genreCyanoDAOImplement = new LigneGenreCyanoDAOImplement(DAOFactory.getInstance());
        for (Object ligne_genre_cyanofL : ligne_genre_cyanof) {
            LigneGenreCyano ligneGenreCyano = (LigneGenreCyano) ligne_genre_cyanofL;
            ligneGenreCyano.setIdcyano(cyanobacterie.getIdcyano());
            genreCyanoDAOImplement.create(ligneGenreCyano);
        }
        //---- //-------------------Cyanobacetrie gene-------------------------------------------------------
        String listGeneCya = (String) PropertyUtils.getProperty(form, "listeGeneCyano");
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + listGeneCya);
        ArrayList<Object> ligne_gene_cyanof = partitionneGeneCyano(listGeneCya);

        LigneGeneCyanoDAOImplement geneCyanoDAOImplement = new LigneGeneCyanoDAOImplement(DAOFactory.getInstance());

        for (Object ligne_gene_cyanofL : ligne_gene_cyanof) {
            LigneGeneCyano ligneGeneCyano = (LigneGeneCyano) ligne_gene_cyanofL;
            ligneGeneCyano.setIdcyano(cyanobacterie.getIdcyano());
            geneCyanoDAOImplement.create(ligneGeneCyano);
        }
        //-------------------Cyanobacetrie Type gene Toxicite-------------------------------------------------------
        String listTypeGeneTox = (String) PropertyUtils.getProperty(form, "listeTypeGeneToxicite");
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + listTypeGeneTox);
        ArrayList<Object> ligne_type_gene_toxf = partitionneTypeGeneTox(listTypeGeneTox);

        LigneTypeGeneToxiciteDAOImplement ligneTypeGeneToxiciteDAOImplement = new LigneTypeGeneToxiciteDAOImplement(DAOFactory.getInstance());

        for (Object ligne_type_gene_toxfL : ligne_type_gene_toxf) {
            LigneTypeGeneToxicite ligneTypeGeneToxicite = (LigneTypeGeneToxicite) ligne_type_gene_toxfL;
            ligneTypeGeneToxicite.setIdcyano(cyanobacterie.getIdcyano());
            ligneTypeGeneToxiciteDAOImplement.create(ligneTypeGeneToxicite);
        }
        //-------------------Cyanobacetrie Type  Toxicite-------------------------------------------------------
        String listTypeTox = (String) PropertyUtils.getProperty(form, "listeTypeToxicite");
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + listTypeTox);
        ArrayList<Object> ligne_type_toxf = partitionneTypeTox(listTypeTox);

        LigneTypeToxineDAOImplement ligneTypeToxineDAOImplement = new LigneTypeToxineDAOImplement(DAOFactory.getInstance());

        for (Object ligne_type_toxfL : ligne_type_toxf) {
            LigneTypeToxine ligneTypeToxine = (LigneTypeToxine) ligne_type_toxfL;
            ligneTypeToxine.setIdcyano(cyanobacterie.getIdcyano());
            ligneTypeToxineDAOImplement.create(ligneTypeToxine);
        }
        //--------------------table autre Algue----------------------------------------------------------------
        AutreAlgue autreAlgue = new AutreAlgue();
//        autreAlgue.setIdautre_algue(1); // fake data
        AutreAlgueDAOImplement autreAlgueDAOImplement = new AutreAlgueDAOImplement(DAOFactory.getInstance());
        autreAlgue = (AutreAlgue) autreAlgueDAOImplement.create(autreAlgue);
//        
        String algue_fam_genr1 = (String) PropertyUtils.getProperty(form, "algue_fam_genre1") + "";
        String algue_fam_genr2 = (String) PropertyUtils.getProperty(form, "algue_fam_genre2") + "";
        String algue_fam_genr3 = (String) PropertyUtils.getProperty(form, "algue_fam_genre3") + "";
        String algue_fam_genr4 = (String) PropertyUtils.getProperty(form, "algue_fam_genre4") + "";
        String algue_fam_genr5 = (String) PropertyUtils.getProperty(form, "algue_fam_genre5") + "";
        String algue_fam_genr6 = (String) PropertyUtils.getProperty(form, "algue_fam_genre6") + "";
        String algue_fam_genr7 = (String) PropertyUtils.getProperty(form, "algue_fam_genre7") + "";
        String algue_fam_genr8 = (String) PropertyUtils.getProperty(form, "algue_fam_genre8") + "";
        String algue_fam_genr9 = (String) PropertyUtils.getProperty(form, "algue_fam_genre9") + "";
        String algue_fam_genr10 = (String) PropertyUtils.getProperty(form, "algue_fam_genre10") + "";
//
        System.out.println(">>>>>>>>>>>> algue_fam_genr1 =" + algue_fam_genr1);
        System.out.println(">>>>>>>>>>>>algue_fam_genr2 =" + algue_fam_genr2);
        System.out.println(">>>>>>>>>>>> algue_fam_genr3 =" + algue_fam_genr3);
        System.out.println(">>>>>>>>>>>> algue_fam_genr4 =" + algue_fam_genr4);
        System.out.println(">>>>>>>>>>>> algue_fam_genr5 =" + algue_fam_genr5);

        InsertionGenreAlgue(algue_fam_genr1, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr2, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr3, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr4, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr5, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr6, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr7, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr8, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr9, autreAlgue);
        InsertionGenreAlgue(algue_fam_genr10, autreAlgue);

        //--------------------------------------------------------------------------------------
        //Enregistrement dans echantillons
        String num_echan = (String) PropertyUtils.getProperty(form, "num_echan");
        String date_creat = (String) PropertyUtils.getProperty(form, "date_creat");
        System.out.println("**********************************************************************date creation: = " + date_creat);
        Echantillon echantillon = new Echantillon();

        echantillon.setNum_echantillon(num_echan);
        echantillon.setIdprojet(projet.getIdprojet());
        echantillon.setDate_prelevement(date_creat);
        echantillon.setIdp_phy_chim(pphychimie.getIdp_phy_chim());
        echantillon.setIdparasite(parasite.getIdparasite());
        echantillon.setIdvirus(virus.getIdvirus());
        echantillon.setIdpoint_prelevement(idpoint_prelevement);
        echantillon.setIdcyano(cyanobacterie.getIdcyano());
        echantillon.setIdautre_bacterie(autreBacterie.getIdautre_bacterie());
        echantillon.setIdautre_algue(autreAlgue.getIdautre_algue());
        echantillon.setVisible(true);
        EchantillonDAOImplement edaoi = new EchantillonDAOImplement(DAOFactory.getInstance());
        edaoi.create(echantillon);

        return mapping.findForward(SUCCESS);
    }

    public void InsertionGenreAlgue(String algue_fam_genr, AutreAlgue autreAlgue1) {

        String[] part_alg = algue_fam_genr.split(",");

        String genreAlg = "";
        String familleAlg = "";

        try {
            familleAlg = part_alg[0];
            genreAlg = part_alg[1];
        } catch (Exception e) {
        }

        String[] partGenre = genreAlg.split(";");

        AutreAlgue autreAlgue = autreAlgue1;

        //inserer dans ligne Famille
        LigneFamille ligneFamille = new LigneFamille();
        ligneFamille.setIdfamille(Integer.parseInt(familleAlg));
        ligneFamille.setIdautre_algue(autreAlgue.getIdautre_algue());
        System.out.println(">>>>>>>>>>>> idfamille = " + ligneFamille.getIdfamille());
        LigneFamilleDAOimplement ligneFamilleDAOimplement = new LigneFamilleDAOimplement(DAOFactory.getInstance());
        ligneFamille = (LigneFamille) ligneFamilleDAOimplement.create(ligneFamille);
        //inserer dans ligne genre
        for (int i = 0; i < partGenre.length - 1; i++) {

            GenreAlgue genreAlgue = new GenreAlgue();
            String desing_alg = partGenre[i].trim();
            genreAlgue.setDesign_genre_algue(desing_alg);
            System.out.println(">>>>>>>>>>>> designation Genre:  = " + i + " >>" + genreAlgue.getDesign_genre_algue());
            GenreAlgueDAOImplement genreAlgueDAOImplement = new GenreAlgueDAOImplement(DAOFactory.getInstance());
            genreAlgue = (GenreAlgue) genreAlgueDAOImplement.findS(genreAlgue);
            LigneGenreAlgue ligneGenreAlgue = new LigneGenreAlgue();
            ligneGenreAlgue.setIdgenre_algue(genreAlgue.getIdgenre_algue());
            ligneGenreAlgue.setIdligne_famille(ligneFamille.getIdligne_famille());
            LigneGenreAlgueDAOImplement ligneGenreAlgueDAOImplement = new LigneGenreAlgueDAOImplement(DAOFactory.getInstance());
            ligneGenreAlgueDAOImplement.create(ligneGenreAlgue);

        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    public ArrayList partitionneGenreCyano(String list) {
        String[] tb = list.split(",");
        int bk = tb.length / 3;
        //creer un arraylist d'objet
        ArrayList<Object> ligne_genre_cyanos = new ArrayList<>();

        int cp = 0;
        for (int i = 0; i < bk; i++) {
            LigneGenreCyano ligne_genre_cyano = new LigneGenreCyano();

            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    //A chaque item remplir une propriete
                    String s0 = tb[cp++];
                    s0 = s0.trim();

                    ligne_genre_cyano.setIdgenre_cyano(Integer.parseInt(s0));
                    System.out.println("idgenre_cyano: " + ligne_genre_cyano.getIdgenre_cyano());

                }
                if (j == 1) {
                    //A chaque item remplir une propriete
                    String s1 = tb[cp++];
                    s1 = s1.trim();

                    ligne_genre_cyano.setDenombrement_esp_cyano(Integer.parseInt(s1));

                    System.out.println("Denombrement: " + ligne_genre_cyano.getDenombrement_esp_cyano());
                }
                if (j == 2) {
                    //A chaque item remplir une propriete
                    String s2 = tb[cp++];
                    s2 = s2.trim();

                    ligne_genre_cyano.setIdespece_cyano(Integer.parseInt(s2));
                    System.out.println("idespece_cyano: " + ligne_genre_cyano.getIdespece_cyano());

                }

            }
            //Apres chaque boucle ajoute l'objet creer et remplis a l'arrayList

            ligne_genre_cyanos.add(ligne_genre_cyano);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> enregistrement genre cyano ");

            System.out.println("---------");

        }

        return ligne_genre_cyanos;
    }

    public ArrayList partitionneGeneCyano(String list) {
        String[] tb = list.split(",");
        int bk = tb.length / 2;
        //creer un arraylist d'objet
        ArrayList<Object> ligne_gene_cyanos = new ArrayList<>();

        int cp = 0;
        for (int i = 0; i < bk; i++) {
            LigneGeneCyano ligne_gene_cyano = new LigneGeneCyano();

            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    //A chaque item remplir une propriete
                    String s0 = tb[cp++];
                    s0 = s0.trim();
                    ligne_gene_cyano.setIdgene_cyano(Integer.parseInt(s0));
                    System.out.println("idgene_cyano: " + ligne_gene_cyano.getIdgene_cyano());

                }

                if (j == 1) {
                    //A chaque item remplir une propriete
                    String s1 = tb[cp++];
                    s1 = s1.trim();
                    ligne_gene_cyano.setConcentration_gene_cyano(Double.parseDouble(s1));

                    System.out.println("Concentration: " + ligne_gene_cyano.getConcentration_gene_cyano());
                }

            }
            //Apres chaque boucle ajoute l'objet creer et remplis a l'arrayList

            ligne_gene_cyanos.add(ligne_gene_cyano);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>........ enregistrement gene cyano ");

            System.out.println("---------");
        }

        return ligne_gene_cyanos;
    }

    public ArrayList partitionneTypeGeneTox(String list) {
        String[] tb = list.split(",");
        int bk = tb.length / 2;
        //creer un arraylist d'objet
        ArrayList<Object> ligne_type_gene_toxs = new ArrayList<>();

        int cp = 0;
        for (int i = 0; i < bk; i++) {
            LigneTypeGeneToxicite ligne_type_gene_tox = new LigneTypeGeneToxicite();

            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    //A chaque item remplir une propriete
                    String s0 = tb[cp++];

                    ligne_type_gene_tox.setIdtyp_gene_toxicite(Integer.parseInt(s0));
                    System.out.println("id_type_gene_tox: " + ligne_type_gene_tox.getIdtyp_gene_toxicite());

                }

                if (j == 1) {
                    //A chaque item remplir une propriete
                    String s1 = tb[cp++];
                    s1 = s1.trim();

                    ligne_type_gene_tox.setConcentration_gene_toxicite(Double.parseDouble(s1));

                    System.out.println("Concentration: " + ligne_type_gene_tox.getConcentration_gene_toxicite());
                }

            }
            //Apres chaque boucle ajoute l'objet creer et remplis a l'arrayList

            ligne_type_gene_toxs.add(ligne_type_gene_tox);
            System.out.println("---------");

        }

        return ligne_type_gene_toxs;
    }

    private ArrayList<Object> partitionneTypeTox(String list) {

        String[] tb = list.split(",");
        int bk = tb.length / 2;
        //creer un arraylist d'objet
        ArrayList<Object> ligne_type_toxs = new ArrayList<>();

        int cp = 0;
        for (int i = 0; i < bk; i++) {
            LigneTypeToxine ligne_type_tox = new LigneTypeToxine();

            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    //A chaque item remplir une propriete
                    String s0 = tb[cp++];

                    ligne_type_tox.setIdtype_toxine(Integer.parseInt(s0));
                    System.out.println("id_type_tox: " + ligne_type_tox.getIdtype_toxine());

                }

                if (j == 1) {
                    //A chaque item remplir une propriete
                    String s1 = tb[cp++];
                    s1 = s1.trim();

                    ligne_type_tox.setConcentration_type_toxicite(Double.parseDouble(s1));

                    System.out.println("Concentration: " + ligne_type_tox.getConcentration_type_toxicite());
                }

            }
            //Apres chaque boucle ajoute l'objet creer et remplis a l'arrayList

            ligne_type_toxs.add(ligne_type_tox);

            System.out.println("---------");

        }

        return ligne_type_toxs;
    }

}
