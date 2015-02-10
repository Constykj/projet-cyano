/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.espece_algue;

import com.pasteur.ci.bean.EspeceAlgue;
import com.pasteur.ci.bean.EspeceAlgues;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
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
public class GestionEspeceAction extends org.apache.struts.action.Action {

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

        EspeceAlgueDAOImplement stdaoi = new EspeceAlgueDAOImplement(DAOFactory.getInstance());

        ArrayList<EspeceAlgues> listst = new ArrayList<EspeceAlgues>();

        ArrayList<Object> list = stdaoi.find();
        for (int i = 0; i < list.size(); i++) {

            EspeceAlgue espece_algue = (EspeceAlgue) list.get(i);
            int _idespA = espece_algue.getIdespece_algue();
            int _idgenrA = espece_algue.getIdgenre_algue();
            String _design = espece_algue.getDesign_espece_algue();
            Boolean _visb = espece_algue.isVisible();

            GenreAlgue genreAlg = new GenreAlgue();
            genreAlg.setIdgenre_algue(_idgenrA);
            genreAlg = (GenreAlgue) GenreDAO.find(genreAlg);

            EspeceAlgues stp = new EspeceAlgues();
            stp.setIdespece_algue(_idespA);
            stp.setGenre_algue(genreAlg.getDesign_genre_algue());
            stp.setDesign_espece_algue(_design);
            stp.setVisible(_visb);
            listst.add(stp);

        }
ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < listst.size(); i++) {
            listf.add(listst.get(i));
        }
        request.setAttribute("liste_espece", listf);

        return mapping.findForward(SUCCESS);
    }
}
