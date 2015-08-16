package com.sample.auth;

import java.io.IOException;
import com.sample.database.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Anything related to Auth should go here **/

public class AuthenticateUser {
	public void getAuthenticated(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("application/json");
    	PrintWriter out = response.getWriter();
		if (null != userName && null != password){
			out.print("{\"statusCode\":\"1111\",\"statusMessage\":\"Successfully Logged in\"}");
	    	out.flush();
		}else{
			out.print("{\"statusCode\":\"0000\",\"statusMessage\":\"please enter valid credentails\"}");
	    	out.flush();
		}
	}
}
