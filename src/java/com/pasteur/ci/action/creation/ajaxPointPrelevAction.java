/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.bean.Commune;
import com.pasteur.ci.bean.Habitat;
import com.pasteur.ci.bean.LigneHabitat;
import com.pasteur.ci.bean.LignePratique;
import com.pasteur.ci.bean.MateriauxConstruction;
import com.pasteur.ci.bean.PlanEau;
import com.pasteur.ci.bean.PointPrelevement;
import com.pasteur.ci.bean.Pratique;
import com.pasteur.ci.bean.Quartier;
import com.pasteur.ci.bean.Region;
import com.pasteur.ci.bean.StatPrelevement;
import com.pasteur.ci.bean.TypePlanEau;
import com.pasteur.ci.commune.dao.CommuneDAOImplement;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.habitat.dao.HabitatDAOImplement;
import com.pasteur.ci.ligne_habitat.dao.LigneHabitatDAOImplement;
import com.pasteur.ci.ligne_pratique.dao.LignePratiqueDAOImplement;
import com.pasteur.ci.materiaux_construction.dao.MateriauxConstructionDAOImplement;
import com.pasteur.ci.plan_eau.dao.PlanEauDAOImplement;
import com.pasteur.ci.point_prelevement.dao.PointPrelevementDAOImplement;
import com.pasteur.ci.pratique.dao.PratiqueDAOImplement;
import com.pasteur.ci.quartier.dao.QuartierDAOImplement;
import com.pasteur.ci.region.dao.RegionDAOImplement;
import com.pasteur.ci.stat_prelevement.dao.StatPrelevementDAOImplement;
import com.pasteur.ci.type_plan_eau.dao.TypePlanEauDAOImplement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.json.JSONObject;

/**
 *
 * @author HP USER
 */
public class ajaxPointPrelevAction extends org.apache.struts.action.Action {

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

        int idpoint_prelevement = (Integer) PropertyUtils.getProperty(form, "idpoint_prelevement");

        PointPrelevement pointPrelevement = new PointPrelevement();
        PointPrelevementDAOImplement ppdaoi = new PointPrelevementDAOImplement(DAOFactory.getInstance());
        pointPrelevement.setIdpoint_prelevement(idpoint_prelevement);
        pointPrelevement = (PointPrelevement) ppdaoi.find(pointPrelevement);

        //profondeur
        int idStationPrel = pointPrelevement.getIdstat();

        StatPrelevement stationPrelevement = new StatPrelevement();
        StatPrelevementDAOImplement spdaoi = new StatPrelevementDAOImplement(DAOFactory.getInstance());
        stationPrelevement.setIdstat(idStationPrel);
        stationPrelevement = (StatPrelevement) spdaoi.find(stationPrelevement);

        //designation station prelevement
        //longitude
        // latitude
        int idplan_eau = stationPrelevement.getIdplan_eau();

        int idhabitat = stationPrelevement.getIdhabitat();
         
        PlanEau planEau = new PlanEau();
        PlanEauDAOImplement pedaoi = new PlanEauDAOImplement(DAOFactory.getInstance());
        planEau.setIdplan_eau(idplan_eau);
        planEau = (PlanEau) pedaoi.find(planEau);

        int idregion = planEau.getIdregion();
        int idquartier = planEau.getIdquartier();
        int idcommune = planEau.getIdcommune();
        int idtype_plan_eau = planEau.getIdtype_plan_eau();

        //superficie
        //commentaire
        //matiere fecale
        //designation Plan eau
        Region region = new Region();
        RegionDAOImplement rdaoi = new RegionDAOImplement(DAOFactory.getInstance());
        region.setIdregion(idregion);
        region = (Region) rdaoi.find(region);

        //region
        Quartier quartier = new Quartier();
        QuartierDAOImplement qdaoi = new QuartierDAOImplement(DAOFactory.getInstance());
        quartier.setIdquartier(idquartier);
        quartier = (Quartier) qdaoi.find(quartier);

        //quatier
        Commune commune = new Commune();
        CommuneDAOImplement cdaoi = new CommuneDAOImplement(DAOFactory.getInstance());
        commune.setIdcommune(idcommune);
        commune = (Commune) cdaoi.find(commune);

        // commune
        TypePlanEau typePlanEau = new TypePlanEau();
        TypePlanEauDAOImplement tpedaoi = new TypePlanEauDAOImplement(DAOFactory.getInstance());
        typePlanEau.setIdtype_plan_eau(idtype_plan_eau);
        typePlanEau = (TypePlanEau) tpedaoi.find(typePlanEau);

        Habitat habitat = new Habitat();
        HabitatDAOImplement hdaoi = new HabitatDAOImplement(DAOFactory.getInstance());
        habitat.setIdhabitat(idhabitat);
        habitat = (Habitat) hdaoi.find(habitat);

        LigneHabitatDAOImplement lhdaoi = new LigneHabitatDAOImplement(DAOFactory.getInstance());
        MateriauxConstructionDAOImplement mcdaoi = new MateriauxConstructionDAOImplement(DAOFactory.getInstance());

        LigneHabitat ligneHabitat = new LigneHabitat();
        ligneHabitat.setIdhabitat(idhabitat);
        
        ArrayList<Object> ligne_mat_const_hab = lhdaoi.findS(ligneHabitat);
        ArrayList mat_const = new ArrayList();

        for (Object lmch : ligne_mat_const_hab) {
            LigneHabitat _lmch = (LigneHabitat) lmch;
            MateriauxConstruction mc = new MateriauxConstruction();
            mc.setIdmateriaux_construction(_lmch.getIdmateriaux_construction());
            mc = (MateriauxConstruction) mcdaoi.find(mc);         
            mat_const.add(mc);

        }
 
        LignePratiqueDAOImplement ligne_pratiqueDAO = new LignePratiqueDAOImplement(DAOFactory.getInstance());
        PratiqueDAOImplement pratiqueDAO = new PratiqueDAOImplement(DAOFactory.getInstance());

        LignePratique lignePratique = new LignePratique();
        lignePratique.setIdplan_eau(idplan_eau);
        ArrayList<Object> ligne_pratique = ligne_pratiqueDAO.findS(lignePratique);
        ArrayList pratiquer = new ArrayList();

        for (Object lmch : ligne_pratique) {
            LignePratique _lmch = (LignePratique) lmch;
            Pratique pt = new Pratique();
            pt.setIdpratique(_lmch.getIdpratique());
            pt = (Pratique) pratiqueDAO.find(pt);
            pratiquer.add(pt);

        }

        String type_pe = typePlanEau.getDesignation();
        Double profondeur = pointPrelevement.getProfondeur();
        String design_stprelev = stationPrelevement.getIdstat_prelevement();
        Double gps_long = stationPrelevement.getGps_long();
        Double gps_lat = stationPrelevement.getGps_lat();
        double superficie = planEau.getSuperficie();
        String commentaire = planEau.getCommentaire();
        boolean matiere_fecale = planEau.getMatiere_fecale();
        String designation = planEau.getDesignation();
        String quatier_ = quartier.getDesignation();
        String region_ = region.getDesignation();
        String commune_ = commune.getDesignation();
        String habitat_designation = habitat.getDesign_habitat();
        int effectif = habitat.getEffectif();
        Double distance = habitat.getDist_bord_lagune();
        String mat_construction = ArrayToStringMC(mat_const);
        String pratique = ArrayToStringP(pratiquer); //

        HashMap hm = new HashMap();
        hm.put("profondeur", profondeur);
        hm.put("design_stprelev", design_stprelev);
        hm.put("gps_long", gps_long);
        hm.put("gps_lat", gps_lat);
        hm.put("superficie", superficie);
        hm.put("commentaire", commentaire);
        hm.put("matiere_fecale", matiere_fecale);
        hm.put("designation", designation);
        hm.put("quartier_", quatier_);
        hm.put("region_", region_);
        hm.put("commune_", commune_);
        hm.put("habitat_designation", habitat_designation);
        hm.put("effectif", effectif);
        hm.put("distance", distance);
        hm.put("mat_construction", mat_construction);
        hm.put("pratique", pratique);
        hm.put("type_pe", type_pe);

        // chaque clé de notre map devient une clé dans l'objet JSON (utilisation de Json-lib)
        JSONObject json = JSONObject.fromObject(hm);

        // façon d'envoyer l'objet JSON pour que Prototype puisse le récupérer
        response.setHeader("X-JSON", json.toString());

        return null;

    }

    public String ArrayToStringMC(ArrayList list) {

        String vf = "";

        for (Object list1 : list) {
            MateriauxConstruction mc = null;
            mc = (MateriauxConstruction) list1;
            vf += mc.getLib_materiaux_construction() + ";";
        }

        int sz = vf.length();
        if (sz != 0) {
            vf = vf.substring(0, sz - 1);
            vf = vf.replace(";", "; ");
        }

        return vf;
    }

    public String ArrayToStringP(ArrayList list) {

        String vf = "";

        for (Object list1 : list) {
            Pratique mc = null;
            mc = (Pratique) list1;
            vf += mc.getPratique() + ";";
        }

        int sz = vf.length();
        if (sz != 0) {
            vf = vf.substring(0, sz - 1);
            vf = vf.replace(";", "; ");
        }

        return vf;
    }
}
