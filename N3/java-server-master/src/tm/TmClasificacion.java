package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOClasificacion;
import dao.DAOFestival;
import vos.Clasificacion;
import vos.Festival;
import vos.ListaClasificacion;
import vos.ListaFestival;

public class TmClasificacion extends TM{

	public TmClasificacion(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}
	
	//------------------------------------------------------------------------
	// Festival
	//------------------------------------------------------------------------

	/**public Clasificacion darClasificacion(Long id) throws Exception {
		Clasificacion Clasificacion;
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try {
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			Clasificacion = daoClasificacion.darClasificacion(id);
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
				daoClasificacion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return Clasificacion;
	}**/

	public ListaClasificacion darClasificaciones() throws Exception {
		ArrayList<Clasificacion> Clasificacions;
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try {
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			Clasificacions = daoClasificacion.darClasificacion();
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
				daoClasificacion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaClasificacion(Clasificacions);
	}

	public void addClasificacion(Clasificacion Clasificacion) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			daoClasificacion.addClasificacion(Clasificacion);
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
				daoClasificacion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void addClasificacions(ListaClasificacion Clasificacion) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoClasificacion.setConn(conn);
			for(Clasificacion bol : Clasificacion.getClasificacion())
				daoClasificacion.addClasificacion(bol);
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
				daoClasificacion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updateClasificacion(Clasificacion Clasificacion) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			daoClasificacion.updateClasificacion(Clasificacion);

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
				daoClasificacion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteClasificacion(Clasificacion f) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			daoClasificacion.deleteClasificacion(f);

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
				daoClasificacion.cerrarRecursos();
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
