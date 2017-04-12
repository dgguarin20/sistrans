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
import vos.TipoSilleteria;

public class DAOTipoSilleteria {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOTipoSilleteria() {
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

	
	public void addTipoSilleteria(TipoSilleteria c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.TIPO_SILLETERIA (TIPO) VALUES (";
		
		sql += "'"+c.getTipo()+ "')";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <TipoSilleteria> darTipoSilleteria() throws SQLException, Exception {
		ArrayList<TipoSilleteria> tipoS = new ArrayList<TipoSilleteria>();

		String sql = "SELECT * FROM ISIS2304A351720.TIPO_SILLETERIA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			
			int id = i;
			String  tipo = (rs.getString("TIPO"));
			
			tipoS.add(new TipoSilleteria(id,tipo));
i++;
		}
		return tipoS;
	}
	
	public void updateTipoSilleteria(TipoSilleteria c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.TIPO_SILLETERIA SET ";
		sql += "TIPO ='" + c.getTipo() + "',";
		
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteTipoSilleteria(TipoSilleteria b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.TIPO_SILLETERIA";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
	
}
