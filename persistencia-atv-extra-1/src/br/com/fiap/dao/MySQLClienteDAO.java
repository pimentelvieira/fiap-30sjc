package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Cliente;

public class MySQLClienteDAO implements ClienteDAO {

	@Override
	public List<Cliente> getClientes() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		
		try (Connection con = DAOFactory.abreConexao();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM clientes");
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt("IDCLIENTE");
				String nome = rs.getString("NOME");
				String email = rs.getString("EMAIL");

				Cliente cliente = new Cliente(id, nome, email);

				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	@Override
	public Cliente inserirCliente(Cliente cliente) throws Exception {
		try (Connection con = DAOFactory.abreConexao();
				PreparedStatement ps = con.prepareStatement("INSERT INTO clientes(NOME, EMAIL) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				cliente.setId(rs.getInt(1));
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public Cliente buscaPorId(int idCliente) throws Exception {
		Cliente cliente = null;
		try (Connection con = DAOFactory.abreConexao();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM clientes WHERE IDCLIENTE = ?");) {
			
			ps.setInt(1, idCliente);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("IDCLIENTE");
				String nome = rs.getString("NOME");
				String email = rs.getString("EMAIL");

				cliente = new Cliente(id, nome, email);
			}
		}
		
		return cliente;
	}
}
