package com.sample.auth;

import java.io.IOException;
import com.sample.database.*;
import com.sample.models.StatusModel;
import com.sample.models.UserModel;

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
			DatabaseConnection db = DatabaseConnection.getInstance();
			UserModel um = new UserModel();
			um.setUserName(userName);
			um.setPassword(password);
			StatusModel sm = db.authenticateUser(um);
			out.print("{\"statusCode\":"+sm.getStatusCode()+",\"statusMessage\":"+sm.getStatusMessage()+"}");
			out.flush();
		}else{
			out.print("{\"statusCode\":\"0000\",\"statusMessage\":\"please enter valid credentails\"}");
	    	out.flush();
		}
	}
}
