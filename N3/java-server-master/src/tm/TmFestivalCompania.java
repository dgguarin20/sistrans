package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFestivalCompania;
import vos.ListaFestivalCompania;
import vos.FestivalCompania;

public class TmFestivalCompania extends TM {

	public TmFestivalCompania(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	public void addFestivalCompania(FestivalCompania FestivalCompania) throws Exception {
		DAOFestivalCompania daoFestivalCompania = new DAOFestivalCompania();	
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestivalCompania.setConn(conn);
			daoFestivalCompania.addFestivalCompania(FestivalCompania);
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
				daoFestivalCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void addFestivalCompanias(ListaFestivalCompania FestivalCompania) throws Exception {
		DAOFestivalCompania daoFestivalCompania = new DAOFestivalCompania();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoFestivalCompania.setConn(conn);
			for(FestivalCompania bol : FestivalCompania.getFestivalCompania())
				daoFestivalCompania.addFestivalCompania(bol);
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
				daoFestivalCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	public ListaFestivalCompania darFestivalCompanias() throws Exception {
		ArrayList<FestivalCompania> FestivalCompanias;
		DAOFestivalCompania daoFestivalCompania = new DAOFestivalCompania();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestivalCompania.setConn(conn);
			FestivalCompanias = daoFestivalCompania.darFestivalCompania();

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
				daoFestivalCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFestivalCompania(FestivalCompanias);
	}
	
	
	
	
	public void updateFestivalCompania(FestivalCompania FestivalCompania) throws Exception {
		DAOFestivalCompania daoFestivalCompania = new DAOFestivalCompania();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestivalCompania.setConn(conn);
			daoFestivalCompania.updateFestivalC(FestivalCompania);

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
				daoFestivalCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteFestivalCompania(FestivalCompania FestivalCompania) throws Exception {
		DAOFestivalCompania daoFestivalCompania = new DAOFestivalCompania();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFestivalCompania.setConn(conn);
			daoFestivalCompania.deleteFestivalC(FestivalCompania);

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
				daoFestivalCompania.cerrarRecursos();
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
