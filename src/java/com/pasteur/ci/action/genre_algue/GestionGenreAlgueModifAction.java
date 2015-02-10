/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.genre_algue;

import com.pasteur.ci.bean.EspeceAlgue;
import com.pasteur.ci.bean.Famille;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import java.util.ArrayList;
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
public class GestionGenreAlgueModifAction extends org.apache.struts.action.Action {

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
        
      int GenreAlgId = (Integer) PropertyUtils.getProperty(form, "idgenre_algue");

        GenreAlgue genreAlgue = new GenreAlgue();
        genreAlgue.setIdgenre_algue(GenreAlgId);
        GenreAlgueDAOImplement stdaoi = new GenreAlgueDAOImplement(DAOFactory.getInstance());
        genreAlgue = (GenreAlgue) stdaoi.find(genreAlgue);

        int fam = genreAlgue.getIdfamille();

        FamilleDAOImplement familleDAO = new FamilleDAOImplement(DAOFactory.getInstance());
        Famille famille = new Famille();
        famille.setIdfamille(fam);
        famille = (Famille) familleDAO.find(famille);

        ArrayList<Object> familles = familleDAO.find();

        request.setAttribute("genre_trouve", genreAlgue);
        request.setAttribute("fanie_trouve", familles);
        return mapping.findForward(SUCCESS);
    }
}
