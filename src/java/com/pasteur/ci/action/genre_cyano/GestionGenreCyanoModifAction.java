/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.genre_cyano;

import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.bean.GenreCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class GestionGenreCyanoModifAction extends org.apache.struts.action.Action {

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
     int idquart = (Integer) PropertyUtils.getProperty(form, "idgenre_cyano");
        GenreCyano genre_cyano = new GenreCyano();
        genre_cyano.setIdgenre_cyano(Integer.valueOf(idquart));
        GenreCyanoDAOImplement qdaoi = new GenreCyanoDAOImplement(DAOFactory.getInstance());
        genre_cyano = (GenreCyano) qdaoi.find(genre_cyano);
        request.setAttribute("genrecyano_trouve", genre_cyano);
        return mapping.findForward(SUCCESS);
    }
}
