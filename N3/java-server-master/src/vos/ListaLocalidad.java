package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaLocalidad {


	@JsonProperty(value="Localidad")
	private List<Localidad> localidad;
	
	
	public ListaLocalidad( @JsonProperty(value="Localidad")List<Localidad> Localidad){
		this.localidad = Localidad;
	}

	
	public List<Localidad> getLocalidad() {
		return  localidad;
	}

	
	public void setLocalidad(List<Localidad> Localidad) {
		this.localidad = Localidad;
	}

}
