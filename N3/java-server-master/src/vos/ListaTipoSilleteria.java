package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaTipoSilleteria {

	@JsonProperty(value="TipoSilleteria")
	private List<TipoSilleteria> tipoSilleteria;
	
	
	public ListaTipoSilleteria( @JsonProperty(value="TipoSilleteria")List<TipoSilleteria> TipoSilleteria){
		this.tipoSilleteria = TipoSilleteria;
	}

	
	public List<TipoSilleteria> getTipoSilleteria() {
		return  tipoSilleteria;
	}

	
	public void setTipoSilleteria(List<TipoSilleteria> TipoSilleteria) {
		this.tipoSilleteria = TipoSilleteria;
	}

}
