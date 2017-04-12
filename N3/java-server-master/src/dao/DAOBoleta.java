package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vos.Boleta;
import vos.Festival;


public class DAOBoleta {


	
	private ArrayList<Object> recursos;

	
	private Connection conn;

	
	public DAOBoleta() {
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

	/*
	public void addBoleta(Boleta boleto) throws SQLException, Exception {

		String sql = "INSERT INTO BOLETA VALUES (";
		sql += boleto.getId() + ",'";
		sql += boleto.getIdFestival() + "',";
		sql += boleto.getIdLocalidad() + ",";
		sql += boleto.getSilla() + ",";
		sql += boleto.getIdCliente()+ ")";
		
		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	**/
	public ArrayList <Boleta> darBoleta() throws SQLException, Exception {
		ArrayList<Boleta> boletos = new ArrayList<Boleta>();

		String sql = "SELECT * FROM ISIS2304A351720.BOLETA";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			
			Integer id = Integer.parseInt(rs.getString("ID_FESTIVAL"));
			Integer IdLocalidad = Integer.parseInt(rs.getString("ID_LOCALIDAD"));
			Integer IdFestival = Integer.parseInt(rs.getString("ID_FESTIVAL"));
			String sillas = "hola";
			Double descuento = (double) 11;
			Integer asistir = 1;
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			Date fecha = date;
			Integer idCliente = 1;
			boletos.add(new Boleta(id, IdFestival, IdLocalidad, sillas,descuento, fecha,asistir,idCliente));
		}
		return boletos;
	}
	public Boleta darBoleta(Long id) throws SQLException, NumberFormatException, ParseException {
		
		
		String sql = "select * from ISIS2304A351720.BOLETA f where f.id_boleta = '" + id + "'";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		rs.next();
		
		Integer idB = Integer.parseInt(rs.getString("ID_BOLETA"));
		Integer IdLocalidad = Integer.parseInt(rs.getString("ID_LOCALIDAD"));
		Integer IdFestival = Integer.parseInt(rs.getString("ID_FESTIVAL"));
		String sillas = (rs.getString("SILLAS"));
		Double descuento = Double.parseDouble(rs.getString("DESCUENTO"));
		Integer asistir = Integer.parseInt(rs.getString("ASISTIO"));
		Date fecha = rs.getDate("FECHA_COMPRA");
		Integer idCliente = Integer.parseInt(rs.getString("ID_CLIENTE"));
		Boleta retorno = (new Boleta(idB, IdFestival, IdLocalidad, sillas,descuento, fecha,asistir,idCliente));
		return retorno;
	}
	
	/**
	public void updateBoleta(Boleta bol) throws SQLException, Exception {

		String sql = "UPDATE ISIS2304A351720.BOLETA SET ";
		sql += "SILLAS ='" + bol.getsilla() + "',";
		sql += "PRECIO ='" + bol.getPrecio() + "',";
		sql += "ID_FESTIVAL ='" + bol.getIdFestival() + "',";
		sql += "ID_LOCALIDAD ='" + bol.getIdLocalidad() + "',";
		sql += "ID_CLIENTE =" + bol.getidCliente();
		sql += " WHERE id = " + bol.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deleteBoleta(Boleta b) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.BOLETA";
		sql += " WHERE id = " + b.getId();

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	*/
	
}
