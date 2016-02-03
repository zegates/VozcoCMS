package com.zegates.vozco.factory;

/**
 * Created by sandaruwan on 1/12/16.
 */

import com.zegates.vozco.entities.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Properties;

public class HibernateFactory {
//
//    private static final SessionFactory ourSessionFactory;
//    private static final ServiceRegistry serviceRegistry;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(Customer.class);
//            configuration.configure();
//
//
//
////            Properties pURL = new Properties();
////            Properties pDriver = new Properties();
////            Properties pUname = new Properties();
////            Properties pPw = new Properties();
////
////            pURL.setProperty("connection.url","jdbc:mysql://localhost/vozco_cms");
////            pDriver.setProperty("connection.driver_class","com.mysql.jdbc.Driver");
////            pUname.setProperty("connection.username","root");
////            pPw.setProperty("connection.password","25289");
//
//
//            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
////            ourSessionFactory = new AnnotationConfiguration()
////                    .addProperties(pURL)
////                    .addProperties(pDriver)
////                    .addProperties(pUname)
////                    .addProperties(pPw)
////                    .addAnnotatedClass(Customer.class)
////                    .configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }


}
