package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Cliente;
import vos.Usuario;

public class DAOCliente {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOCliente() {
		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	/**
	 * Método que inicializa la connection del DAO a la base de datos con la conexión que entra como parámetro.
	 * @param con  - connection a la base de datos
	 */
	public void setConn(Connection con){
		this.conn = con;
	}


	public void addCliente(Cliente c) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A351720.CLIENTE (ID_USUARIO) VALUES (";
		sql += "'"+c.getUsuario().getId()+"')";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Cliente darCliente(Long id) throws SQLException, Exception {
		String sql = "SELECT * FROM ISIS2304A351720.CLIENTE WHERE ID_USUARIO = '" + id + "'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		rs.next();
		Long idc = rs.getLong("ID_CLIENTE");
		Long idu = rs.getLong("ID_USUARIO");
		prepStmt = conn.prepareStatement("SELECT * FROM ISIS2304A351720.USUARIO WHERE ID_USUARIO = '" + idu + "'");
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		rs.next();
		return new Cliente(idc,
				new Usuario(idu, 
						rs.getString("NOMBRES"),
						rs.getString("IDENTIFICACION"),
						rs.getString("CORREO"),
						rs.getString("CLAVE"),
						rs.getInt("ID_TIPO_USUARIO")));
	}

	public ArrayList <Cliente> darClientes() throws SQLException, Exception {
		ArrayList<Cliente> us = new ArrayList<Cliente>();
		String sql = "SELECT * FROM ISIS2304A351720.CLIENTE";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		ResultSet rs2;
		while (rs.next()) {
			Long idc = rs.getLong("ID_CLIENTE");
			Long idu = rs.getLong("ID_USUARIO");
			prepStmt = conn.prepareStatement("SELECT * FROM ISIS2304A351720.USUARIO WHERE ID_USUARIO = '" + idu + "'");
			recursos.add(prepStmt);
			rs2 = prepStmt.executeQuery();
			rs2.next();
			us.add(new Cliente(idc,
					new Usuario(idu, 
							rs2.getString("NOMBRES"),
							rs2.getString("IDENTIFICACION"),
							rs2.getString("CORREO"),
							rs2.getString("CLAVE"),
							rs2.getInt("ID_TIPO_USUARIO"))));
		}
		return us;
	}

	public void updateCliente(Cliente c) throws SQLException, Exception {
		String sql = "UPDATE ISIS2304A351720.USUARIO SET ";
		boolean idu = c.getUsuario().getId() == null || c.getUsuario().getId() < 1;
		if (!idu)
			sql += "ID_USUARIO = '" +c.getUsuario().getId()+"'";
		sql += " WHERE id_cliente = '" + c.getId() + "'";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteCliente(Cliente c) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A351720.CLIENTE";
		sql += " WHERE id_cliente = '" + c.getId() + "'";
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
