/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.bean.GenreAlgue;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.famille.dao.FamilleDAOImplement;
import com.pasteur.ci.genre_algue.dao.GenreAlgueDAOImplement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author HP USER
 */
public class ajaxGenreAlgueAction extends org.apache.struts.action.Action {

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

        int idfamille = (Integer) PropertyUtils.getProperty(form, "idfamille");

        GenreAlgueDAOImplement gadaoi = new GenreAlgueDAOImplement(DAOFactory.getInstance());

        ArrayList<GenreAlgue> listgenre = (ArrayList<GenreAlgue>) (Object) gadaoi.find(idfamille);
 
        HashMap hm = new HashMap();
        for (GenreAlgue ga : listgenre) {
            String hu = "hu"+ga.getIdgenre_algue();
            hm.put( hu, ga.getDesign_genre_algue());
//            System.out.println(Integer.toString(ga.getIdgenre_algue())+" --"+ga.getDesign_genre_algue());
        }
        
          // chaque clé de notre map devient une clé dans l'objet JSON (utilisation de Json-lib)
        JSONObject json = JSONObject.fromObject(hm);

        // façon d'envoyer l'objet JSON pour que Prototype puisse le récupérer
        response.setHeader("X-JSON", json.toString());

        return null;
    }
}
