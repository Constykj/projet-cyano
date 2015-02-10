/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.region;

import com.pasteur.ci.bean.Region;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.region.dao.RegionDAOImplement;
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
public class EnregistreModifRegionAction extends org.apache.struts.action.Action {

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
        
         String idregion =  (String) PropertyUtils.getProperty(form, "idregion");       
        String designation = (String) PropertyUtils.getProperty(form, "designation");       
        boolean visible = (Boolean) PropertyUtils.getProperty(form, "visible");
        
        Region region = new Region();
        
        region.setIdregion(Integer.valueOf(idregion));
        region.setDesignation(designation);
        region.setVisible(visible);
        

        RegionDAOImplement rdaoi = new RegionDAOImplement(DAOFactory.getInstance());
        rdaoi.update(region);
        
        return mapping.findForward(SUCCESS);
        
    }
}
