package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAOFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fiap_persis_atv_extra_1";
	public static final String USER = "root";
	public static final String PASS = "fiap";
	
	public static Connection abreConexao() throws Exception {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASS);
	}
	public static ClienteDAO getClienteDAO() {
		return new MySQLClienteDAO();
	}
	public static PedidoDAO getPedidoDAO() {
		return new MySQLPedidoDAO();
	}
}
