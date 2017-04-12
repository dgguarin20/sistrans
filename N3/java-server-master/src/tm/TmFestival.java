package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFestival;
import vos.Festival;
import vos.ListaFestival;

public class TmFestival extends TM {

	public TmFestival(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	//------------------------------------------------------------------------
	// Festival
	//------------------------------------------------------------------------

	public Festival darFestival(Long id) throws Exception {
		Festival festival;
		DAOFestival daoFestival = new DAOFestival();
		try {
			//////Transacción
			this.conn = darConexion();
			daoFestival.setConn(conn);
			festival = daoFestival.darFestival(id);
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
				daoFestival.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return festival;
	}

	public ListaFestival darFestivales() throws Exception {
		ArrayList<Festival> Festivals;
		DAOFestival daoFestival = new DAOFestival();
		try {
			//////Transacción
			this.conn = darConexion();
			daoFestival.setConn(conn);
			Festivals = daoFestival.darFestivales();
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
				daoFestival.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFestival(Festivals);
	}

	public void addFestival(Festival Festival) throws Exception {
		DAOFestival daoFestival = new DAOFestival();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoFestival.setConn(conn);
			daoFestival.addFestival(Festival);
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
				daoFestival.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addFestivals(ListaFestival Festival) throws Exception {
		DAOFestival daoFestival = new DAOFestival();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFestival.setConn(conn);
			for(Festival bol : Festival.getFestival())
				daoFestival.addFestival(bol);
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
				daoFestival.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateFestival(Festival Festival) throws Exception {
		DAOFestival daoFestival = new DAOFestival();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestival.setConn(conn);
			daoFestival.updateFestival(Festival);

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
				daoFestival.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteFestival(Festival f) throws Exception {
		DAOFestival daoFestival = new DAOFestival();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestival.setConn(conn);
			daoFestival.deleteFestival(f);

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
				daoFestival.cerrarRecursos();
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
