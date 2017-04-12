package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import vos.Espacio;
import vos.FestivalCompania;

public class DAOFestivalCompania {


	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOFestivalCompania() {
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

	
	public void addFestivalCompania(FestivalCompania c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.FESTIVAL_COMPANIA (ID_COMPANIA, LLEGADA, SALIDA) VALUES (";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql +="'"+ c.getIdCompania() + "',";
		
		sql +="TO_DATE('"+sdf.format(c.getLlegada())+"'),";
		sql +="TO_DATE('"+sdf.format(c.getSalida())+"'))";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <FestivalCompania> darFestivalCompania() throws SQLException, Exception {
		ArrayList<FestivalCompania> festivalC = new ArrayList<FestivalCompania>();

		String sql = "SELECT * FROM ISIS2304A351720.FESTIVAL_COMPANIA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
			int i =0;
		while (rs.next()) {
			
			int id = i;
			int idCompania = Integer.parseInt(rs.getString("ID_COMPANIA"));
			
			DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH24:MM:SS", Locale.ENGLISH);
			Date d = new Date();
			Date s = new Date();
			Date Llegada = d;//format.parse((rs.getString("LLEGADA")));
			Date Salida =  s;//format.parse((rs.getString("SALIDA")));
			i++;
			
			festivalC.add(new FestivalCompania(id, idCompania,Llegada, Salida));
		}
		return festivalC;
	}
	
	public void updateFestivalC(FestivalCompania c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.FESTIVALCOMPANIA SET ";
		sql += "ID_COMPANIA ='" + c.getIdCompania() + "',";
		sql += "LLEGADA ='" + c.getLlegada() + "',";
		sql += "SALIDA ='" + c.getSalida();
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteFestivalC(FestivalCompania b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.FESTIVAL_COMPANIA";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
	
	
}
