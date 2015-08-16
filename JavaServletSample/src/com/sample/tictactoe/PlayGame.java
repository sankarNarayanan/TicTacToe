package com.sample.tictactoe;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PlayGame {
	@SuppressWarnings("unchecked")
	public void getUserMoveAndRespond(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession(true);
		ArrayList<String> systemSelectedpositions = new ArrayList<String>(), userSelectedPositions = new ArrayList<String>();
		if (null != session.getAttribute("systemSelectedPos") && null != session.getAttribute("userSelectedPos")){
			if (!(session.isNew())){
				systemSelectedpositions = (ArrayList<String>) session.getAttribute("systemSelectedPos");
				userSelectedPositions = (ArrayList<String>) session.getAttribute("userSelectedPos");
			}
		}
		String userPositionString = request.getParameter("position");
		userSelectedPositions.add(userPositionString);
		if ((userSelectedPositions.size() + systemSelectedpositions.size()) >= 8){
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print("{\"statusCode\":\"1115\",\"statusMessage\":\"Game Over!\"}");
			out.flush();
			return;
		}else{

		}
	}

	public int calculateNextMove (ArrayList<String> userPositions, ArrayList<String> systemPos){
		ArrayList<String> totalPos = (ArrayList<String>) Arrays.asList("1", "2","3", "4","5", "6","7", "8","9");
		ArrayList<String> availablePos = new ArrayList<String>();
		for(String element:totalPos){
			 if (!userPositions.contains(element) && !systemPos.contains(element)){
				 availablePos.add(element);
			 }
		}
		
		return (Integer) null;
	}
	
	public int findBestPosition (ArrayList<String> availablePositions, ArrayList<String> userPositions){
		return (Integer) null;
	}
	
}
