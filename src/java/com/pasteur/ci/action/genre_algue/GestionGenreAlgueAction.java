/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.genre_algue;

import com.pasteur.ci.bean.EspeceAlgue;
import com.pasteur.ci.bean.EspeceAlgues;
import com.pasteur.ci.bean.Famille;
import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.bean.GenreAlgues;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.espece_algue.dao.EspeceAlgueDAOImplement;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
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
public class GestionGenreAlgueAction extends org.apache.struts.action.Action {

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
        FamilleDAOImplement pdaoi = new FamilleDAOImplement(DAOFactory.getInstance());

        GenreAlgue statpr = new GenreAlgue();
        GenreAlgueDAOImplement stdaoi = new GenreAlgueDAOImplement(DAOFactory.getInstance());

        ArrayList<GenreAlgues> listst = new ArrayList<GenreAlgues>();

        ArrayList<Object> list = stdaoi.find();
        for (int i = 0; i < list.size(); i++) {

            GenreAlgue Stat_pr = (GenreAlgue) list.get(i);
            int _idfamille = Stat_pr.getIdfamille();
            int _idgenrA = Stat_pr.getIdgenre_algue();
            String _design = Stat_pr.getDesign_genre_algue();
            Boolean _visb = Stat_pr.isVisible();

            Famille plan_eau = new Famille();
            plan_eau.setIdfamille(_idfamille);
            plan_eau = (Famille) pdaoi.find(plan_eau);

            GenreAlgues stp = new GenreAlgues();
            stp.setIdgenre_algue(_idgenrA);
            stp.setDesign_genre_algue(_design);
            stp.setFamille(plan_eau.getDesign_famille());
            stp.setVisible(_visb);
            listst.add(stp);

        }

        ArrayList<Object> listf = new ArrayList<>();
        for (int i = 0; i < listst.size(); i++) {
            listf.add(listst.get(i));
        }
        request.setAttribute("liste_genre_algue", listf);
        return mapping.findForward(SUCCESS);

    }
}
