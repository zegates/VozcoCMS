package com.zegates.vozco.view;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.server.BayeuxServerImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Created by sandaruwan on 1/9/16.
 */
public class BayeuxServerProducer {
    @Produces
    @ApplicationScoped
    public BayeuxServer produceServer() {
        return new BayeuxServerImpl();
    }
}
