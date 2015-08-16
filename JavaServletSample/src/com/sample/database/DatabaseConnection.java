package com.sample.database;

import com.mongodb.*;
import com.sample.models.*;

public class DatabaseConnection {
	public StatusModel createUserName(UserModel userModel) throws Exception{
		StatusModel sm = new StatusModel();
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		System.out.println("Mongo client: " +mongoClient);
		DB database = mongoClient.getDB("my_db");
		System.out.println("Mongo Database" +database);
		DBCollection collection = database.getCollection("UserTable");
		System.out.println("Mongo Collection" +collection);
		DBObject query = new BasicDBObject("_id", userModel.getUserName());
		DBCursor cursor = collection.find(query);
		DBObject userObject = cursor.one();
		if (null != userObject){
			sm.setStatusCode("1112");
			sm.setStatusMessage("User Name already exists");
		}else{
		DBObject user = new BasicDBObject("_id", userModel.getUserName())
                .append("name", userModel.getUserName())
                .append("password", userModel.getPassword());
		collection.insert(user);
		sm.setStatusCode("1113");
		sm.setStatusMessage("User Name Created");
		}
		return sm;
	}
	
	
	public static final DBObject toDBObject(UserModel user) {
	    return new BasicDBObject("_id", user.getUserName())
	                     .append("name", user.getUserName())
	                     .append("password", user.getPassword());
	}
	
}
