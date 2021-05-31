package controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

import model.Cliente;
import persistence.ClienteDao;

public class ClienteController {

	public void saveCliente(Cliente c) {
		ClienteDao cDao = new ClienteDao();
		
		Document doc = new Document("_id", c.getId());
		doc.append("nome", c.getNome());
		doc.append("email", c.getEmail());
		
		cDao.insertOneCliente(doc);
	}
	
	public void saveClientes(List<Cliente> lista) {
		ClienteDao cDao = new ClienteDao();
		List<Document> listaDoc = new ArrayList<Document>();
		
		for (Cliente c : lista) {
			Document doc = new Document("_id", c.getId());
			doc.append("nome", c.getNome());
			doc.append("email", c.getEmail());
			
			listaDoc.add(doc);
		}
		
		cDao.insertManyCliente(listaDoc);
	}
	
	
	public void updateClientes(Cliente c, int tipo) {
		Bson filtro;
		
		switch (tipo) {
		case 0:
			filtro = Filters.eq("_id", c.getId());
			break;
		case 1:
			filtro = Filters.ne("_id", c.getId());
			break;
		case 2:
			filtro = Filters.gt("_id", c.getId());
			break;
		case 3:
			filtro = Filters.lt("_id", c.getId());
			break;
		case 4:
			filtro = Filters.gte("_id", c.getId());
			break;
		case 5:
			filtro = Filters.lte("_id", c.getId());
			break;
		default:
			filtro = Filters.eq("_id", c.getId());
			break;

		}
		
		Bson bson = Updates.set("credito", c.getCredito());
		
		ClienteDao cDao = new ClienteDao();
		if (tipo == 0) {
			cDao.updateOneCliente(filtro, bson);
		} else {
			cDao.updateManyCliente(filtro, bson);
		}
	}
	
	public void deleteCliente(Cliente c) {
		Bson filtro = Filters.eq("_id",c.getId());
		ClienteDao cDao = new ClienteDao();
		cDao.deleteOneCliente(filtro);
	}
	
	public void findClientes(String nomeAtr, String valor) {
		ClienteDao cDao = new ClienteDao();
		FindIterable<Document> docs;
		
		if (nomeAtr == null) {
			docs = cDao.findAllClientes();
		} else {
			Bson filtro = Filters.eq(nomeAtr, valor);
			Bson ordem = Sorts.ascending("nome");
			docs = cDao.findClientes(filtro, ordem);
		}
		
		for (Document doc : docs) {
			System.out.println(doc.toJson());
		}
	}
	
}
