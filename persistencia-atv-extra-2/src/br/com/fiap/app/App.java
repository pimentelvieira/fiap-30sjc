package br.com.fiap.app;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.helper.ClienteHelper;
import br.com.fiap.helper.PedidoHelper;

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
		
		System.out.println(new ClienteHelper().salvar(cliente1));
		System.out.println(new ClienteHelper().salvar(cliente2));
		System.out.println(new ClienteHelper().salvar(cliente3));
		
		System.out.println(new PedidoHelper().salvar(pedido1));
		System.out.println(new PedidoHelper().salvar(pedido2));
		System.out.println(new PedidoHelper().salvar(pedido3));
		
		Cliente clienteRecuperado = new ClienteHelper().buscarPorId(1);
		System.out.println(clienteRecuperado.getNome());
		
		List<Cliente> clientes = new ClienteHelper().listar();
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		Pedido pedidoRecuperado = new PedidoHelper().buscarPorId(1);
		System.out.println(pedidoRecuperado.getDescricao());
		
		List<Pedido> pedidos = new PedidoHelper().listar();
		pedidos.forEach(p -> System.out.println(p.getDescricao()));
	}
}
