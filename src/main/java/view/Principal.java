package view;

import java.util.ArrayList;
import java.util.List;

import controller.ClienteController;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {
//		Cliente c1 = new Cliente();
//		c1.setId("7");
//		c1.setNome("Charlie Brown");
//		c1.setEmail("charlie@brown.com");
//
//		Cliente c2 = new Cliente();
//		c2.setId("8");
//		c2.setNome("Layla Got on My Knees");
//		c2.setEmail("layla@got.com");
//
//		Cliente c3 = new Cliente();
//		c3.setId("9");
//		c3.setNome("Woodstock Bird");
//		c3.setEmail("wood@bird.com");
//
//		List<Cliente> lista = new ArrayList<Cliente>();
//		lista.add(c2);
//		lista.add(c3);
//		
//		ClienteController cCont = new ClienteController();
//		cCont.saveCliente(c1);
//		cCont.saveClientes(lista);

//		Cliente c1 = new Cliente();
//		c1.setId("7");
//		c1.setCredito("1875.00");
//
//		Cliente c2 = new Cliente();
//		c2.setId("8");
//		c2.setCredito("3331.00");
//
//		ClienteController cCont = new ClienteController();
//		cCont.updateClientes(c1, 0);
//		cCont.updateClientes(c2, 4);
		
//		Cliente c1 = new Cliente();
//		c1.setId("9");
//		ClienteController cCont = new ClienteController();
//		cCont.deleteCliente(c1);
		
		ClienteController cCont = new ClienteController();
		cCont.findClientes("credito", "3000.00");
		System.out.println("=======================================================================");
		cCont.findClientes(null, null);
		
	}

}
