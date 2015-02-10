/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.autre_algue.dao.AutreAlgueDAOImplement;
import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Projet;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.eclairage.dao.EclairageDAOImplement;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.espece_cyano.dao.EspeceCyanoDAOImplement;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
import com.pasteur.ci.gene_cyano.dao.GeneCyanoDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
import com.pasteur.ci.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.projet.dao.ProjetDAOImplement;
import com.pasteur.ci.type_gene_cyano.dao.TypeGeneCyanoDAOImplement;
import com.pasteur.ci.type_gene_toxicite.dao.TypeGeneToxiciteDAOImplement;
import com.pasteur.ci.type_toxine.dao.TypeToxineDAOImplement;
import com.pasteur.ci.virus.dao.VirusDAOImplement;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Abouchou
 */
public class Chargepagecreation extends org.apache.struts.action.Action {

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
        FamilleDAOImplement famille = new FamilleDAOImplement(DAOFactory.getInstance()); //ok
        EclairageDAOImplement eclaidao = new EclairageDAOImplement(DAOFactory.getInstance()); //ok
        PointPrelevementDAOImplement pointPrelevementDAOImplement = new PointPrelevementDAOImplement(DAOFactory.getInstance());//ok
        ProjetDAOImplement projetDAOImplement = new ProjetDAOImplement(DAOFactory.getInstance());//ok

        GenreAlgueDAOImplement genre_algue = new GenreAlgueDAOImplement(DAOFactory.getInstance());
        EspeceAlgueDAOImplement espece_algue = new EspeceAlgueDAOImplement(DAOFactory.getInstance());
        AutreAlgueDAOImplement autre_algue = new AutreAlgueDAOImplement(DAOFactory.getInstance());
        PratiqueDAOImplement pratique = new PratiqueDAOImplement(DAOFactory.getInstance());
        GenreCyanoDAOImplement genrecyano = new GenreCyanoDAOImplement(DAOFactory.getInstance());
        EspeceCyanoDAOImplement espececyano = new EspeceCyanoDAOImplement(DAOFactory.getInstance());
        GeneCyanoDAOImplement genecyano = new GeneCyanoDAOImplement(DAOFactory.getInstance());
        TypeGeneToxiciteDAOImplement typegenetox = new TypeGeneToxiciteDAOImplement(DAOFactory.getInstance());
        TypeToxineDAOImplement typetoxine = new TypeToxineDAOImplement(DAOFactory.getInstance());
         
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
//        ArrayList<Object> listeAlgue = autre_algue.find();
        ArrayList<Object> listePratique = pratique.find();
        ArrayList<Object> listeTypeToxine = typetoxine.find();
          
        request.setAttribute("pointprelev_trouve", listePointPrelev);
        request.setAttribute("projet_trouve", listeProjet);
        request.setAttribute("eclai_trouve", listeclai);
        request.setAttribute("espece_trouve", listeEspAlg);
        request.setAttribute("genre_trouve", listGenAlg);
        request.setAttribute("famille_trouve", listeFam);
//        request.setAttribute("algue_trouve", listeAlgue);
        request.setAttribute("pratique_trouve", listePratique);
        request.setAttribute("genrecya_trouve", listeGenreCya);
        request.setAttribute("espececya_trouve", listeEspCya);
        request.setAttribute("genecya_trouve", listeGeneCya);
        request.setAttribute("typegenetox_trouve", listeTypeGeneTox);
        request.setAttribute("typetoxine_trouve", listeTypeToxine);

        return mapping.findForward(SUCCESS);
    }
}
