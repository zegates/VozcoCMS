package com.zegates.vozco.factory;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by sandaruwan on 1/13/16.
 */
public class EMFactory {

    private static EntityManagerFactory emf;

    static {
        emf = new Persistence().createEntityManagerFactory("vozcopersist");

    }

    public static EntityManagerFactory getEmf(){
        return emf;
    }


}
