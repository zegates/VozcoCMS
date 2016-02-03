package com.zegates.vozco.view;

import com.zegates.vozco.beans.CustomerBean;
import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.BayeuxServerImpl;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServlet;

/**
 * Created by sandaruwan on 1/21/16.
 */
public class EJBBeanProducer extends HttpServlet {

    @EJB
    private  CustomerBeanRemote customerBean;


//
//
//    @Produces
//    @ApplicationScoped @Default
    public CustomerBeanRemote getCustomerBeanRemote() {
        return customerBean;
    }


}
