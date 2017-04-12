package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Boleta;
import vos.Clasificacion;

public class DAOClasificacion {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOClasificacion() {
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

	
	public void addClasificacion(Clasificacion c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.CLASIFICACION (ID_CLASIFICACION, CLASIFICACION) VALUES (";
		sql += "'"+c.getId() + "',";
		sql += "'"+c.getClasificacion() + "')";;
		
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <Clasificacion> darClasificacion() throws SQLException, Exception {
		ArrayList<Clasificacion> clasificacion = new ArrayList<Clasificacion>();

		String sql = "SELECT * FROM ISIS2304A351720.CLASIFICACION";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id = Integer.parseInt(rs.getString("ID_CLASIFICACION"));
			String Clasificacion = (rs.getString("CLASIFICACION"));
			
			clasificacion.add(new Clasificacion(id, Clasificacion));
		}
		return clasificacion;
	}
	
	public void updateClasificacion(Clasificacion c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.CLASIFICACION SET ";
		sql += "CLASIFICACION ='" + c.getClasificacion() + "',";
		
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteClasificacion(Clasificacion b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.CLASIFICACION";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
}
