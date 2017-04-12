package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaTipoEspacio {


	@JsonProperty(value="TipoEspacio")
	private List<TipoEspacio> tipoEspacio;
	
	
	public ListaTipoEspacio( @JsonProperty(value="TipoEspacio")List<TipoEspacio> TipoEspacio){
		this.tipoEspacio = TipoEspacio;
	}

	
	public List<TipoEspacio> getTipoEspacio() {
		return  tipoEspacio;
	}

	
	public void setTipoEspacio(List<TipoEspacio> TipoEspacio) {
		this.tipoEspacio = TipoEspacio;
	}

}
