/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.planEau;

import com.pasteur.ci.bean.Commune;
import com.pasteur.ci.bean.LignePratique;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.bean.Quartier;
import com.pasteur.ci.bean.Region;
import com.pasteur.ci.bean.TypePlanEau;
import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.ligne_pratique.dao.LignePratiqueDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
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
public class CreerPlanEauAction extends org.apache.struts.action.Action {

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

        int idplan_eau = (Integer) PropertyUtils.getProperty(form, "idplan_eau");
        int idregion = (Integer) PropertyUtils.getProperty(form, "idregion");
        int idtype_plan_eau = (Integer) PropertyUtils.getProperty(form, "idtype_plan_eau");
        int idquartier = (Integer) PropertyUtils.getProperty(form, "idquartier");
        int idcommune = (Integer) PropertyUtils.getProperty(form, "idcommune");
        Boolean matiere_fecale = (Boolean) PropertyUtils.getProperty(form, "matiere_fecale");
        Double superficie = (Double) PropertyUtils.getProperty(form, "superficie");
        String commentaire = (String) PropertyUtils.getProperty(form, "commentaire");
        String designation = (String) PropertyUtils.getProperty(form, "designation");
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        int[] idpratique = (int[]) PropertyUtils.getProperty(form, "idpratiquer");

        PlanEau plan_eau = new PlanEau();
        plan_eau.setIdplan_eau(idplan_eau);
        plan_eau.setDesignation(designation);
        plan_eau.setSuperficie(superficie);
        plan_eau.setIdregion(idregion);
        plan_eau.setMatiere_fecale(matiere_fecale);
        plan_eau.setIdquartier(idquartier);
        plan_eau.setIdcommune(idcommune);
        plan_eau.setIdtype_plan_eau(idtype_plan_eau);
        plan_eau.setCommentaire(commentaire);

        plan_eau.setVisible(visible);

        PlanEauDAOImplement plan_eauDAO = new PlanEauDAOImplement(DAOFactory.getInstance());
        plan_eau = (PlanEau) plan_eauDAO.create(plan_eau);

        LignePratique lignePratique = new LignePratique();
        lignePratique.setIdplan_eau(plan_eau.getIdplan_eau());
        LignePratiqueDAOImplement lignePratiqueDAO = new LignePratiqueDAOImplement(DAOFactory.getInstance());
        
        
        
        for (int i = 0; i < idpratique.length; i++) {
            lignePratique.setIdpratique(idpratique[i]);
            lignePratiqueDAO.create(lignePratique);
        }
        
        
        
        return mapping.findForward(SUCCESS);
    }
}
