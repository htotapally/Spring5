package com.sbt.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class MongoManager {

	private String host;
	private String dbname;
	private String collectionName;
	private String user;
	private String password;

	private static MongoManager mongoManager;

	private MongoManager() {
		try {
			Properties prop = new Properties();
			InputStream inputStream = MongoManager.class.getClassLoader()
					.getResourceAsStream("/mydb.cfg");
			prop.load(inputStream);

			this.host = prop.getProperty("host").toString();
			this.dbname = prop.getProperty("dbname").toString();
			this.collectionName = prop.getProperty("collectionName").toString();
			this.user = prop.getProperty("user").toString();
			this.password = prop.getProperty("password").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MongoManager getInstance() {
		if (mongoManager == null) {
			mongoManager = new MongoManager();
		}
		return mongoManager;
	}

	public MongoClient getMongoClient() {
		MongoCredential credential = MongoCredential.createCredential(user,
				dbname, password.toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress(host)); // ,
																			// Arrays.asList(credential));
		return mongoClient;
	}

	public DB getDb() {
		MongoClient mongoClient = getMongoClient();
		return mongoClient.getDB(dbname);
	}

	public DBCollection getDBCollection() {
		DB db = getDb();
		DBCollection dbCollection = db.getCollection(collectionName);
		return dbCollection;
	}

	public void addData(BasicDBObject document) {
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			DB db = mongoClient.getDB(dbname);
			DBCollection dbCollection = db.getCollection(collectionName);
			dbCollection.insert(document);
		} finally {
			mongoClient.close();
		}

	}

	public DBObject[] getObject(BasicDBObject searchQuery) {
		DBObject[] dbObjects = null;
		
		DBObject dbObject = null;
		List<DBObject> list = new LinkedList<>();
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			DB db = mongoClient.getDB(dbname);
			DBCollection dbCollection = db.getCollection(collectionName);
			DBCursor cursor = dbCollection.find(searchQuery);

			while (cursor.hasNext()) {
				dbObject = cursor.next();
				list.add(dbObject);
				System.out.println(dbObject);
			}

		} finally {
			mongoClient.close();
		}
		
		dbObjects = new DBObject[list.size()];
		list.toArray(dbObjects);
		return dbObjects;
	}

	public void updateData(BasicDBObject query, BasicDBObject newDocument) {
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			DB db = mongoClient.getDB(dbname);
			DBCollection dbCollection = db.getCollection(collectionName);
			dbCollection.update(query, newDocument);
		} finally {
			mongoClient.close();
		}
	}

	public void delete(BasicDBObject searchQuery) {
		MongoClient mongoClient = null;
		try {
			mongoClient = getMongoClient();
			DB db = mongoClient.getDB(dbname);
			DBCollection dbCollection = db.getCollection(collectionName);
			dbCollection.remove(searchQuery);
		} finally {
			mongoClient.close();
		}
	}

	/*
	 * public void addData(int repeats) { try {
	 * 
	 * Properties prop = new Properties(); InputStream inputStream =
	 * MongoManager.class.getResourceAsStream("./mydb.cfg");
	 * prop.load(inputStream);
	 * 
	 * host = prop.getProperty("host").toString(); dbname =
	 * prop.getProperty("dbname").toString(); user =
	 * prop.getProperty("user").toString(); password =
	 * prop.getProperty("password").toString();
	 * 
	 * System.out.println("host: " + host + "\ndbname: " + dbname + "\nuser: " +
	 * user + "\npassword: " + password);
	 * 
	 * MongoCredential credential = MongoCredential.createCredential(user,
	 * dbname, password.toCharArray()); MongoClient mongoClient = new
	 * MongoClient(new ServerAddress(host), Arrays.asList(credential));
	 * 
	 * MongoDatabase db = mongoClient.getDatabase(dbname);
	 * 
	 * try { db.getCollection("mycollection"); } catch (Exception e) {
	 * db.createCollection("mycollection", null); System.out.println("Repeats: "
	 * + repeats); for (int i = 1; i <= repeats; i++) { Document document = new
	 * Document("data", new Date());
	 * db.getCollection("mycollection").insertOne(document);
	 * System.out.println("INFO: row added " + document); } } finally {
	 * mongoClient.close(); } } catch (IOException ex) { } }
	 */
}
