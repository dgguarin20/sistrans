package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TipoSilleteria {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="Tipo")
	private String tipo;
	
	
	public TipoSilleteria(@JsonProperty(value="id")
	 int id,
	@JsonProperty(value="Tipo")
	String tipo)
	{
		this.id = id;
		this.tipo = tipo;
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo(String i)
	{
		tipo=i;
	}
	
	
}
