/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.satation_prelevement;

import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.bean.PlanEau;

import com.pasteur.ci.bean.Statprs;
import com.pasteur.ci.bean.Quartier;
import com.pasteur.ci.bean.Region;
import com.pasteur.ci.bean.TypePlanEau;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
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
public class GestionStatprAction extends org.apache.struts.action.Action {

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

        PlanEauDAOImplement pdaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
        HabitatDAOImplement hbDAO = new HabitatDAOImplement(DAOFactory.getInstance());

        StatPrelevement statpr = new StatPrelevement();
        StatPrelevementDAOImplement stdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());

        ArrayList<Statprs> listst = new ArrayList<Statprs>();

        ArrayList<Object> list = stdaoi.find();
        for (int i = 0; i < list.size(); i++) {

            StatPrelevement Stat_pr = (StatPrelevement) list.get(i);
            int _idstatpr = Stat_pr.getIdstat();
            String _idstat = Stat_pr.getIdstat_prelevement();
            int _idHab = Stat_pr.getIdhabitat();
            double _local = Stat_pr.getGps_lat();
            double __local = Stat_pr.getGps_long();
            int _pe = Stat_pr.getIdplan_eau();
            Boolean _visb = Stat_pr.isVisible();

            PlanEau plan_eau = new PlanEau();
            plan_eau.setIdplan_eau(_pe);
            plan_eau = (PlanEau) pdaoi.find(plan_eau);

            Habitat habitat = new Habitat();
            habitat.setIdhabitat(_idHab);
            habitat = (Habitat) hbDAO.find(habitat);

            Statprs stp = new Statprs();
            stp.setIdstat(_idstatpr);
            stp.setIdplan_eau(plan_eau.getDesignation());
            stp.setIdstat_prelevement(_idstat);
            stp.setIdhabitat(habitat.getDesign_habitat());
            stp.setGps_lat(_local);
            stp.setGps_long(__local);
            stp.setVisible(_visb);
            listst.add(stp);

        }

        ArrayList<Object> listf = new ArrayList<>();
        for (int i = 1; i < listst.size(); i++) {
            listf.add(listst.get(i));
        }

        request.setAttribute("liste_statpr", listf  );

        return mapping.findForward(SUCCESS);
    }
}
