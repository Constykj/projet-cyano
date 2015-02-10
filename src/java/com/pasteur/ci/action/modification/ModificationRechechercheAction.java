/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.modification;

import com.pasteur.ci.autre_bacterie.dao.AutreBacterieDAOImplement;
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
import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Projet;
import com.pasteur.ci.bean.Virus;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.echantillon.dao.EchantillonDAOImplement;
import com.pasteur.ci.eclairage.dao.EclairageDAOImplement;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.espece_cyano.dao.EspeceCyanoDAOImplement;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
import com.pasteur.ci.gene_cyano.dao.GeneCyanoDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
import com.pasteur.ci.ligne_famille.dao.LigneFamilleDAOimplement;
import com.pasteur.ci.ligne_gene_cyano.dao.LigneGeneCyanoDAOImplement;
import com.pasteur.ci.ligne_genre_algue.dao.LigneGenreAlgueDAOImplement;
import com.pasteur.ci.ligne_genre_cyano.dao.LigneGenreCyanoDAOImplement;
import com.pasteur.ci.ligne_type_gene_toxicite.dao.LigneTypeGeneToxiciteDAOImplement;
import com.pasteur.ci.ligne_type_toxine.dao.LigneTypeToxineDAOImplement;
import com.pasteur.ci.p_phy_chim.dao.PPhyChimDAOImplement;
import com.pasteur.ci.parasite.dao.ParasiteDAOImplement;
import com.pasteur.ci.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.projet.dao.ProjetDAOImplement;
import com.pasteur.ci.type_gene_toxicite.dao.TypeGeneToxiciteDAOImplement;
import com.pasteur.ci.type_toxine.dao.TypeToxineDAOImplement;
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
public class ModificationRechechercheAction extends org.apache.struts.action.Action {

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

        String num_echan = (String) PropertyUtils.getProperty(form, "num_echan");

        Echantillon echantillon = new Echantillon();
        echantillon.setNum_echantillon(num_echan);
        EchantillonDAOImplement echantillonDAOImplement = new EchantillonDAOImplement(DAOFactory.getInstance());
        echantillon = (Echantillon) echantillonDAOImplement.find(echantillon);

        System.out.println("Echantillon: \n"
                + " idechantillon: " + echantillon.getIdechantillon() + "\n"
                + " numero echantillon: " + echantillon.getNum_echantillon() + "\n"
                + " idprojet: " + echantillon.getIdprojet() + "\n"
                + " date de prelevement: " + echantillon.getDate_prelevement() + "\n"
                + " idpoint_prelevement: " + echantillon.getIdpoint_prelevement() + "\n"
                + " idparasite: " + echantillon.getIdparasite() + "\n"
                + " idvirus: " + echantillon.getIdvirus() + "\n"
                + " idp_physico_chimique: " + echantillon.getIdp_phy_chim() + "\n"
                + " idcyano: " + echantillon.getIdcyano() + "\n"
                + " idautre_bacterie: " + echantillon.getIdautre_bacterie() + "\n"
                + " idautre_algue: " + echantillon.getIdautre_algue() + "\n"
                + "");

        AutreBacterie autreBacterie = new AutreBacterie();
        autreBacterie.setIdautre_bacterie(echantillon.getIdautre_bacterie());
        AutreBacterieDAOImplement autreBacterieDAOImplement = new AutreBacterieDAOImplement(DAOFactory.getInstance());
        autreBacterie = (AutreBacterie) autreBacterieDAOImplement.find(autreBacterie);

        Parasite parasite = new Parasite();
        parasite.setIdparasite(echantillon.getIdparasite());
        ParasiteDAOImplement parasiteDAOImplement = new ParasiteDAOImplement(DAOFactory.getInstance());
        parasite = (Parasite) parasiteDAOImplement.find(parasite);

        Virus virus = new Virus();
        virus.setIdvirus(echantillon.getIdvirus());
        VirusDAOImplement virusDAOImplement = new VirusDAOImplement(DAOFactory.getInstance());
        virus = (Virus) virusDAOImplement.find(virus);

        Projet projetf = new Projet();
        projetf.setIdprojet(echantillon.getIdprojet());
        ProjetDAOImplement projetDAOImplementf = new ProjetDAOImplement(DAOFactory.getInstance());
        projetf = (Projet) projetDAOImplementf.find(projetf);

        PointPrelevement pointPrelevementf = new PointPrelevement();
        pointPrelevementf.setIdpoint_prelevement(echantillon.getIdpoint_prelevement());
        PointPrelevementDAOImplement pointPrelevementDAOImplementf = new PointPrelevementDAOImplement(DAOFactory.getInstance());
        pointPrelevementf = (PointPrelevement) pointPrelevementDAOImplementf.find(pointPrelevementf);

        PPhyChim pphychimie = new PPhyChim();
        pphychimie.setIdp_phy_chim(echantillon.getIdp_phy_chim());
        PPhyChimDAOImplement ppcdaoi = new PPhyChimDAOImplement(DAOFactory.getInstance());
        pphychimie = (PPhyChim) ppcdaoi.find(pphychimie);

        FamilleDAOImplement famille = new FamilleDAOImplement(DAOFactory.getInstance()); //ok
        EclairageDAOImplement eclaidao = new EclairageDAOImplement(DAOFactory.getInstance()); //ok
        PointPrelevementDAOImplement pointPrelevementDAOImplement = new PointPrelevementDAOImplement(DAOFactory.getInstance());//ok
        ProjetDAOImplement projetDAOImplement = new ProjetDAOImplement(DAOFactory.getInstance());//ok

        GenreAlgueDAOImplement genre_algue = new GenreAlgueDAOImplement(DAOFactory.getInstance());
        EspeceAlgueDAOImplement espece_algue = new EspeceAlgueDAOImplement(DAOFactory.getInstance());
        // AutreAlgueDAOImplement autre_algue = new AutreAlgueDAOImplement(DAOFactory.getInstance());
        PratiqueDAOImplement pratique = new PratiqueDAOImplement(DAOFactory.getInstance());
        GenreCyanoDAOImplement genrecyano = new GenreCyanoDAOImplement(DAOFactory.getInstance());
        EspeceCyanoDAOImplement espececyano = new EspeceCyanoDAOImplement(DAOFactory.getInstance());
        GeneCyanoDAOImplement genecyano = new GeneCyanoDAOImplement(DAOFactory.getInstance());
        TypeGeneToxiciteDAOImplement typegenetox = new TypeGeneToxiciteDAOImplement(DAOFactory.getInstance());
        TypeToxineDAOImplement typetoxine = new TypeToxineDAOImplement(DAOFactory.getInstance());

        LigneGeneCyano ligneGeneCyano = new LigneGeneCyano();
        ligneGeneCyano.setIdcyano(echantillon.getIdcyano());
        LigneGeneCyanoDAOImplement ligneGeneCyanoDAOImplement = new LigneGeneCyanoDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneGeneCyanos = ligneGeneCyanoDAOImplement.find(ligneGeneCyano);
        for (int i = 1; i <= ligneGeneCyanos.size(); i++) {
            request.setAttribute("ligneGeneCyano_trouve" + i, (LigneGeneCyano) ligneGeneCyanos.get(i - 1));
        }

        LigneTypeToxine ligneTypeToxine = new LigneTypeToxine();
        ligneTypeToxine.setIdcyano(echantillon.getIdcyano());
        LigneTypeToxineDAOImplement ligneTypeToxineDAOImplement = new LigneTypeToxineDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneTypeToxines = ligneTypeToxineDAOImplement.find(ligneTypeToxine);
        for (int i = 1; i <= ligneTypeToxines.size(); i++) {
            request.setAttribute("ligneTypeTox_trouve" + i, (LigneTypeToxine) ligneTypeToxines.get(i - 1));
        }

        LigneTypeGeneToxicite ligneTypeGeneToxicite = new LigneTypeGeneToxicite();
        ligneTypeGeneToxicite.setIdcyano(echantillon.getIdcyano());
        LigneTypeGeneToxiciteDAOImplement typeGeneToxiciteDAOImplement = new LigneTypeGeneToxiciteDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneTypeGeneToxicites = typeGeneToxiciteDAOImplement.find(ligneTypeGeneToxicite);
        for (int i = 1; i <= ligneTypeGeneToxicites.size(); i++) {
            request.setAttribute("ligneTypeGeneToxi_trouve" + i, (LigneTypeGeneToxicite) ligneTypeGeneToxicites.get(i - 1));
        }

        LigneGenreCyano ligneGenreCyano = new LigneGenreCyano();
        ligneGenreCyano.setIdcyano(echantillon.getIdcyano());
        LigneGenreCyanoDAOImplement ligneGenreCyanoDAOImplement = new LigneGenreCyanoDAOImplement(DAOFactory.getInstance());
        ArrayList<Object> ligneGenreCyanos = ligneGenreCyanoDAOImplement.find(ligneGenreCyano);
        for (int i = 1; i <= ligneGenreCyanos.size(); i++) {
            request.setAttribute("ligneGenreCyano_trouve" + i, (LigneGenreCyano) ligneGenreCyanos.get(i - 1));
        }

        LigneFamille ligneFamille = new LigneFamille();
        ligneFamille.setIdautre_algue(echantillon.getIdautre_algue());
        LigneFamilleDAOimplement ligneFamilleDAOimplement = new LigneFamilleDAOimplement(DAOFactory.getInstance());
        ArrayList<Object> ligneFamilles = ligneFamilleDAOimplement.find(ligneFamille);
        for (int i = 1; i <= ligneFamilles.size(); i++) {
            LigneFamille ligneFamille1 = (LigneFamille) ligneFamilles.get(i - 1);
            request.setAttribute("ligneFamille_trouve" + i, ligneFamille1);
            LigneGenreAlgue ligneGenreAlgue = new LigneGenreAlgue();
            ligneGenreAlgue.setIdligne_famille(ligneFamille1.getIdligne_famille());
            LigneGenreAlgueDAOImplement ligneGenreAlgueDAOImplement = new LigneGenreAlgueDAOImplement(DAOFactory.getInstance());
            ArrayList<Object> ligneGenreAlgues = ligneGenreAlgueDAOImplement.find(ligneGenreAlgue);
            String listeGenreAl = "";
            for (int j = 1; j <= ligneGenreAlgues.size(); j++) {
                LigneGenreAlgue ligneGenreAlgue1 = (LigneGenreAlgue) ligneGenreAlgues.get(j - 1);
                GenreAlgue genreAlgue = new GenreAlgue();
                genreAlgue.setIdgenre_algue(ligneGenreAlgue1.getIdgenre_algue());
                GenreAlgueDAOImplement genreAlgueDAOImplement = new GenreAlgueDAOImplement(DAOFactory.getInstance());
                genreAlgue = (GenreAlgue) genreAlgueDAOImplement.find(genreAlgue);
                listeGenreAl = listeGenreAl + genreAlgue.getDesign_genre_algue() + "; ";
            }
            GenreAlgue genreAlgue_ = new GenreAlgue();
            genreAlgue_.setGenreAlgue(listeGenreAl);
            request.setAttribute("ligne_listeGenreAlgue_trouve" + i, genreAlgue_);
        }

        ArrayList<Object> listePointPrelev = pointPrelevementDAOImplement.find();
        ArrayList<Object> listeProjet = projetDAOImplement.find();
        ArrayList<Object> listeclai = eclaidao.find();
        ArrayList<Object> listeFam = famille.find();
        ArrayList<Object> listGenAlg = genre_algue.find();
        ArrayList<Object> listeEspAlg = espece_algue.find();
        ArrayList<Object> listeGenreCya = genrecyano.find();
        ArrayList<Object> listeEspCya = espececyano.find();
        ArrayList<Object> listeGeneCya = genecyano.find();
        ArrayList<Object> listeTypeGeneTox = typegenetox.find();
        ArrayList<Object> listePratique = pratique.find();
        ArrayList<Object> listeTypeToxine = typetoxine.find();

        request.setAttribute("pointprelev_trouve", listePointPrelev);
        request.setAttribute("projet_trouve", listeProjet);
        request.setAttribute("eclai_trouve", listeclai);
        request.setAttribute("espece_trouve", listeEspAlg);
        request.setAttribute("genre_trouve", listGenAlg);
        request.setAttribute("famille_trouve", listeFam);
        request.setAttribute("num_trouve", echantillon);
        request.setAttribute("pratique_trouve", listePratique);
        request.setAttribute("genrecya_trouve", listeGenreCya);
        request.setAttribute("espececya_trouve", listeEspCya);
        request.setAttribute("genecya_trouve", listeGeneCya);
        request.setAttribute("typegenetox_trouve", listeTypeGeneTox);
        request.setAttribute("typetoxine_trouve", listeTypeToxine);
        //
        request.setAttribute("ab_trouve", autreBacterie);
        request.setAttribute("para_trouve", parasite);
        request.setAttribute("virus_trouve", virus);
        request.setAttribute("projet_trouvef", projetf);
        request.setAttribute("ppmt_trouvef", pointPrelevementf);
        request.setAttribute("ppchim_trouve", pphychimie);

        request.setAttribute("liste_gene_cyano_trouve", ligneGeneCyanos);

        return mapping.findForward(SUCCESS);
    }
}
