/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_algue;

import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
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
public class CreerEspeceAlgPageAction extends org.apache.struts.action.Action {

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
        
        
         GenreAlgueDAOImplement GenreDAO = new GenreAlgueDAOImplement(DAOFactory.getInstance());
       ArrayList<Object> genreList = GenreDAO.find();

         
        request.setAttribute("genre_trouve", genreList);
        return mapping.findForward(SUCCESS);
    }
}
