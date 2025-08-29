package com.mst.database.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoExample {
    public static void main(String[] args) {
        // Connection string (adjust if your MongoDB is remote or has auth)
        String uri = "mongodb://localhost:27017";

        // Use try-with-resources so client closes automatically
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Get the "school" database
            MongoDatabase database = mongoClient.getDatabase("school");

            // Get the "students" collection
            MongoCollection<Document> students = database.getCollection("students");

            // Insert some student documents
            Document student1 = new Document("name", "Ali")
                    .append("age", 15)
                    .append("grade", "10th")
                    .append("city", "Jerusalem");

            Document student2 = new Document("name", "Maya")
                    .append("age", 14)
                    .append("grade", "9th")
                    .append("city", "Haifa");

            students.insertOne(student1);
            students.insertOne(student2);

            System.out.println("Inserted students!");

            // Query all students
            System.out.println("\nAll students:");
            for (Document d : students.find()) {
                System.out.println(d.toJson());
            }

            // Query with filter (students age > 14)
            System.out.println("\nStudents older than 14:");
            for (Document d : students.find(new Document("age", new Document("$gt", 14)))) {
                System.out.println(d.toJson());
            }

            // Run a raw MongoDB command (just to show how)
            Document stats = database.runCommand(new Document("collStats", "students"));
            System.out.println("\nCollection Stats: " + stats.toJson());
        }
    }
}

