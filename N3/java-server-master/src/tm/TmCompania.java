package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOCompanio;
import vos.Compania;
import vos.ListaCompania;

public class TmCompania extends TM{

	
	public TmCompania(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	//------------------------------------------------------------------------
	// Compania
	//------------------------------------------------------------------------
/**
	public Compania darCompania(Long id) throws Exception {
		Compania Compania;
		DAOCompanio daoCompania = new DAOCompanio();
		try {
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			Compania = daoCompania.darCompania(id);
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
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return Compania;
	}**/

	public ListaCompania darCompaniaes() throws Exception {
		ArrayList<Compania> Companias;
		DAOCompanio daoCompania = new DAOCompanio();
		try {
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			Companias = daoCompania.darCompania();
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
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaCompania(Companias);
	}

	public void addCompania(Compania Compania) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			daoCompania.addCompania(Compania);
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
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addCompanias(ListaCompania Compania) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoCompania.setConn(conn);
			for(Compania bol : Compania.getCompania())
				daoCompania.addCompania(bol);
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
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateCompania(Compania Compania) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			daoCompania.updateCompania(Compania);

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
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteCompania(Compania f) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			daoCompania.deleteCompania(f);

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
				daoCompania.cerrarRecursos();
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
