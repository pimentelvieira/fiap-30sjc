package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface PedidoDAO {

	public List<Pedido> getPedidos() throws Exception;
	public Pedido inserirPedido(Pedido pedido) throws Exception;
}
