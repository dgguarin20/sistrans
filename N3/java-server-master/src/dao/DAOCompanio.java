package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Clasificacion;
import vos.Compania;

public class DAOCompanio {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOCompanio() {
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

	
	public void addCompania(Compania c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.COMPANIA (NOMBRE, SITIO_WEB, REPRESENTANTE, PAIS ) VALUES (";
		sql += "'"+ c.getId() + "',";
		sql += "'"+c.getNombre() + "',";
		sql += "'"+c.getPais() + "',";
		sql += "'"+c.getRepresentante() + "',";
		sql += "'"+c.getSitioWeb() + "')";;
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <Compania> darCompania() throws SQLException, Exception {
		ArrayList<Compania> compania = new ArrayList<Compania>();

		String sql = "SELECT * FROM ISIS2304A351720.COMPANIA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id = Integer.parseInt(rs.getString("ID_COMPANIA"));
			String  pais = (rs.getString("PAIS"));
			String representante = (rs.getString("REPRESENTANTE"));
			String SitioWeb = (rs.getString("SITIOWEB"));
			String nombre = (rs.getString("NOMBRE"));
			
			
			
			compania.add(new Compania(id, nombre, pais, representante, SitioWeb));
		}
		return compania;
	}
	
	public void updateCompania(Compania c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.COMPANIA SET ";
		sql += "NOMBRE ='" + c.getNombre() + "',";
		sql += "PAIS ='" + c.getPais() + "',";
		sql += "REPRESENTANTE ='" + c.getRepresentante() + "',";
		sql += "SITIOWEB ='" + c.getSitioWeb() + "',";
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteCompania(Compania b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.COMPANIA";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
}
