
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasteur.ci.config;

import java.awt.Event;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author HP USER
 */
public class InitialisationDaoFactory implements ServletContextListener {
 
    private static final String ATT_DAO_FACTORY = "daofactory";
    private DAOFactory daoFactory;
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void contextInitialized(ServletContextEvent sce) {
           ServletContext servletContext = sce.getServletContext();
           this.daoFactory = DAOFactory.getInstance();
           servletContext.setAttribute(ATT_DAO_FACTORY, this.daoFactory);
           System.out.println("initialisation reussie");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
          
    }
}
