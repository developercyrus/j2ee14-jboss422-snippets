import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet  {
  
    private static final long serialVersionUID = 1201967049274536154L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head><title>Hello World Servlet</title></head>");
        writer.println("<body>Hello World! How are you doing?</body>");
        writer.println("</html>");
        writer.close();
    }               
}