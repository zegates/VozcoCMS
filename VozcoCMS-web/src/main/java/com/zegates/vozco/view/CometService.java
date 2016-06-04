package com.zegates.vozco.view;

import com.zegates.vozco.beans.remote.CustomerBeanRemote;
import com.zegates.vozco.config.Configurations;
import com.zegates.vozco.controller.CustomerController;
import com.zegates.vozco.entities.Customer;
import com.zegates.vozco.factory.ControllerFactory;
import org.cometd.annotation.Configure;
import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ConfigurableServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.authorizer.GrantAuthorizer;
import org.cometd.server.filter.DataFilterMessageListener;
import org.cometd.server.filter.NoMarkupFilter;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by sandaruwan on 1/9/16.
 */
@Service("CMSService")
public class CometService {

    @Inject
    private BayeuxServer bayeux;

    @Session
    private ServerSession serverSession;

    private CustomerBeanRemote customerBean = null;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Configure({"/cms/**/**"})
    protected void configureCMSConfig(ConfigurableServerChannel channel) {
        DataFilterMessageListener noMarkup
                = new DataFilterMessageListener(bayeux, new NoMarkupFilter());
        channel.addListener(noMarkup);
        channel.addAuthorizer(GrantAuthorizer.GRANT_ALL);
    }

    @Listener("/cms/customer/create")
    public void createCustomer(ServerSession client, ServerMessage message) {
        Map<String, Object> map = new HashMap<String, Object>();
        ClientSessionChannel channel = serverSession.getLocalSession().getChannel("/cms/customer/create");
        try {
            int cid = (int) message.getDataAsMap().get("cid");
            String fname = (String) message.getDataAsMap().get("fname");
            String lname = (String) message.getDataAsMap().get("lname");
            String address = (String) message.getDataAsMap().get("address");
            String password = (String) message.getDataAsMap().get("password");
            Customer customer = new Customer();
            customer.setCid(cid);
            customer.setFname(fname);
            customer.setLname(lname);
            customer.setAddress(address);
            customer.setPassword(password);
            getCustomerBean().createCustomer(customer);
            map.put("DB_OPERATION", Configurations.DBOperations.CREATED);
        }catch (Exception ex){
            map.put("DB_OPERATION", Configurations.DBOperations.FAIL);
        }
        channel.publish(map);
    }

    @Listener("/cms/customer/update")
    public void updateCustomer(ServerSession client, ServerMessage message) {

        Map<String, Object> map = new HashMap<>();
        ClientSessionChannel channel = serverSession.getLocalSession().getChannel("/cms/customer/update");
        try {
            int cid = (int) message.getDataAsMap().get("cid");
            String fname = (String) message.getDataAsMap().get("fname");
            String lname = (String) message.getDataAsMap().get("lname");
            String address = (String) message.getDataAsMap().get("address");

            Customer customer = new Customer();
            customer.setCid(cid);
            customer.setFname(fname);
            customer.setLname(lname);
            customer.setAddress(address);

            getCustomerBean().updateCustomer(customer);
            map.put("DB_OPERATION", Configurations.DBOperations.UPDATED);
        }catch (Exception ex){
            map.put("DB_OPERATION", Configurations.DBOperations.FAIL);
        }
        channel.publish(map);
    }

    @Listener("/cms/authenticate")
    public void authenticate(ServerSession client, ServerMessage message) {
        String username = (String) message.getDataAsMap().get("username");
        String password = (String) message.getDataAsMap().get("password");
        Customer customer = new Customer();
        customer.setPassword(password);
        customer.setUsername(username);
        customer = getCustomerBean().authenticate(customer);

        ClientSessionChannel channel = serverSession.getLocalSession().getChannel("/cms/authenticate/status");
        Map<String, Object> map = new HashMap<>();

        try{
            if(customer != null){
                customer.setPassword("");
                String jsonCustomer = objectMapper.writeValueAsString(customer);
                map.put("customer", jsonCustomer);
                setAuthenticatedStatus(map, Configurations.AuthenticateStatus.SUCCESS);
            }else{
                setAuthenticatedStatus(map, Configurations.AuthenticateStatus.FAIL);
            }
        }catch (Exception e){
            setAuthenticatedStatus(map, Configurations.AuthenticateStatus.FAIL);
        }
        channel.publish(map);
    }

    @Listener("/cms/customer/find")
    public void findCustomer(ServerSession client, ServerMessage message) {
        String fname = (String) message.getDataAsMap().get("fname");
        String lname = (String) message.getDataAsMap().get("lname");
        Customer customer = new Customer();
        customer.setFname(fname);
        customer.setLname(lname);
        List<Customer> customers= getCustomerBean().findSearchedCustomers(customer);

        ClientSessionChannel channel = serverSession.getLocalSession().getChannel("/cms/customer/find/result");
        Map<String, Object> map = new HashMap<>();
        try{
            if(customers != null){
                String jsonCustomers = objectMapper.writeValueAsString(customers);
                map.put("customers", jsonCustomers);
                map.put("DB_OPERATION", Configurations.DBOperations.FOUND);
            }else {
                map.put("customers", "{}");
                map.put("DB_OPERATION", Configurations.DBOperations.FOUND);
            }
        }catch (Exception ex){
            map.put("DB_OPERATION", Configurations.DBOperations.FAIL);
        }
        channel.publish(map);
    }


    @Listener("/cms/customers")
    public void customers(ServerSession client, ServerMessage message) {

        List<Customer> customers = getCustomerBean().findCustomers();

        ClientSessionChannel channel = serverSession.getLocalSession().getChannel("/cms/authenticate/status");
        Map<String, Object> map = new HashMap<>();

        try{
            if(customers != null){

                String jsonCustomer = objectMapper.writeValueAsString(customers);
                map.put("customer", jsonCustomer);
                setAuthenticatedStatus(map, Configurations.AuthenticateStatus.SUCCESS);
            }else{
                setAuthenticatedStatus(map, Configurations.AuthenticateStatus.FAIL);
            }
        }catch (Exception e){
            setAuthenticatedStatus(map, Configurations.AuthenticateStatus.FAIL);
        }
        channel.publish(map);
    }

    public void setAuthenticatedStatus(Map<String, Object> map, Configurations.AuthenticateStatus authStatus){
        map.put("AUTH_OPERATION", authStatus);
    }

    private CustomerBeanRemote getCustomerBean(){
        if(customerBean == null){
            customerBean = (CustomerBeanRemote) bayeux.getContext().getContextAttribute("CustomerBean");
        }
        return customerBean;
    }
}