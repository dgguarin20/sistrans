package vos;

import org.codehaus.jackson.annotate.*;

public class Especificacion {

	
	@JsonProperty(value="id")
	private int id;
	
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	
	public Especificacion(@JsonProperty(value="id")int id, @JsonProperty(value="nombre") String nombre)
	{
	this.id = id;
		this.nombre = nombre;
	
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setId(String i)
	{
		nombre= i;
		
	}
	
	
	
}
