package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoEspacio {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="Tipo_Espacio")
	private String tipoEspacio;
	
	

	
	public TipoEspacio(	@JsonProperty(value="id")
	int id,
	@JsonProperty(value="Tipo_Espacio")
	String tipoEspacio)
	{
		this.id = id;
		this.tipoEspacio = tipoEspacio;
		
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	
	public int getTipoEspacio()
	{
		return id;
	}
	
	public void setTipoEspacio(String i)
	{
		tipoEspacio= i;
		
	}
}
