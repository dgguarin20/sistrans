package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBoleta;
import dao.DAOFestival;
import vos.Boleta;
import vos.Festival;
import vos.ListaBoleta;
import vos.ListaFestival;

public class TMBoleta extends TM{

	public TMBoleta(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	public Boleta darBoleta(Long id) throws Exception {
		Boleta Boleta;
		DAOBoleta daoBoleta = new DAOBoleta();
		try {
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			Boleta = daoBoleta.darBoleta(id);
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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return Boleta;
	}


	

	public ListaBoleta darBoletas() throws Exception {
		ArrayList<Boleta> Boletas;
		DAOBoleta daoBoleta = new DAOBoleta();
		try {
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			Boletas = daoBoleta.darBoleta();
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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBoleta(Boletas);
	}

	/**public void addBoleta(Boleta Boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.addBoleta(Boleta);
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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addBoletas(ListaBoleta Boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBoleta.setConn(conn);
			for(Boleta bol : Boleta.getBoleta())
				daoBoleta.addBoleta(bol);
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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateBoleta(Boleta Boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.updateBoleta(Boleta);

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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteBoleta(Boleta f) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.deleteBoleta(f);

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
				daoBoleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	
	**/
	
}
