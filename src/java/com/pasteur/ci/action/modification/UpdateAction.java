/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.modification;

import com.pasteur.ci.autre_bacterie.dao.AutreBacterieDAOImplement;
import com.pasteur.ci.bean.AutreAlgue;
import com.pasteur.ci.bean.AutreBacterie;
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
import com.pasteur.ci.bean.Virus;
import com.pasteur.ci.config.DAOFactory;
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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class UpdateAction extends org.apache.struts.action.Action {

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

        String num_echant = (String) PropertyUtils.getProperty(form, "num_echantillon");
        System.out.println("num Echantillon: " + num_echant);
        Echantillon echantillon = new Echantillon();
        echantillon.setNum_echantillon(num_echant);
        EchantillonDAOImplement echantillonDAOImplement = new EchantillonDAOImplement(DAOFactory.getInstance());
        echantillon = (Echantillon) echantillonDAOImplement.find(echantillon);

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
        autreBacterie.setIdautre_bacterie(echantillon.getIdautre_bacterie());
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

        AutreBacterieDAOImplement autreBacterieDAOImplement = new AutreBacterieDAOImplement(DAOFactory.getInstance());
        autreBacterie = (AutreBacterie) autreBacterieDAOImplement.update(autreBacterie);
//////////////////////
        int cryptosporidium = (Integer) PropertyUtils.getProperty(form, "cryptosporidium");
        int giardia = (Integer) PropertyUtils.getProperty(form, "giardia");
        int helminthe = (Integer) PropertyUtils.getProperty(form, "helminthe");

        Parasite parasite = new Parasite();

        parasite.setIdparasite(echantillon.getIdparasite());
        parasite.setGiardia(giardia);
        parasite.setCryptosporidium(cryptosporidium);
        parasite.setHelminthe(helminthe);

        ParasiteDAOImplement pdaoic = new ParasiteDAOImplement(DAOFactory.getInstance());
        parasite = (Parasite) pdaoic.update(parasite);
//////////////////////////////////////
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

        PPhyChim pphychimie = new PPhyChim();

        pphychimie.setIdp_phy_chim(echantillon.getIdp_phy_chim());
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

        PPhyChimDAOImplement ppcdaoi = new PPhyChimDAOImplement(DAOFactory.getInstance());
        pphychimie = (PPhyChim) ppcdaoi.update(pphychimie);
        ////////////////

        int enterovirus = (int) PropertyUtils.getProperty(form, "enterovirus");

        Virus virus = new Virus();
        virus.setIdvirus(echantillon.getIdvirus());
        virus.setEnterovirus(enterovirus);

        VirusDAOImplement vdaoi = new VirusDAOImplement(DAOFactory.getInstance());
        virus = (Virus) vdaoi.update(virus);
        /////////////////

        int idprojet = (Integer) PropertyUtils.getProperty(form, "idprojet");

        String date_creat = (String) PropertyUtils.getProperty(form, "date_creat");
        echantillon.setIdprojet(idprojet);
        echantillon.setDate_prelevement(date_creat);
        EchantillonDAOImplement edaoi = new EchantillonDAOImplement(DAOFactory.getInstance());
        edaoi.update(echantillon);

        //////////
        LigneGenreCyano ligneGenreCyano = new LigneGenreCyano();
        ligneGenreCyano.setIdcyano(echantillon.getIdcyano());
        LigneGenreCyanoDAOImplement ligneGenreCyanoDAOImplement = new LigneGenreCyanoDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneGenreCyanos = ligneGenreCyanoDAOImplement.find(ligneGenreCyano);  //liste1

        String listGenreCya = (String) PropertyUtils.getProperty(form, "listeGenreCyano");

        ArrayList<Object> ligne_genre_cyanof = partitionneGenreCyano(listGenreCya); //liste2

        for (int i = 0; i < ligne_genre_cyanof.size(); i++) {
            LigneGenreCyano ligneGenreCyano_ = (LigneGenreCyano) ligneGenreCyanos.get(i);
            LigneGenreCyano ligneGenreCyano1 = (LigneGenreCyano) ligne_genre_cyanof.get(i);
            ligneGenreCyano1.setIdligne_genre_cyano(ligneGenreCyano_.getIdligne_genre_cyano());
            ligneGenreCyano1.setIdcyano(echantillon.getIdcyano());
            ligneGenreCyanoDAOImplement.update(ligneGenreCyano1);
        }

        ///////////////
        LigneGeneCyano ligneGeneCyano = new LigneGeneCyano();
        ligneGeneCyano.setIdcyano(echantillon.getIdcyano());
        LigneGeneCyanoDAOImplement ligneGeneCyanoDAOImplement = new LigneGeneCyanoDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneGeneCyanos = ligneGeneCyanoDAOImplement.find(ligneGeneCyano); //liste1

        String listGeneCya = (String) PropertyUtils.getProperty(form, "listeGeneCyano");
        ArrayList<Object> ligne_gene_cyanof = partitionneGeneCyano(listGeneCya);

        LigneGeneCyanoDAOImplement geneCyanoDAOImplement = new LigneGeneCyanoDAOImplement(DAOFactory.getInstance());

        for (int i = 0; i < ligne_gene_cyanof.size(); i++) {
            LigneGeneCyano ligneGeneCyano_ = (LigneGeneCyano) ligneGeneCyanos.get(i);
            LigneGeneCyano ligneGeneCyano1 = (LigneGeneCyano) ligne_gene_cyanof.get(i);
            ligneGeneCyano1.setIdligne_gene_cyano(ligneGeneCyano_.getIdligne_gene_cyano());
            ligneGeneCyano1.setIdcyano(echantillon.getIdcyano());
            geneCyanoDAOImplement.update(ligneGeneCyano1);
        }
        ///////////////
        LigneTypeGeneToxicite ligneTypeGeneToxicite = new LigneTypeGeneToxicite();
        ligneTypeGeneToxicite.setIdcyano(echantillon.getIdcyano());
        LigneTypeGeneToxiciteDAOImplement typeGeneToxiciteDAOImplement = new LigneTypeGeneToxiciteDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneTypeGeneToxicites = typeGeneToxiciteDAOImplement.find(ligneTypeGeneToxicite);

        String listTypeGeneTox = (String) PropertyUtils.getProperty(form, "listeTypeGeneToxicite");

        ArrayList<Object> ligne_type_gene_toxf = partitionneTypeGeneTox(listTypeGeneTox);

        LigneTypeGeneToxiciteDAOImplement ligneTypeGeneToxiciteDAOImplement = new LigneTypeGeneToxiciteDAOImplement(DAOFactory.getInstance());

        for (int i = 0; i < ligne_type_gene_toxf.size(); i++) {
            LigneTypeGeneToxicite ligneTypeGeneToxicite_ = (LigneTypeGeneToxicite) ligneTypeGeneToxicites.get(i);
            LigneTypeGeneToxicite ligneTypeGeneToxicite1 = (LigneTypeGeneToxicite) ligne_type_gene_toxf.get(i);
            ligneTypeGeneToxicite1.setIdlignetype_toxicite(ligneTypeGeneToxicite_.getIdlignetype_toxicite());
            ligneTypeGeneToxicite1.setIdcyano(echantillon.getIdcyano());
            ligneTypeGeneToxiciteDAOImplement.update(ligneTypeGeneToxicite1);
        }

        ////////////////////////////////////
        LigneTypeToxine ligneTypeToxine = new LigneTypeToxine();
        ligneTypeToxine.setIdcyano(echantillon.getIdcyano());
        LigneTypeToxineDAOImplement ligneTypeToxineDAOImplement = new LigneTypeToxineDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneTypeToxines = ligneTypeToxineDAOImplement.find(ligneTypeToxine);

        String listTypeTox = (String) PropertyUtils.getProperty(form, "listeTypeToxicite");

        ArrayList<Object> ligne_type_toxf = partitionneTypeTox(listTypeTox);

        for (int i = 0; i < ligne_type_gene_toxf.size(); i++) {
            LigneTypeToxine ligneTypeToxine_ = (LigneTypeToxine) ligneTypeToxines.get(i);
            LigneTypeToxine ligneTypeToxine1 = (LigneTypeToxine) ligne_type_toxf.get(i);
            ligneTypeToxine1.setIdligne_type_toxine(ligneTypeToxine_.getIdligne_type_toxine());
            ligneTypeToxine1.setIdcyano(echantillon.getIdcyano());
            ligneTypeToxineDAOImplement.update(ligneTypeToxine1);
        }

        /////////////////////////////////////
        LigneFamille ligneFamille = new LigneFamille();
        ligneFamille.setIdautre_algue(echantillon.getIdautre_algue());
        LigneFamilleDAOimplement ligneFamilleDAOimplement = new LigneFamilleDAOimplement(DAOFactory.getInstance());
        ArrayList<Object>  ligneFamilles = ligneFamilleDAOimplement.find(ligneFamille);

        for (int i = 1; i <= ligneFamilles.size(); i++) {
            LigneFamille ligneFamille_ = (LigneFamille) ligneFamilles.get(i-1);

            String algue_fam_genr = (String) PropertyUtils.getProperty(form, "algue_fam_genre" + i) + "";
            System.out.println("algue_fam_genre"+i+ ": "+ algue_fam_genr);
            String[] part_alg = algue_fam_genr.split(",");

            String genreAlg = "";
            String familleAlg = "";

            try {
                familleAlg = part_alg[0];
                genreAlg = part_alg[1];

            } catch (Exception e) {
            }

            String[] partGenre = genreAlg.split(";");
            //inserer dans ligne Famille
            LigneFamille ligneFamille1 = new LigneFamille();
            ligneFamille1.setIdligne_famille(ligneFamille_.getIdligne_famille());
            ligneFamille1.setIdfamille(Integer.parseInt(familleAlg));
            ligneFamille1.setIdautre_algue(echantillon.getIdautre_algue());
            ligneFamille1 =(LigneFamille) ligneFamilleDAOimplement.update(ligneFamille1);
               
            //supprimer les lignes genre ayant ce idlignefamille
            LigneGenreAlgue ligneGenreAlgueDl = new LigneGenreAlgue();
            ligneGenreAlgueDl.setIdligne_famille(ligneFamille1.getIdligne_famille());
            LigneGenreAlgueDAOImplement ligneGenreAlgueDAOImplementDl = new LigneGenreAlgueDAOImplement(DAOFactory.getInstance());
            ligneGenreAlgueDAOImplementDl.delete(ligneGenreAlgueDl);
            
            for (int j = 0; j < partGenre.length - 1; j++) {
                GenreAlgue genreAlgue = new GenreAlgue();
                String desing_alg = partGenre[j].trim();
                genreAlgue.setDesign_genre_algue(desing_alg);

                GenreAlgueDAOImplement genreAlgueDAOImplement = new GenreAlgueDAOImplement(DAOFactory.getInstance());
                genreAlgue = (GenreAlgue) genreAlgueDAOImplement.findS(genreAlgue);
                LigneGenreAlgue ligneGenreAlgue = new LigneGenreAlgue();
                ligneGenreAlgue.setIdgenre_algue(genreAlgue.getIdgenre_algue());
                ligneGenreAlgue.setIdligne_famille(ligneFamille1.getIdligne_famille());
                LigneGenreAlgueDAOImplement ligneGenreAlgueDAOImplement = new LigneGenreAlgueDAOImplement(DAOFactory.getInstance());
                ligneGenreAlgueDAOImplement.create(ligneGenreAlgue);
            }
        }

        ///////////////////////////////////
        return mapping.findForward(SUCCESS);
    }

    public void InsertionGenreAlgue(String algue_fam_genr, AutreAlgue autreAlgue1) {

        String[] part_alg = algue_fam_genr.split(",");

        String genreAlg = "";
        String familleAlg = "";

        try {
            familleAlg = part_alg[0];
            System.out.println(" --- genre Algue= " + part_alg[1]);
            genreAlg = part_alg[1];
            System.out.println("famille algue= " + familleAlg + " --- genre Algue= " + genreAlg);
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
