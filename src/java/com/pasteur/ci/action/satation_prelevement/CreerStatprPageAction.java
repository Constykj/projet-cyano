/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.satation_prelevement;

import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
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
public class CreerStatprPageAction extends org.apache.struts.action.Action {

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
        HabitatDAOImplement HabDaO = new HabitatDAOImplement(DAOFactory.getInstance());
        ArrayList <Object> ListHab =HabDaO.find();
        PlanEauDAOImplement pdaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
       ArrayList<Object> listst = pdaoi.find();

         
        request.setAttribute("stat_trouve", listst);
        request.setAttribute("hab_trouve", ListHab);
        return mapping.findForward(SUCCESS);
    }
}
