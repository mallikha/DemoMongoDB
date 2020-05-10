package com.mongodb.demoMongoDb.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EmployeeRepository {

	 MongoClient mongoClient;
	 MongoClient getClient() {
		 if(null == mongoClient) {
				mongoClient = new MongoClient("localhost",27017);
			}
		 return mongoClient;
	 }
	public List<Employee> findAll() {
		MongoClient client = getClient();
		MongoDatabase database =client.getDatabase("test");
		MongoCollection<Document> coll = database.getCollection("employee");
		List<Employee> response = new ArrayList<Employee>();
		for(Document doc : coll.find()) {
			Employee e = new Employee(doc.get("_id").toString(), doc.getString("firstName"), doc.getString("lastName"), doc.getString("address"));
			response.add(e);
		}
		return response;
	}
	public String save(Employee emp) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document = new Document();
		document.append("firstname", "malli");
		document.append("lastName", "konatham");
		document.append("address", "#07-1882,141041");
		Document document1 = new Document();
		document1.append("firstname", "malli123");
		document1.append("lastName", "konatham123");
		document1.append("address", "#07-183,141041");
		String respose;
		try {
			employeecollection.insertOne(document1);
			respose ="added";
		}catch(Exception e) {
			respose ="failed";
		}
		return respose;
	}
	public String update(Employee emp) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document1 = new Document();
		document1.append("firstname", "malli123");
		document1.append("lastName", "konatham123");
		document1.append("address", "#07-183,141041");
		String respose;
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(emp.get_id()));
			employeecollection.updateOne(filter, new BasicDBObject("", document1));
			respose ="updated";
		}catch(Exception e) {
			respose ="failed";
		}
		return respose;
	}
	public String delete(String id) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document1 = new Document();
		document1.append("firstname", "malli123");
		document1.append("lastName", "konatham123");
		document1.append("address", "#07-183,141041");
		String respose;
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(id));
			employeecollection.deleteOne(filter);
			respose ="deleted";
		}catch(Exception e) {
			respose ="failed";
		}
		return respose;
			
}
}
