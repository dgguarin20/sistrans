package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaCompania {

	@JsonProperty(value="Compania")
	private List<Compania> compania;
	
	
	public ListaCompania( @JsonProperty(value="Compania")List<Compania> compania){
		this.compania = compania;
	}

	
	public List<Compania> getCompania() {
		return  compania;
	}

	
	public void setCompania(List<Compania> compania) {
		this.compania = compania;
	}


}
