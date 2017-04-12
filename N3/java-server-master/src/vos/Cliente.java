package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente {
	
	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="usuario")
	private Usuario usuario;

	public Cliente(@JsonProperty(value="id") Long id, 
			@JsonProperty(value="usuario") Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
