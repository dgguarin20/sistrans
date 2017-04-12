package tm;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOUsuario;
import vos.ListaUsuario;
import vos.Usuario;

public class TmUsuario extends TM {
	
	public TmUsuario(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}

	public void addUsuario(Usuario Usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();	
		try {
			//////Transacción
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.addUsuario(Usuario);
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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public Usuario darUsuario(Long id) throws Exception {
		Usuario usuario;
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			usuario = daoUsuario.darUsuario(id);

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return usuario;
	}

	public ListaUsuario darUsuarios() throws Exception {
		ArrayList<Usuario> Usuarios;
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			Usuarios = daoUsuario.darUsuarios();

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuario(Usuarios);
	}

	public void updateUsuario(Usuario Usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.updateUsuario(Usuario);

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
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deleteUsuario(Usuario Usuario) throws Exception {
		DAOUsuario daoUsuario = new DAOUsuario();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.deleteUsuario(Usuario);

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
				daoUsuario.cerrarRecursos();
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
