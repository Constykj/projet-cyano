/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.planEau;

import com.pasteur.ci.bean.Commune;
import com.pasteur.ci.bean.LignePratique;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.bean.PlanEauS;
import com.pasteur.ci.bean.Quartier;
import com.pasteur.ci.bean.Region;
import com.pasteur.ci.bean.TypePlanEau;
import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.ligne_pratique.dao.LignePratiqueDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.region.dao.RegionDAOImplement;
import com.pasteur.ci.type_plan_eau.dao.TypePlanEauDAOImplement;
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
public class GestionPlanEauModifAction extends org.apache.struts.action.Action {

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

        String planEauID = (String) PropertyUtils.getProperty(form, "idplan_eau");
        PlanEau plan_eau = new PlanEau();
        PlanEauS plan_eaux = new PlanEauS();
        plan_eau.setIdplan_eau(Integer.parseInt(planEauID));

        PlanEauDAOImplement plan_eauDAO = new PlanEauDAOImplement(DAOFactory.getInstance());
        plan_eau = (PlanEau) plan_eauDAO.find(plan_eau);

        plan_eaux.setIdplan_eau(Integer.parseInt(planEauID));
        plan_eaux.setDesignation(plan_eau.getDesignation());
        plan_eaux.setSuperficie(plan_eau.getSuperficie());
        plan_eaux.setMatiere_fecale(plan_eau.getMatiere_fecale());
        plan_eaux.setCommentaire(plan_eaux.getCommentaire());
        plan_eaux.setIdcommune(plan_eau.getIdcommune());
        plan_eaux.setIdquartier(plan_eau.getIdquartier());
        plan_eaux.setIdregion(plan_eau.getIdregion());
        plan_eaux.setIdtype_plan_eau(plan_eau.getIdtype_plan_eau());
        plan_eaux.setVisible(plan_eau.isVisible());

        CommuneDAOImplement communeDAO = new CommuneDAOImplement(DAOFactory.getInstance());
        QuartierDAOImplement quartierDAO = new QuartierDAOImplement(DAOFactory.getInstance());
        RegionDAOImplement regionDAO = new RegionDAOImplement(DAOFactory.getInstance());
        TypePlanEauDAOImplement typePlanEauDAOI = new TypePlanEauDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> ListCommune = communeDAO.find();
        ArrayList<Object> ListQuartier = quartierDAO.find();
        ArrayList<Object> ListTypePlanEAu = typePlanEauDAOI.find();
        ArrayList<Object> ListRegion= regionDAO.find();
        
        
        
        LignePratiqueDAOImplement lignePratiqueDAO = new LignePratiqueDAOImplement(DAOFactory.getInstance());
        LignePratique lignePratique = new LignePratique();
        lignePratique.setIdplan_eau(Integer.parseInt(planEauID));

        ArrayList<Object> ligne_pratiquer = lignePratiqueDAO.findS(lignePratique);

        int[] ptq = new int[ligne_pratiquer.size()];

        for (int i = 0; i < ligne_pratiquer.size(); i++) {
            LignePratique lp;
            lp = (LignePratique) ligne_pratiquer.get(i);
            ptq[i] = lp.getIdpratique();
        }

        plan_eaux.setIdpratique(ptq);
        plan_eaux.setPratiques(ligne_pratiquer);

        PratiqueDAOImplement pratiqueDAO = new PratiqueDAOImplement(DAOFactory.getInstance());

        ArrayList<Object> listPratique = pratiqueDAO.find();

        request.setAttribute("pratique_trouve", listPratique);
        
        request.setAttribute("planeau_trouve", plan_eaux);
        
        
        request.setAttribute("commune_trouve", ListCommune);
        request.setAttribute("quartier_trouve", ListQuartier);
        request.setAttribute("region_trouve", ListRegion);
        request.setAttribute("type_plan_eau_trouve", ListTypePlanEAu);

        return mapping.findForward(SUCCESS);
    }
}
