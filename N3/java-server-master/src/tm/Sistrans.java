package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.*;

import vos.*;




public class Sistrans {

	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";
	private  String connectionDataPath;
	private String user;
	private String password;
	private String url;
	private String driver;
	private Connection conn;

	public Sistrans(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}
	/*
	public ListaBoleta darBoletas() throws Exception {
		ArrayList<Boleta> boletas;
		DAOBoleta daoboleta = new DAOBoleta();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoboleta.setConn(conn);
			boletas = daoboleta.darBoleta();

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
				daoboleta.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBoleta(boletas);
	}


	public void addBoleta(Boleta boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();	
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.addBoleta(boleta);
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

	public void addBoletas(ListaBoleta boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoBoleta.setConn(conn);
			for(Boleta bol : boleta.getBoleta())
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

	public void updateBoleta(Boleta boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.updateBoleta(boleta);

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

	public void deleteBoleta(Boleta Boleta) throws Exception {
		DAOBoleta daoBoleta = new DAOBoleta();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoleta.setConn(conn);
			daoBoleta.deleteBoleta(Boleta);

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
	*/
	
	public ListaClasificacion darClasificacions() throws Exception {
		ArrayList<Clasificacion> Clasificacions;
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try 
		{
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

	public void addClasificacion(Clasificacion clasificacion) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();	
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			daoClasificacion.addClasificacion(clasificacion);
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

	public void deleteClasificacion(Clasificacion Clasificacion) throws Exception {
		DAOClasificacion daoClasificacion = new DAOClasificacion();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoClasificacion.setConn(conn);
			daoClasificacion.deleteClasificacion(Clasificacion);

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
	public ListaCompania darCompania() throws Exception {
		ArrayList<Compania> Compania;
		DAOCompanio daoCompania = new DAOCompanio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			Compania = daoCompania.darCompania();

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
		return new ListaCompania(Compania);
	}

	public void addCompania(Compania Compania) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();	
		try 
		{
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

	public void deleteCompania(Compania Compania) throws Exception {
		DAOCompanio daoCompania = new DAOCompanio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoCompania.setConn(conn);
			daoCompania.deleteCompania(Compania);

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
	public ListaEspacio darEspacios() throws Exception {
		ArrayList<Espacio> Espacios;
		DAOEspacio daoEspacio = new DAOEspacio();
		try 
		{
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
		try 
		{
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

	public void deleteEspacio(Espacio Espacio) throws Exception {
		DAOEspacio daoEspacio = new DAOEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			daoEspacio.deleteEspacio(Espacio);

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

	//------------------------------------------------------------------------
	// Festival
	//------------------------------------------------------------------------

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


	public void addTipoEspacio(TipoEspacio TipoEspacio) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();	
		try 
		{
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

	public ListaTipoEspacio darTipoEspacios() throws Exception {
		ArrayList<TipoEspacio> TipoEspacios;
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try 
		{
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

	public void deleteTipoEspacio(TipoEspacio TipoEspacio) throws Exception {
		DAOTipoEspacio daoTipoEspacio = new DAOTipoEspacio();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoEspacio.setConn(conn);
			daoTipoEspacio.deleteTipoEspacio(TipoEspacio);

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


	public void addTipoSilleteria(TipoSilleteria TipoSilleteria) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();	
		try 
		{
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

	public ListaTipoSilleteria darTipoSilleterias() throws Exception {
		ArrayList<TipoSilleteria> TipoSilleterias;
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try 
		{
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

	public void deleteTipoSilleteria(TipoSilleteria TipoSilleteria) throws Exception {
		DAOTipoSilleteria daoTipoSilleteria = new DAOTipoSilleteria();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoTipoSilleteria.setConn(conn);
			daoTipoSilleteria.deleteTipoSilleteria(TipoSilleteria);

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
