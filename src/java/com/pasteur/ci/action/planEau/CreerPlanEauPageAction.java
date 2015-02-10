/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.planEau;

import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.region.dao.RegionDAOImplement;
import com.pasteur.ci.type_plan_eau.dao.TypePlanEauDAOImplement;
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
public class CreerPlanEauPageAction extends org.apache.struts.action.Action {

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

        QuartierDAOImplement qdaoi = new QuartierDAOImplement(DAOFactory.getInstance());
        CommuneDAOImplement cdaoi = new CommuneDAOImplement(DAOFactory.getInstance());
        TypePlanEauDAOImplement tpedaoi = new TypePlanEauDAOImplement(DAOFactory.getInstance());
        RegionDAOImplement rdaoi = new RegionDAOImplement(DAOFactory.getInstance());

        PratiqueDAOImplement pratiqueDAO = new PratiqueDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> listQuart = qdaoi.find();
        ArrayList<Object> listReg = rdaoi.find();
        ArrayList<Object> listCom = cdaoi.find();
        ArrayList<Object> listTyPl = tpedaoi.find();
        ArrayList<Object> ListePratique = pratiqueDAO.find();

        request.setAttribute("com_trouve", listCom);
        request.setAttribute("typl_trouve", listTyPl);
        request.setAttribute("reg_trouve", listReg);
        request.setAttribute("quart_trouve", listQuart);
        request.setAttribute("pratique_trouve", ListePratique);

        return mapping.findForward(SUCCESS);
    }
}
