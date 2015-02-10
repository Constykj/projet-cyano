/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_cyano;

import com.pasteur.ci.bean.EspeceCyano;
import com.pasteur.ci.bean.GenreCyano;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_cyano.dao.EspeceCyanoDAOImplement;
import com.pasteur.ci.genre_cyano.dao.GenreCyanoDAOImplement;
import java.util.ArrayList;
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
public class GestionEspeceCyanoModifAction extends org.apache.struts.action.Action {

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
        int EspeceCyaId = (int) PropertyUtils.getProperty(form, "idespece_cyano");

        EspeceCyano espece_cyano = new EspeceCyano();
        espece_cyano.setIdespece_cyano(EspeceCyaId);
        
        EspeceCyanoDAOImplement EspeceDAO = new EspeceCyanoDAOImplement(DAOFactory.getInstance());
        
        espece_cyano = (EspeceCyano) EspeceDAO.find(espece_cyano);
        
        

        int _genre_cyano = espece_cyano.getIdgenre_cyano();

        GenreCyanoDAOImplement GenreDAO = new GenreCyanoDAOImplement(DAOFactory.getInstance());
        GenreCyano genre_cay = new GenreCyano();
        genre_cay.setIdgenre_cyano(_genre_cyano);
        genre_cay = (GenreCyano) GenreDAO.find(genre_cay);

        ArrayList<Object> genreList = GenreDAO.find();

        request.setAttribute("espececyano_liste", espece_cyano);
        request.setAttribute("genre_trouve", genreList);

        return mapping.findForward(SUCCESS);
    }
}
