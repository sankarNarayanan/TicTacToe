package com.sample.auth;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sample.models.*;
import com.sample.database.DatabaseConnection;

public class RegisterUser {
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) throws Exception
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
			StatusModel sm = db.createUserName(um);
			out.print("{\"statusCode\":"+sm.getStatusCode()+",\"statusMessage\":"+sm.getStatusMessage()+"}");
			out.flush();
		}else{
			out.print("{\"statusCode\":\"1111\",\"statusMessage\":\"Empty user Input\"}");
	    	out.flush();
		}
	}
}
