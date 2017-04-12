package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEspecificacion {

	@JsonProperty(value="Especificacion")
	private List<Especificacion> especificacion;
	
	
	public ListaEspecificacion( @JsonProperty(value="Especificacion")List<Especificacion> especificacion){
		this.especificacion = especificacion;
	}

	
	public List<Especificacion> getEspecificacion() {
		return  especificacion;
	}

	
	public void setEspecificacion(List<Especificacion> especificacion) {
		this.especificacion = especificacion;
	}

}
