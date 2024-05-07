//package com.yangfan.exam;
//
//import com.mongodb.client.*;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MongoDBUtil {
//    private static MongoClient mongoClient;
//
//    @Value("${spring.data.mongodb.uri}") // 从 application.properties 中读取 MongoDB 连接 URI
//    private String mongoURI;
//
////     获取单例 MongoDB 客户端实例
//    private synchronized MongoClient getMongoClient() {
//        if (mongoClient == null) {
//            mongoClient = MongoClients.create(mongoURI);
//            System.out.println("MongoDB client initialized successfully");
//        }
//        System.out.println("MongoDB链接已存在");
//        return mongoClient;
//    }
//
//
//    // 连接到 MongoDB 数据库
//    public MongoDatabase connectToDatabase(String databaseName) {
//        MongoClient client = getMongoClient();
//        System.out.println("Connected to MongoDB successfully");
//        return client.getDatabase(databaseName);
//    }
//
//    // 获取指定集合
////    public MongoCollection<Document> getCollection(String databaseName, String collectionName) {
////        MongoDatabase database = connectToDatabase(databaseName);
////        return database.getCollection(collectionName);
////    }
//
//    // 执行查询并返回结果集
//    public FindIterable<Document> executeQuery(String databaseName, String collectionName, Bson filter) {
//        MongoCollection<Document> collection = connectToDatabase(databaseName).getCollection(collectionName);
//        return collection.find(filter);
//    }
//}