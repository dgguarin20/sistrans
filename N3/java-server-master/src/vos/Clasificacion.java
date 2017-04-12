package vos;

import org.codehaus.jackson.annotate.*;

public class Clasificacion {

	
	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="clasificacion")
	private String clasificacion;
	
	
	
	public Clasificacion(@JsonProperty(value="id") int id, @JsonProperty(value="clasificacion") String clasificacion)
	{
		this.id = id;
		this.clasificacion = clasificacion;
		
	}
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public String getClasificacion()
	{
		return clasificacion;
	}
	
	public void setClasificacion(String s)
	{
		clasificacion = s;
		
	}
	
}
