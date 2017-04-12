package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOLocalidad;
import vos.ListaLocalidad;
import vos.Localidad;

public class TmLocalidad extends TM {

	public TmLocalidad(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	
	
	public void addLocalidad(Localidad Localidad) throws Exception {
		DAOLocalidad daoLocalidad = new DAOLocalidad();	
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoLocalidad.setConn(conn);
			daoLocalidad.addLocalidad(Localidad);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoLocalidad.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addLocalidads(ListaLocalidad Localidad) throws Exception {
		DAOLocalidad daoLocalidad = new DAOLocalidad();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoLocalidad.setConn(conn);
			for(Localidad bol : Localidad.getLocalidad())
				daoLocalidad.addLocalidad(bol);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoLocalidad.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	public ListaLocalidad darLocalidads() throws Exception {
		ArrayList<Localidad> Localidads;
		DAOLocalidad daoLocalidad = new DAOLocalidad();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoLocalidad.setConn(conn);
			Localidads = daoLocalidad.darLocalidad();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoLocalidad.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaLocalidad(Localidads);
	}
	
	public void updateLocalidad(Localidad Localidad) throws Exception {
		DAOLocalidad daoLocalidad = new DAOLocalidad();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoLocalidad.setConn(conn);
			daoLocalidad.updateLocalidad(Localidad);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoLocalidad.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteLocalidad(Localidad Localidad) throws Exception {
		DAOLocalidad daoLocalidad = new DAOLocalidad();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoLocalidad.setConn(conn);
			daoLocalidad.deleteLocalidad(Localidad);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoLocalidad.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
}
