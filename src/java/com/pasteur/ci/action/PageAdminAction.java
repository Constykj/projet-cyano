/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author HP USER
 */
public class PageAdminAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        HttpSession session = request.getSession();
//        String droit = (String) session.getAttribute("droitUtil");
//
//        ActionMessages errors = new ActionMessages();
        HttpSession session = request.getSession();
        if (session == null || session.isNew()) {
            return mapping.findForward(FAILED);
        } else {
            return mapping.findForward(SUCCESS);
        }
//
//        if (droit.equals("2")) {
//            return mapping.findForward(SUCCESS);
//        } else {
//            errors.add("errright", new ActionMessage("error.right.false"));
//            saveErrors(request, errors);
        
//        }
//
    }
}
