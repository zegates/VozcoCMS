package com.zegates.vozco.view;

import org.cometd.annotation.Configure;
import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ConfigurableServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.authorizer.GrantAuthorizer;
import org.cometd.server.filter.DataFilterMessageListener;
import org.cometd.server.filter.NoMarkupFilter;

import javax.inject.Inject;

/**
 * Created by sandaruwan on 1/9/16.
 */
@Service("test")
public class CometService {

    @Inject
    private BayeuxServer _bayeux;

    @Session
    private ServerSession serverSession;

    @Configure({"/test/**"})
    protected void configureChatStarStar(ConfigurableServerChannel channel) {
        DataFilterMessageListener noMarkup
                = new DataFilterMessageListener(_bayeux, new NoMarkupFilter());
        channel.addListener(noMarkup);
        channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
    }

    @Listener( "/service/test ")
    public void handleTest(ServerSession client, ServerMessage message) {
        System.out.println("test");
//        AbstractWebSocketTransport
    }


}