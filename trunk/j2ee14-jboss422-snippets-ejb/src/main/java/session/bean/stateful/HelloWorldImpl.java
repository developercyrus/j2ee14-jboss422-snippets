package session.bean.stateful;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloWorldImpl implements SessionBean {

    private static final long serialVersionUID = 2753636929857264357L;

    public void ejbActivate() throws EJBException {
        // TODO Auto-generated method stub        
    }

    public void ejbPassivate() throws EJBException {
        // TODO Auto-generated method stub
       
    }

    public void ejbRemove() throws EJBException {
        // TODO Auto-generated method stub       
    }

    public void setSessionContext(SessionContext arg0) throws EJBException {
        // TODO Auto-generated method stub        
    }
    
    public void ejbCreate() {
        System.out.println("Created Hello EJB.");
    }

    public String sayHello(String message) {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return message + " via session bean sayHello() Impl at " + hostname;
    }
}
