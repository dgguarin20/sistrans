package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEspacio {


	@JsonProperty(value="Espacio")
	private List<Espacio> espacio;
	
	
	public ListaEspacio( @JsonProperty(value="Espacio")List<Espacio> espacio){
		this.espacio = espacio;
	}

	
	public List<Espacio> getEspacio() {
		return  espacio;
	}

	
	public void setEspacio(List<Espacio> espacio) {
		this.espacio = espacio;
	}

	
	
}
