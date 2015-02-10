/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.creation;

import com.pasteur.ci.bean.Echantillon;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.echantillon.dao.EchantillonDAOImplement;
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
public class ajaxNumEchantAction extends org.apache.struts.action.Action {

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
        String numero = (String) PropertyUtils.getProperty(form, "num_echan");
        System.out.println("numero" + numero);

        Echantillon echantillon = new Echantillon();
        echantillon.setNum_echantillon(numero.trim());
        EchantillonDAOImplement echantillonDAOImplement = new EchantillonDAOImplement(DAOFactory.getInstance());

        echantillon = (Echantillon) echantillonDAOImplement.findS(echantillon);

        String num_echantillon = "";
        if (echantillon.getNum_echantillon() != null) {
            num_echantillon = echantillon.getNum_echantillon();
        }

        HashMap hm = new HashMap();
        hm.put("num_echantillon", num_echantillon);
        JSONObject jsono = JSONObject.fromObject(hm);
        response.setHeader("X-JSON", jsono.toString());

        return null;
    }
}
