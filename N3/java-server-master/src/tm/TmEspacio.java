package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOEspacio;
import dao.DAOFestival;
import vos.Espacio;
import vos.Festival;
import vos.ListaEspacio;
import vos.ListaFestival;

public class TmEspacio extends TM {

	public TmEspacio(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}


	public ListaEspacio darEspacioes() throws Exception {
		ArrayList<Espacio> Espacios;
		DAOEspacio daoEspacio = new DAOEspacio();
		try {
			//////Transacción
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			Espacios = daoEspacio.darEspacio();
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
				daoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaEspacio(Espacios);
	}

	public void addEspacio(Espacio Espacio) throws Exception {
		DAOEspacio daoEspacio = new DAOEspacio();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			daoEspacio.addEspacio(Espacio);
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
				daoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addEspacios(ListaEspacio Espacio) throws Exception {
		DAOEspacio daoEspacio = new DAOEspacio();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoEspacio.setConn(conn);
			for(Espacio bol : Espacio.getEspacio())
				daoEspacio.addEspacio(bol);
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
				daoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateEspacio(Espacio Espacio) throws Exception {
		DAOEspacio daoEspacio = new DAOEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			daoEspacio.updateEspacio(Espacio);

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
				daoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteEspacio(Espacio f) throws Exception {
		DAOEspacio daoEspacio = new DAOEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			daoEspacio.deleteEspacio(f);

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
				daoEspacio.cerrarRecursos();
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
