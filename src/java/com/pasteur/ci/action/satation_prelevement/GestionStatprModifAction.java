/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.satation_prelevement;

import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
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
public class GestionStatprModifAction extends org.apache.struts.action.Action {

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

        String statprId = (String) PropertyUtils.getProperty(form, "idstat");

        StatPrelevement statpr = new StatPrelevement();
        statpr.setIdstat(Integer.parseInt(statprId));
        StatPrelevementDAOImplement stdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());
        statpr = (StatPrelevement) stdaoi.find(statpr);

//        double _local = statpr.getGps_lat();
//        double __local = statpr.getGps_long();
//        String _idstat = statpr.getIdstat_prelevement();
//        int _idstatpr = statpr.getIdstat();
        int _plan_eau = statpr.getIdplan_eau();
        int _habitat = statpr.getIdhabitat();
//        Boolean _visb = statpr.isVisible();

        PlanEauDAOImplement pdaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
        PlanEau plan_eau = new PlanEau();
        plan_eau.setIdplan_eau(_plan_eau);
        plan_eau = (PlanEau) pdaoi.find(plan_eau);

        HabitatDAOImplement HabDAO = new HabitatDAOImplement(DAOFactory.getInstance());
        Habitat habitat = new Habitat();
        habitat.setIdhabitat(_habitat);
        habitat=(Habitat) HabDAO.find(habitat);

        ArrayList<Object> listPlEau = pdaoi.find();
        ArrayList<Object> ListHab = HabDAO.find();

        request.setAttribute("statpr_trouve", statpr);
        request.setAttribute("planEau_trouve", listPlEau);
        request.setAttribute("hab_trouve", ListHab);

        return mapping.findForward(SUCCESS);
    }
}
