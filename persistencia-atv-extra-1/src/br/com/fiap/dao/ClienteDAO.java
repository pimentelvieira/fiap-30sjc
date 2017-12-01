package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO {

	public List<Cliente> getClientes() throws Exception;
	public Cliente inserirCliente(Cliente cliente) throws Exception;
	public Cliente buscaPorId(int id) throws Exception;
}
