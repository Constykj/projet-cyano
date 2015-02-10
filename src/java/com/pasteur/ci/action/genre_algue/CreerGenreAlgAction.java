/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.genre_algue;

import com.pasteur.ci.bean.Famille;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
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
public class CreerGenreAlgAction extends org.apache.struts.action.Action {

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
        int idfamille = (Integer) PropertyUtils.getProperty(form, "idfamille");
        String design_genre_algue = (String) PropertyUtils.getProperty(form, "design_genre_algue");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        GenreAlgue genre_algue = new GenreAlgue();
        genre_algue.setIdfamille(idfamille);
        genre_algue.setDesign_genre_algue(design_genre_algue);
        genre_algue.setVisible(visible);
        GenreAlgueDAOImplement gdaoi = new GenreAlgueDAOImplement(DAOFactory.getInstance());
        gdaoi.create(genre_algue);
        return mapping.findForward(SUCCESS);
    }
}
