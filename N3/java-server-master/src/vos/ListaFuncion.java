package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFuncion {

	

	@JsonProperty(value="Funcion")
	private List<funcion> funcion;
	
	
	public ListaFuncion( @JsonProperty(value="Funcion")List<funcion> Funcion){
		this.funcion = Funcion;
	}

	
	public List<funcion> getFuncion() {
		return  funcion;
	}

	
	public void setFuncion(List<funcion> Funcion) {
		this.funcion = Funcion;
	}

}
