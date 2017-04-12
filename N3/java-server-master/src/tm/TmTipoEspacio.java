package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOTipoEspacio;
import vos.TipoEspacio;
import vos.ListaTipoEspacio;

public class TmTipoEspacio extends TM {
	public TmTipoEspacio(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	//------------------------------------------------------------------------
	// Festival
	//------------------------------------------------------------------------

	/**public TipoEspacio darTipoEspacio(Long id) throws Exception {
		TipoEspacio TipoEspacio;
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			TipoEspacio = daoTipoEspacio.darTipoEspacio(id);
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
				daoTipoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return TipoEspacio;
	}**/

	public ListaTipoEspacio darTipoEspacioes() throws Exception {
		ArrayList<TipoEspacio> TipoEspacios;
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			TipoEspacios = daoTipoEspacio.darTipoEspacio();
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
				daoTipoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaTipoEspacio(TipoEspacios);
	}

	public void addTipoEspacio(TipoEspacio TipoEspacio) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			daoTipoEspacio.addTipoEspacio(TipoEspacio);
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
				daoTipoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addTipoEspacios(ListaTipoEspacio TipoEspacio) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoTipoEspacio.setConn(conn);
			for(TipoEspacio bol : TipoEspacio.getTipoEspacio())
				daoTipoEspacio.addTipoEspacio(bol);
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
				daoTipoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateTipoEspacio(TipoEspacio TipoEspacio) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			daoTipoEspacio.updateTipoEspacio(TipoEspacio);

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
				daoTipoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteTipoEspacio(TipoEspacio f) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			daoTipoEspacio.deleteTipoEspacio(f);

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
				daoTipoEspacio.cerrarRecursos();
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
