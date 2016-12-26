package com.zegates.vozco.view;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import com.zegates.vozco.beans.remote.CustomerOrderBeanRemote;
import com.zegates.vozco.beans.remote.FoodCategoryBeanRemote;
import com.zegates.vozco.beans.remote.FoodItemBeanRemote;
import com.zegates.vozco.entities.CustomerOrder;
import org.cometd.annotation.AnnotationCometDServlet;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.BayeuxServerImpl;
import org.cometd.websocket.server.WebSocketTransport;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sandaruwan on 1/21/16.
 */
@WebServlet(name = "CometDServlet")
public class CometDServlet extends AnnotationCometDServlet {

    @EJB//(beanName = "CustomerBeanEJB")
    private CustomerBeanRemote customerBean;
    @EJB
    private FoodItemBeanRemote foodItemBean;
    @EJB
    private FoodCategoryBeanRemote foodCategoryBean;
    @EJB
    private CustomerOrderBeanRemote customerOrderBean;

    private BayeuxServer bayeux;

    @Override
    public void init() throws ServletException {
        super.init();
        bayeux = (BayeuxServerImpl) getServletContext().getAttribute(BayeuxServer.ATTRIBUTE);
        bayeux.getContext();
        this.getServletContext().setAttribute("CustomerBean", customerBean);
        this.getServletContext().setAttribute("FoodItemBean", foodItemBean);
        this.getServletContext().setAttribute("FoodCategoryBean", foodCategoryBean);
        this.getServletContext().setAttribute("CustomerOrderBean", customerOrderBean);
    }
}
