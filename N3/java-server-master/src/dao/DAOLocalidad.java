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
import vos.Localidad;

public class DAOLocalidad {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOLocalidad() {
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

	
	public void addLocalidad(Localidad c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.LOCALIDAD (LOCALIDAD, NUMERADA, CAPACIDAD, PRECIO, ID_FUNCION) VALUES (";
		sql += "'"+ c.getId() + ",'";
		sql += "'"+ c.getLocalidad()+ "',";
		sql += "'"+ c.getCapacidad() + "',";
		sql += "'"+ c.getIdFuncion()+ "',";
		sql += "'"+ c.getNumerada() + "',";
	
		
		
		boolean esp = c.getNumerada();
		String a;
		if(esp == true)
		{
			a = 1 + "";
		}
		else
		{
			a = 0+ "";
		}
		
		sql += "'"+ c.getPrecio() + "')";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <Localidad> darLocalidad() throws SQLException, Exception {
		ArrayList<Localidad> local = new ArrayList<Localidad>();

		String sql = "SELECT * FROM ISIS2304A351720.LOCALIDAD";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			Integer id = Integer.parseInt(rs.getString("ID_LOCALIDAD"));
			String localidad = (rs.getString("LOCALIDAD"));
			Integer capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			Integer idFun = Integer.parseInt(rs.getString("ID_FUNCION"));
			Double precio = (double) Integer.parseInt(rs.getString("precio"));
			
			boolean numerada;
			if(Integer.parseInt(rs.getString("NUMERADA")) == 1) 
			{
				numerada = true;
			}
			else
			{
				numerada= false;
			}
			
			
			
			local.add(new Localidad(id,localidad,numerada,capacidad,precio, idFun ));
		}
		return local;
	}
	
	public void updateLocalidad(Localidad c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.LOCALIDAD SET ";
		sql += "ID_FUNCION ='" + c.getIdFuncion() + "',";
		sql += "LOCALIDAD ='" + c.getLocalidad()+ "',";
		sql += "PRECIO ='" + c.getPrecio()+ "',";
		sql += "NUMERADA ='" + c.getNumerada();
		sql += "CAPACIDAD =" + c.getCapacidad();
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteLocalidad(Localidad b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.LOCALIDAD";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
}
