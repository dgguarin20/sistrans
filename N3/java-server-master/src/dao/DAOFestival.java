package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vos.Festival;

public class DAOFestival {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOFestival() {
		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() {
		for(Object ob : recursos) {
			if (ob instanceof PreparedStatement)
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


	public void addFestival(Festival c) throws SQLException, Exception {
		String sql = "INSERT INTO ISIS2304A351720.FESTIVAL (NOMBRE, FECHA_INIC, FECHA_FIN) VALUES (";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sql += "'"+c.getNombre()+ "', ";
		sql += "TO_DATE('"+sdf.format(c.getFechaInicio())+"', 'YYYY-MM-DD HH24:MI:SS'), ";
		sql += "TO_DATE('"+sdf.format(c.getFechaFin())+"', 'YYYY-MM-DD HH24:MI:SS'))";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public Festival darFestival(Long id) throws SQLException, NumberFormatException, ParseException {
		String sql = "select * from ISIS2304A351720.FESTIVAL f where f.id_festival = '" + id + "'";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		rs.next();
		DAOBoleta dao = new DAOBoleta();
		return new Festival(
				Integer.parseInt(rs.getString("ID_FESTIVAL")),
				rs.getString("NOMBRE"),
				rs.getDate("FECHA_INIC"),
				rs.getDate("FECHA_FIN")),
				dao.darBoleta();
	}

	public ArrayList <Festival> darFestivales() throws SQLException, Exception {
		ArrayList<Festival> festivales = new ArrayList<Festival>();
		String sql = "SELECT * FROM ISIS2304A351720.FESTIVAL";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			festivales.add(new Festival(
					Integer.parseInt(rs.getString("ID_FESTIVAL")),
					rs.getString("NOMBRE"),
					rs.getDate("FECHA_INIC"),
					rs.getDate("FECHA_FIN")));
		}
		return festivales;
	}

	public void updateFestival(Festival c) throws SQLException, Exception {
		String sql = "UPDATE ISIS2304A351720.FESTIVAL SET ";
		boolean name = c.getNombre() == null || c.getNombre().isEmpty();
		boolean ini = c.getFechaInicio() == null;
		boolean fin = c.getFechaFin() == null;
		if (!name)
			sql += "NOMBRE = '" + c.getNombre()+"'";
		if  (!ini) {
			if (!name)
				sql += ", ";
			sql += "FECHA_INIC = '" + c.getFechaInicio()+"'";
		}
		if (!fin) {
			if (!name || !fin)
				sql += ", ";
			sql += "FECHA_FIN = '" + c.getFechaFin()+"'";
		}
		sql += " WHERE id_festival = '" + c.getId() + "'";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public void deleteFestival(Festival f) throws SQLException, Exception {

		String sql = "DELETE FROM ISIS2304A351720.FESTIVAL";
		sql += " WHERE id_festival = '" + f.getId() + "'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
