package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import vos.Espacio;
import vos.TipoEspacio;

public class DAOTipoEspacio {


private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOTipoEspacio() {
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

	
	public void addTipoEspacio(TipoEspacio c) throws SQLException, Exception {

		String sql = "INSERT INTO TIPO_ESPACIO (TIPO) VALUES (";
		
		sql +="'"+ c.getTipoEspacio()+")";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <TipoEspacio> darTipoEspacio() throws SQLException, Exception {
		ArrayList<TipoEspacio> Espacio = new ArrayList<TipoEspacio>();

		String sql = "SELECT * FROM TIPO_ESPACIO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id = Integer.parseInt(rs.getString("ID_TIPO_ESPACIO"));
			String Tipo = (rs.getString("TIPO_ESPACIO"));
			
		
			Espacio.add(new TipoEspacio(id, Tipo));
		}
		return Espacio;
	}
	
	public void updateTipoEspacio(TipoEspacio c) throws SQLException, Exception {

		String sql = "UPDATE TIPO_ESPACIO SET ";
		sql += "ID_TIPO_ESPACIO ='" + c.getTipoEspacio();
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteTipoEspacio(TipoEspacio b) throws SQLException, Exception {

		String sql = "DELETE FROM TIPO_ESPACIO";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
}
