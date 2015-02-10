/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.commune;

import com.pasteur.ci.bean.Commune;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.commune.dao.CommuneDAOImplement;
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
public class EnregistreModifCommuneAction extends org.apache.struts.action.Action {

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
        
        String idcommune =  (String) PropertyUtils.getProperty(form, "idcommune");       
        String designation = (String) PropertyUtils.getProperty(form, "designation");       
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        
        Commune commune = new Commune();
        
        commune.setIdcommune(Integer.valueOf(idcommune));
        commune.setDesignation(designation);
        commune.setVisible(visible);
        

        CommuneDAOImplement cdaoi = new CommuneDAOImplement(DAOFactory.getInstance());
        cdaoi.update(commune);
        
        return mapping.findForward(SUCCESS);
    }
}
