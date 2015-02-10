/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.planEau;

import com.pasteur.ci.bean.Commune;
import com.pasteur.ci.bean.LignePratique;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.bean.PlanEauS;
import com.pasteur.ci.bean.Pratique;
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
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class GestionPlanEauAction extends org.apache.struts.action.Action {

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

        //HabitatDAOImplement hdaoi = new HabitatDAOImplement(DAOFactory.getInstance());
        PlanEauDAOImplement plan_eauDAO = new PlanEauDAOImplement(DAOFactory.getInstance());

        CommuneDAOImplement communeDAO = new CommuneDAOImplement(DAOFactory.getInstance());
        RegionDAOImplement regionDAO = new RegionDAOImplement(DAOFactory.getInstance());
        TypePlanEauDAOImplement type_planDAO = new TypePlanEauDAOImplement(DAOFactory.getInstance());
        QuartierDAOImplement quartierDAO = new QuartierDAOImplement(DAOFactory.getInstance());

        LignePratiqueDAOImplement ligne_pratiqueDAO = new LignePratiqueDAOImplement(DAOFactory.getInstance());
        PratiqueDAOImplement pratiqueDAO = new PratiqueDAOImplement(DAOFactory.getInstance());

        ArrayList list_final = new ArrayList();

        ArrayList<Object> Liste_plan_eau = plan_eauDAO.find();

        for (int i=1; i<Liste_plan_eau.size(); i++) {
            
            PlanEau plan_eau = (PlanEau) Liste_plan_eau.get(i);

            int _idplan_eau = plan_eau.getIdplan_eau();
            String _design = plan_eau.getDesignation();
            int _idcommune = plan_eau.getIdcommune();
            int _idquartier = plan_eau.getIdquartier();
            int _idtype_eau = plan_eau.getIdtype_plan_eau();
            int _idregion = plan_eau.getIdregion();
            double _superficie = plan_eau.getSuperficie();
            boolean _matiere_fecale = plan_eau.getMatiere_fecale();
            String _commentaire = plan_eau.getCommentaire();
            boolean _visible = plan_eau.isVisible();

            //
            Commune commune = new Commune();
            commune.setIdcommune(_idcommune);
            commune = (Commune) communeDAO.find(commune);

            Quartier quartier = new Quartier();
            quartier.setIdquartier(_idquartier);
            quartier = (Quartier) quartierDAO.find(quartier);

            TypePlanEau type_plan_eau = new TypePlanEau();
            type_plan_eau.setIdtype_plan_eau(_idtype_eau);
            type_plan_eau = (TypePlanEau) type_planDAO.find(type_plan_eau);

            Region region = new Region();
            region.setIdregion(_idregion);
            region = (Region) regionDAO.find(region);
            //

            LignePratique lignePratique = new LignePratique();
            lignePratique.setIdplan_eau(_idplan_eau);
            ArrayList<Object> ligne_pratique = ligne_pratiqueDAO.findS(lignePratique);
            ArrayList pratiquer = new ArrayList();

            for (Object lmch : ligne_pratique) {
                LignePratique _lmch = (LignePratique) lmch;
                Pratique pt = new Pratique();
                pt.setIdpratique(_lmch.getIdpratique());
                pt = (Pratique) pratiqueDAO.find(pt);
                pratiquer.add(pt);
               
            }

            //
            PlanEauS plan_eaux = new PlanEauS();
            plan_eaux.setIdplan_eau(_idplan_eau);
            plan_eaux.setDesignation(_design);
            plan_eaux.setSuperficie(_superficie);
            plan_eaux.setMatiere_fecale(_matiere_fecale);
            plan_eaux.setCommentaire(_commentaire);
            plan_eaux.setCommune(commune.getDesignation());
            plan_eaux.setQuartier(quartier.getDesignation());
            plan_eaux.setRegion(region.getDesignation());
            plan_eaux.setType_plan_eau(type_plan_eau.getDesignation());

            plan_eaux.setVisible(_visible);
            plan_eaux.setPratiquer(ArrayToString(pratiquer));

            list_final.add(plan_eaux);
        }
        request.setAttribute("liste_plan_eau", list_final);

        return mapping.findForward(SUCCESS);

    }

    public String ArrayToString(ArrayList list) {

        String vf = "";

        for (Object list1 : list) {
            Pratique pr = null;
            pr = (Pratique) list1;
            vf += pr.getPratique()+ ";";
        }

        int sz = vf.length();
        if (sz != 0) {
            vf = vf.substring(0, sz - 1);
            vf = vf.replace(";", "; ");
        }

        return vf;
    }
}
