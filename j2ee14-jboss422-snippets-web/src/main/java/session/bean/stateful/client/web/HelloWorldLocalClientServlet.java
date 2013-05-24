package session.bean.stateful.client.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.bean.stateful.HelloWorldLocalHome;
import session.bean.stateful.HelloWorldLocalObject;

public class HelloWorldLocalClientServlet extends HttpServlet  {
    private static final long serialVersionUID = 1258543514208840608L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            Context ctx = new InitialContext();
            Object ref = ctx.lookup("HelloWorldStatefulLocal");
            HelloWorldLocalHome h = (HelloWorldLocalHome)PortableRemoteObject.narrow(ref, HelloWorldLocalHome.class);
            HelloWorldLocalObject o = h.create();
            
            String hostname = InetAddress.getLocalHost().getHostName();    
            String result = o.sayHello("Hello World by local client servlet at " + hostname);
            
            writer.println("<html>");
            writer.println("<body>");
            writer.println(result);
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }               
}