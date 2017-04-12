package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaClasificacion {


	@JsonProperty(value="clasificacion")
	private List<Clasificacion> clasificacion;
	
	
	public ListaClasificacion( @JsonProperty(value="clasificacion")List<Clasificacion> clasificacion){
		this.clasificacion = clasificacion;
	}

	
	public List<Clasificacion> getClasificacion() {
		return  clasificacion;
	}

	
	public void setClasificacion(List<Clasificacion> clasificacion) {
		this.clasificacion = clasificacion;
	}

}
