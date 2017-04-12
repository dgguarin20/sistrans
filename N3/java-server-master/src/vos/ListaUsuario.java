package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaUsuario {


	@JsonProperty(value="usuarios")
	private List<Usuario> usuario;
	
	
	public ListaUsuario( @JsonProperty(value="usuarios")List<Usuario> Usuario){
		this.usuario = Usuario;
	}

	
	public List<Usuario> getUsuario() {
		return  usuario;
	}

	
	public void setUsuario(List<Usuario> Usuario) {
		this.usuario = Usuario;
	}

	
}
