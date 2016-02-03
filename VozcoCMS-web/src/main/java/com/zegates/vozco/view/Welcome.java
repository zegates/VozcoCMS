package com.zegates.vozco.view;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sandaruwan on 1/9/16.
 */
@WebServlet(name = "Welcome", urlPatterns = "/Welcome")
public class Welcome extends HttpServlet {

    @EJB//(beanName = "CustomerBeanEJB")
    private CustomerBeanRemote customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test at " + request.getContextPath() + " "+customerBean.createCustomer(null)+ "</h1>");
            out.println("</body>");
            out.println("</html>");
//            org.cometd.annotation.AnnotationCometDServlet

        }
    }
}
