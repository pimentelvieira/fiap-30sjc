package br.com.fiap.app;

import java.util.Date;
import java.util.List;

import br.com.fiap.dao.MySQLClienteDAO;
import br.com.fiap.dao.MySQLPedidoDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class Main {

	public static void main(String[] args) throws Exception {
		new MySQLClienteDAO().inserirCliente(new Cliente("William", "will@will.com"));
		new MySQLClienteDAO().inserirCliente(new Cliente("Pedro", "pedro@pedro.com"));
		new MySQLClienteDAO().inserirCliente(new Cliente("Artur", "artur@artur.com"));
		List<Cliente> clientes = new MySQLClienteDAO().getClientes();
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println();
		
		new MySQLPedidoDAO().inserirPedido(new Pedido(1, new Date(), "Pedido 1", 50));
		new MySQLPedidoDAO().inserirPedido(new Pedido(2, new Date(), "Pedido 2", 100));
		new MySQLPedidoDAO().inserirPedido(new Pedido(3, new Date(), "Pedido 3", 150));
		List<Pedido> pedidos = new MySQLPedidoDAO().getPedidos();
		pedidos.forEach(p -> System.out.println(p.getDescricao()));
	}
}
