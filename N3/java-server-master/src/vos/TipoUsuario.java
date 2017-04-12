package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoUsuario {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("tipo")
	private String tipo;

	public TipoUsuario(@JsonProperty("id") Integer id, 
			@JsonProperty("tipo")String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}