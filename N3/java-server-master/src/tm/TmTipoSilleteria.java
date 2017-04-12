package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOTipoSilleteria;
import vos.TipoSilleteria;
import vos.ListaTipoSilleteria;

public class TmTipoSilleteria extends TM {
	public TmTipoSilleteria(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	//------------------------------------------------------------------------
	// Festival
	//------------------------------------------------------------------------

	/**public TipoSilleteria darTipoSilleteria(Long id) throws Exception {
		TipoSilleteria TipoSilleteria;
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			TipoSilleteria = daoTipoSilleteria.darTipoSilleteria(id);
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
				daoTipoSilleteria.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return TipoSilleteria;
	}**/

	public ListaTipoSilleteria darTipoSilleteriaes() throws Exception {
		ArrayList<TipoSilleteria> TipoSilleterias;
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			TipoSilleterias = daoTipoSilleteria.darTipoSilleteria();
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
				daoTipoSilleteria.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaTipoSilleteria(TipoSilleterias);
	}

	public void addTipoSilleteria(TipoSilleteria TipoSilleteria) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			daoTipoSilleteria.addTipoSilleteria(TipoSilleteria);
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
				daoTipoSilleteria.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addTipoSilleterias(ListaTipoSilleteria TipoSilleteria) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoTipoSilleteria.setConn(conn);
			for(TipoSilleteria bol : TipoSilleteria.getTipoSilleteria())
				daoTipoSilleteria.addTipoSilleteria(bol);
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
				daoTipoSilleteria.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateTipoSilleteria(TipoSilleteria TipoSilleteria) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			daoTipoSilleteria.updateTipoSilleteria(TipoSilleteria);

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
				daoTipoSilleteria.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteTipoSilleteria(TipoSilleteria f) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			daoTipoSilleteria.deleteTipoSilleteria(f);

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
				daoTipoSilleteria.cerrarRecursos();
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
