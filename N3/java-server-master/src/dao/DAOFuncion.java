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
import vos.funcion;

public class DAOFuncion {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOFuncion() {
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

	
	public void addFuncion(funcion c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.FUNCION (ID_ESPECTACULO, ID_ESPACIO, FECHA, TERMINADA_BIEN) VALUES (";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql += "'"+c.getIdEspectaculo() + "',";
		sql += "'"+c.getIdEspacio() + "',";
		sql += "TO_DATE('"+sdf.format(c.getFecha()) + "', 'YYYY-MM-DD HH24:MI:SS'), ";
		boolean esp = c.getTerminadaBien();
		String a;
		if(esp == true)
		{
			a = 1 + "";
		}
		else
		{
			a = 0+ "";
		}
		sql +="'"+ a+ "'"+ ")";;
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <funcion> darFuncion() throws SQLException, Exception {
		ArrayList<funcion> funcion = new ArrayList<funcion>();

		String sql = "SELECT * FROM ISIS2304A351720.FUNCION";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			Integer id = Integer.parseInt(rs.getString("ID_FUNCION"));
			Integer idEsp = Integer.parseInt(rs.getString("ID_ESPECTACULO"));
			Integer idEspa = Integer.parseInt(rs.getString("ID_ESPACIO"));			
			Date fecha =  rs.getDate("FECHA");
			boolean especiales;
			if(Integer.parseInt(rs.getString("TERMINADA_BIEN")) == 1) 
			{
				especiales = true;
			}
			else
			{
				especiales = false;
			}
			
			funcion.add(new funcion(id,idEsp,idEspa,fecha,especiales));
		}
		return funcion;
	}
	
	public void updateFuncion(funcion c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.FUNCION SET ";
		
		sql += "ID_ESPACIO ='" + c.getIdEspacio() + "',";
		sql += "ID_ESPECTACULO ='" + c.getIdEspectaculo()+ "',";
		sql += "FECHA ='" + c.getFecha()+ "',";
		boolean esp = c.getTerminadaBien();
		String a;
		if(esp == true)
		{
			a = 1 + "";
		}
		else
		{
			a = 0+ "";
		}
		sql += "TERMINADA_BIEN ='" + a + "'";
		sql += " WHERE id_funcion = '" + c.getId()+"'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteFuncion(funcion b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.FUNCION";
		sql += " WHERE ID_FUNCION = '" + b.getId()+"'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	
	
	
	}

	
	
	
}
