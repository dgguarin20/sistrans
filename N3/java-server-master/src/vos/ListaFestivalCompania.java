package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFestivalCompania {

	@JsonProperty(value="FestivalCompania")
	private List<FestivalCompania> festivalCompania;
	
	
	public ListaFestivalCompania( @JsonProperty(value="FestivalCompania")List<FestivalCompania> FestivalCompania){
		this.festivalCompania = FestivalCompania;
	}

	
	public List<FestivalCompania> getFestivalCompania() {
		return  festivalCompania;
	}

	
	public void setFestivalCompania(List<FestivalCompania> FestivalCompania) {
		this.festivalCompania = FestivalCompania;
	}

}
