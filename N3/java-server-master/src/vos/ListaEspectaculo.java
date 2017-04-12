package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaEspectaculo {


	@JsonProperty(value="Espectaculo")
	private List<Espectaculo> espectaculo;
	
	
	public ListaEspectaculo( @JsonProperty(value="Espectaculo")List<Espectaculo> espectaculo){
		this.espectaculo = espectaculo;
	}

	
	public List<Espectaculo> getEspectaculo() {
		return  espectaculo;
	}

	
	public void setEspectaculo(List<Espectaculo> espectaculo) {
		this.espectaculo = espectaculo;
	}

	
}
