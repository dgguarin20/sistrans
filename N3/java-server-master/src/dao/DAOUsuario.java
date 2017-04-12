package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Usuario;

public class DAOUsuario {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOUsuario (){
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


	public void addUsuario(Usuario c) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A351720.USUARIO (NOMBRES, IDENTIFICACION, CORREO, CLAVE, ID_TIPO_USUARIO) VALUES (";
		sql += "'"+c.getNombres()+ "', ";
		sql += "'"+c.getIdentificion()+ "', ";
		sql += "'"+c.getCorreo()+ "', ";
		sql += "'"+c.getClave()+ "', ";
		sql += "'"+c.getIdTipoCliente()+"')";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Usuario darUsuario(Long id) throws SQLException, Exception {
		String sql = "SELECT * FROM ISIS2304A351720.USUARIO WHERE ID_USUARIO = '" + id + "'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		rs.next();
		return new Usuario(rs.getLong("ID_USUARIO"),
				(rs.getString("NOMBRES")), 
				(rs.getString("IDENTIFICACION")), 
				(rs.getString("CORREO")), 
				(rs.getString("CLAVE")),
				Integer.parseInt(rs.getString("ID_TIPO_USUARIO")));
	}

	public ArrayList <Usuario> darUsuarios() throws SQLException, Exception {
		ArrayList<Usuario> us = new ArrayList<Usuario>();
		String sql = "SELECT * FROM ISIS2304A351720.USUARIO";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			us.add(new Usuario(
					rs.getLong("ID_USUARIO"),
					(rs.getString("NOMBRES")), 
					(rs.getString("IDENTIFICACION")), 
					(rs.getString("CORREO")), 
					(rs.getString("CLAVE")),
					Integer.parseInt(rs.getString("ID_TIPO_USUARIO"))));
		}
		return us;
	}

	public void updateUsuario(Usuario c) throws SQLException, Exception {
		String sql = "UPDATE ISIS2304A351720.USUARIO SET ";
		boolean name = c.getNombres() == null || c.getNombres().isEmpty();
		boolean clave = c.getClave() == null || c.getClave().isEmpty();
		boolean correo = c.getCorreo() == null || c.getCorreo().isEmpty();
		boolean identificacion = c.getIdentificion() == null || c.getIdentificion().isEmpty();
		boolean id_c = c.getIdTipoCliente() == null || c.getIdTipoCliente() < 1;
		if (!name)
			sql += "NOMBRES = '" + c.getNombres()+"'";
		if (!clave) {
			if (!name)
				sql += ", ";
			sql += "CLAVE = '" + c.getClave()+"'";
		} if (!correo) {
			if (!name || !clave)
				sql += ", ";
			sql += "CORREO ='" + c.getCorreo()+ "'";
		} if (!identificacion) {
			if (!name || !clave || !correo)
				sql += ", ";
			sql += "IDENTIFICACION = '" + c.getIdentificion()+ "'";	
		} if (!id_c) {
			if (!name || !clave || !correo || !identificacion)
				sql += ", ";
			sql += "ID_TIPO_CLIENTE = '" + c.getIdTipoCliente()+ "'";
		}
		sql += " WHERE id_usuario = '" + c.getId() + "'";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteUsuario(Usuario b) throws SQLException, Exception {
		String sql = "DELETE FROM ISIS2304A351720.USUARIO";
		sql += " WHERE id_usuario = '" + b.getId() + "'";
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
