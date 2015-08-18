package com.sample.tictactoe;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class PlayGame {
	@SuppressWarnings("unchecked")
	public void getUserMoveAndRespond(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String systemSlection;
		String boardState = request.getParameter("boardState");
		ArrayList<String> userPositions = new ArrayList<String>(), 
				systemPositions = new ArrayList<String>(), 
				emptyPositions= new ArrayList<String>();
		JsonObject boardStatejsonObject = (JsonObject)new JsonParser().parse(boardState);
		if (boardStatejsonObject.isJsonObject()) {
			Set<Entry<String, JsonElement>> entries = ((JsonObject) boardStatejsonObject).entrySet();
			if (entries != null) {
				for (Entry<String, JsonElement> node : entries) {
					String currentState = node.getValue().getAsString();
					if (currentState.equalsIgnoreCase("s")){
						systemPositions.add(node.getKey());
					}else if (currentState.equalsIgnoreCase("u")){
						userPositions.add(node.getKey());
					}else if (currentState.equalsIgnoreCase("e")){
						emptyPositions.add(node.getKey());
					}
				}
			}
		} 

		//User positions, system positions & empty positions available, Please start the game

		if (userPositions.isEmpty() && systemPositions.isEmpty() && emptyPositions.size() == 9){
			systemSlection = "5";
		}else{

		}



		//
		//		
		//		HttpSession session = request.getSession(true);
		//		ArrayList<String> systemSelectedpositions = new ArrayList<String>(), userSelectedPositions = new ArrayList<String>();
		//		if (null != session.getAttribute("systemSelectedPos") && null != session.getAttribute("userSelectedPos")){
		//			if (!(session.isNew())){
		//				systemSelectedpositions = (ArrayList<String>) session.getAttribute("systemSelectedPos");
		//				userSelectedPositions = (ArrayList<String>) session.getAttribute("userSelectedPos");
		//			}
		//		}
		//		String userPositionString = request.getParameter("position");
		//		userSelectedPositions.add(userPositionString);
		//		if ((userSelectedPositions.size() + systemSelectedpositions.size()) >= 8){
		//			response.setContentType("application/json");
		//			PrintWriter out = response.getWriter();
		//			out.print("{\"statusCode\":\"1115\",\"statusMessage\":\"Game Over!\"}");
		//			out.flush();
		//			return;
		//		}else{
		//
		//		}
	}



	public int calculateNextMove (ArrayList<String> userPositions, ArrayList<String> systemPositions){

		if ((userPositions.contains("4") && userPositions.contains("5"))){

		}

		return 1;
	}

	public int findBestPosition (ArrayList<String> availablePositions, ArrayList<String> userPositions){
		return (Integer) null;
	}

}
