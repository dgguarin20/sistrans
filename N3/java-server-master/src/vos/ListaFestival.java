package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFestival {

	@JsonProperty(value="festival")
	private List<Festival> festival;
	
	
	public ListaFestival(@JsonProperty(value="festival") List<Festival> festival) {
		this.festival = festival;
	}

	
	public List<Festival> getFestival() {
		return festival;
	}

	
	public void setFestival(List<Festival> Festival) {
		this.festival = Festival;
	}
	public Long darid(int i)
	{
		return festival.get(i).getId().longValue();
	}
}
