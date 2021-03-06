package com.sample.servlet;
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sample.auth.*;
/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns = { "/MobileServlet" , "/MobileServlet.do"})
public class MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public MobileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get request not supporteds
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	try {
    		System.out.println(request.getParameterMap());
        	String moduleName = (String) request.getParameter("moduleName");
        	if (moduleName.equalsIgnoreCase("authenticateUser")){
        		AuthenticateUser authObject = new AuthenticateUser();
        		try {
    				authObject.getAuthenticated(request, response);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}else if(moduleName.equalsIgnoreCase("createUser")){
        		RegisterUser ru = new RegisterUser();
        		try {
    				ru.createUser(request, response);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}else if(moduleName.equalsIgnoreCase("playGame")){
        		
        	}else{
        	System.out.println("user name is: "+request.getParameter("username")+ "password is" +request.getParameter("password") + "over");
        	response.setContentType("application/json");
        	PrintWriter out = response.getWriter();
        	out.print("{\"statusCode\":\"1112\",\"statusMessage\":\"Invalid module name or empty module name\"}");
        	out.flush();
        	}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
    }
}