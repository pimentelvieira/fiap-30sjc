package br.com.fiap.app;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class App {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Cliente 1");
		cliente1.setEmail("cliente1@cliente1.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Cliente 2");
		cliente2.setEmail("cliente2@cliente2.com");
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Cliente 3");
		cliente3.setEmail("cliente3@cliente3.com");
		
		Pedido pedido1 = new Pedido();
		pedido1.setData(LocalDate.now());
		pedido1.setDescricao("Pedido 1");
		pedido1.setValor(100);
		pedido1.setCliente(cliente1);
		
		Pedido pedido2 = new Pedido();
		pedido2.setData(LocalDate.now());
		pedido2.setDescricao("Pedido 2");
		pedido2.setValor(200);
		pedido2.setCliente(cliente2);
		
		Pedido pedido3 = new Pedido();
		pedido3.setData(LocalDate.now());
		pedido3.setDescricao("Pedido 3");
		pedido3.setValor(300);
		pedido3.setCliente(cliente3);

		//Adicionar Cliente
		GenericDAO<Cliente> clienteDAO = new GenericDAO<>(Cliente.class);
		clienteDAO.adicionar(cliente1);
		System.out.println(cliente1.getNome() + " adicionado com sucesso!");
		clienteDAO.adicionar(cliente2);
		System.out.println(cliente2.getNome() + " adicionado com sucesso!");
		clienteDAO.adicionar(cliente3);
		System.out.println(cliente3.getNome() + " adicionado com sucesso!");
		System.out.println();
		
		//Adicionar Pedido
		GenericDAO<Pedido> pedidoDAO = new GenericDAO<>(Pedido.class);
		pedidoDAO.adicionar(pedido1);
		System.out.println(pedido1.getDescricao() + " adicionado com sucesso!");
		pedidoDAO.adicionar(pedido2);
		System.out.println(pedido2.getDescricao() + " adicionado com sucesso!");
		pedidoDAO.adicionar(pedido3);
		System.out.println(pedido3.getDescricao() + " adicionado com sucesso!");
		System.out.println();
		
		//Listar Clientes
		List<Cliente> clientes = clienteDAO.listar();
		System.out.println("---->> Lista de Clientes <<----");
		clientes.forEach(c -> System.out.println(c.getNome()));
		System.out.println();
		
		//Listar Pedidos
		List<Pedido> pedidos = pedidoDAO.listar();
		System.out.println("---->> Lista de Pedidos <<----");
		pedidos.forEach(c -> System.out.println(c.getDescricao()));
		System.out.println();
		
		//Atualizar Cliente
		Cliente clienteForUpdate = clienteDAO.buscar(1);
		clienteForUpdate.setNome("Cliente 1 Atualizado");
		clienteDAO.atualizar(clienteForUpdate);
		System.out.println("Cliente 1 atualizado com sucesso!");
		
		//Atualizar Pedido
		Pedido pedidoForUpdate = pedidoDAO.buscar(1);
		pedidoForUpdate.setDescricao("Pedido 1 Atualizado");
		pedidoDAO.atualizar(pedidoForUpdate);
		System.out.println("Pedido 1 atualizado com sucesso!");
		System.out.println();
		
		//Listar Clientes
		clientes = clienteDAO.listar();
		System.out.println("---->> Lista de Clientes <<----");
		clientes.forEach(c -> System.out.println(c.getNome()));
		System.out.println();
		
		//Listar Pedidos
		pedidos = pedidoDAO.listar();
		System.out.println("---->> Lista de Pedidos <<----");
		pedidos.forEach(c -> System.out.println(c.getDescricao()));
		System.out.println();
		
		//Remover Pedido
		Pedido pedidoForDelete = pedidoDAO.buscar(1);
		pedidoDAO.remover(pedidoForDelete);
		System.out.println("Cliente 1 removido com sucesso!");
		
		//Remover Cliente
		Cliente clienteForDelete = clienteDAO.buscar(1);
		clienteDAO.remover(clienteForDelete);
		System.out.println("Pedido 1 removido com sucesso!");
		System.out.println();
		
		//Listar Clientes
		clientes = clienteDAO.listar();
		System.out.println("---->> Lista de Clientes <<----");
		clientes.forEach(c -> System.out.println(c.getNome()));
		System.out.println();
		
		//Listar Pedidos
		pedidos = pedidoDAO.listar();
		System.out.println("---->> Lista de Pedidos <<----");
		pedidos.forEach(c -> System.out.println(c.getDescricao()));
		System.out.println();
	}
}
