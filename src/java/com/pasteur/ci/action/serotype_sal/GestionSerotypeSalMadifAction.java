/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action.serotype_sal;

import com.pasteur.ci.bean.SerotypeSal;
import com.pasteur.ci.bean.SerotypeVb;
import com.pasteur.ci.config.DAOFactory;
import com.pasteur.ci.serotype_sal.dao.SerotypeSalDAOImplement;
import com.pasteur.ci.serotype_vb.dao.SerotypeVbDAOImplement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author abouchou
 */
public class GestionSerotypeSalMadifAction extends org.apache.struts.action.Action {

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
         int idserotype_sal= (Integer) PropertyUtils.getProperty(form, "idserotype_sal");

        SerotypeSal serotype_sal = new SerotypeSal();
        serotype_sal.setIdserotype_sal(idserotype_sal);


         SerotypeSalDAOImplement rdaoi = new SerotypeSalDAOImplement(DAOFactory.getInstance());
        serotype_sal = (SerotypeSal) rdaoi.find(serotype_sal);

        request.setAttribute("seroSal", serotype_sal);
        return mapping.findForward(SUCCESS);
    }
}
