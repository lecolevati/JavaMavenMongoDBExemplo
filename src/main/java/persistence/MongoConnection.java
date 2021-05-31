package persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {

	public MongoClient mongoConnect() {
		String con = "mongodb://admin:P4ssword@localhost:27017/?authSource=admin&readPreference=primary&ssl=false";
		ConnectionString connectionString = new ConnectionString(con);
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient;
	}
	
}
