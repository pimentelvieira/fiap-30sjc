package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Pedido;

public class MySQLPedidoDAO implements PedidoDAO {

	@Override
	public List<Pedido> getPedidos() {
		List<Pedido> pedidos = new ArrayList<>();
		
		try (Connection con = DAOFactory.abreConexao();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM pedidos");
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt("IDPEDIDO");
				int idCliente = rs.getInt("IDCLIENTE");
				java.util.Date data = rs.getDate("DATA");
				String descricao = rs.getString("DESCRICAO");
				double valor = rs.getDouble("VALOR");

				Pedido pedido = new Pedido(id, idCliente, data, descricao, valor);

				pedidos.add(pedido);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pedidos;
	}
	@Override
	public Pedido inserirPedido(Pedido pedido) {
		try (Connection con = DAOFactory.abreConexao();
				PreparedStatement ps = con.prepareStatement("INSERT INTO pedidos(IDCLIENTE, DATA, DESCRICAO, VALOR) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);) {

			ps.setInt(1, pedido.getIdCliente());
			ps.setDate(2, new java.sql.Date(pedido.getData().getTime()));
			ps.setString(3, pedido.getDescricao());
			ps.setDouble(4, pedido.getValor());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				pedido.setId(rs.getInt(1));
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pedido;
	}
}
