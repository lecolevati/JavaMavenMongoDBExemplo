package persistence;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ClienteDao {

	private MongoClient cli;
	private MongoDatabase db;
	private MongoCollection<Document> collection;

	public ClienteDao() {
		MongoConnection con = new MongoConnection();
		cli = con.mongoConnect();
		db = cli.getDatabase("aulaLabBD");
		collection = db.getCollection("cliente");
	}
	
	public void insertOneCliente(Document cliente) {
		collection.insertOne(cliente);
	}
	
	public void insertManyCliente(List<Document> clientes) {
		collection.insertMany(clientes);
	}
	
	public void updateOneCliente(Bson filtro, Bson bson) {
		collection.updateOne(filtro, bson);
	}
	
	public void updateManyCliente(Bson filtro, Bson bson) {
		collection.updateMany(filtro, bson);
	}
	
	public void deleteOneCliente(Bson filtro) {
		collection.deleteOne(filtro);
	}
	
	public void deleteManyCliente(Bson filtro) {
		collection.deleteMany(filtro);
	}
	
	public FindIterable<Document> findAllClientes() {
		FindIterable<Document> clientes = collection.find();
		return clientes;
	}

	public FindIterable<Document> findClientes(Bson filtro, Bson ordem) {
		FindIterable<Document> clientes = collection.find(filtro);
		if (ordem != null) {
			clientes.sort(ordem);
		}
		return clientes;
	}
}
