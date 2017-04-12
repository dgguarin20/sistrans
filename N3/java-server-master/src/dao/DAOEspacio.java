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

import vos.Compania;
import vos.Espacio;

public class DAOEspacio {

	
private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOEspacio() {
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

	
	public void addEspacio(Espacio c) throws SQLException, Exception {

		String sql = "INSERT INTO ISIS2304A351720.ESPACIO() VALUES (";
		sql += c.getId() + ",'";
		sql += c.getCapacidad()+ ",'";
		sql += c.getCierre()+ ",'";
		boolean esp = c.getEspeciales();
		String a;
		if(esp == true)
		{
			a = 1 + "";
		}
		else
		{
			a = 0+ "";
		}
		sql += a+ ",'";
		sql += c.getIdTipoSilleteria()+ ",'";
		sql += c.getIdType()+ ",'";
		sql += c.getNombre()+ ",'";
		
		boolean esp1 = c.getProteccion();
		String a1;
		if(esp1 == true)
		{
			a1 = 1 + "";
		}
		else
		{
			a1 = 0+ "";
		}
		sql += a1+ ")";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	public ArrayList <Espacio> darEspacio() throws SQLException, Exception {
		ArrayList<Espacio> Espacio = new ArrayList<Espacio>();

		String sql = "SELECT * FROM ISIS2304A351720.ESPACIO";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			int id = Integer.parseInt(rs.getString("ID_ESPACIO"));
			String  nombre = (rs.getString("NOMBRE"));
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			boolean especiales;
			if(Integer.parseInt(rs.getString("ESPECIALES")) == 1) 
			{
				especiales = true;
			}
			else
			{
				especiales = false;
			}
			
			
			int idTipo = Integer.parseInt(rs.getString("ID_TIPO_SILLETERIA"));
			boolean  proteccion;
			if(Integer.parseInt(rs.getString("ESPECIALES")) == 1) 
			{
				proteccion = true;
			}
			else
			{
				proteccion = false;
			}
			
			DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			Time Apertura =  new Time(idTipo);
			
			Time Cierre = new Time(idTipo);
			
			
			Espacio.add(new Espacio(id, nombre, 1, capacidad, especiales,Apertura,Cierre,idTipo,proteccion));
		}
		return Espacio;
	}
	
	public void updateEspacio(Espacio c) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.ESPACIO SET ";
		sql += "NOMBRE ='" + c.getNombre() + "',";
		sql += "CAPACIDAD  ='" + c.getCapacidad()+ "',";
		sql += "ID_TIPO_SILLETERIA ='" + c.getIdTipoSilleteria()+ "',";
		sql += "ID_TYPE ='" + c.getIdType()+ "',";
		sql += "APERTURA ='" + c.getApertura()+ "',";
		sql += "CIERRE ='" + c.getCierre()+ "',";
		sql += "ESPECIALES ='" + c.getEspeciales();
		sql += " WHERE id = " + c.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteEspacio(Espacio b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.ESPACIO";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	
	
	
}
