package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFestival;
import dao.DAOFuncion;
import vos.Festival;
import vos.ListaFuncion;
import vos.funcion;

public class TmFuncion extends TM {
	
	public TmFuncion(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	public void addFuncion(funcion Funcion) throws Exception {
		DAOFuncion daoFuncion = new DAOFuncion();	
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.addFuncion(Funcion);
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
				daoFuncion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addFuncions(ListaFuncion Funcion) throws Exception {
		DAOFuncion daoFuncion = new DAOFuncion();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFuncion.setConn(conn);
			for(funcion bol : Funcion.getFuncion())
				daoFuncion.addFuncion(bol);
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
				daoFuncion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	public ListaFuncion darFuncions() throws Exception {
		ArrayList<funcion> Funcions;
		DAOFuncion daoFuncion = new DAOFuncion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			Funcions = daoFuncion.darFuncion();

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
				daoFuncion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFuncion(Funcions);
	}
	
	
	
	
	public void updateFuncion(funcion Funcion) throws Exception {
		DAOFuncion daoFuncion = new DAOFuncion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.updateFuncion(Funcion);

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
				daoFuncion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFuncion(funcion Funcion) throws Exception {
		DAOFuncion daoFuncion = new DAOFuncion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.deleteFuncion(Funcion);

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
				daoFuncion.cerrarRecursos();
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
