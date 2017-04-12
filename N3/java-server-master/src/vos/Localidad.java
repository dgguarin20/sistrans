package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Localidad {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="localidad")
	private String localidad;
	
	
	@JsonProperty(value="numerada")
	private boolean numerada;
	
	@JsonProperty(value="capidad")
	private int capacidad;
	
	@JsonProperty(value="precio")
	private double precio;
	
	@JsonProperty(value="idFuncion")
	private int idFuncion;
	
	
	public Localidad(@JsonProperty(value="id")int id, @JsonProperty(value="localidad")String localidad,
			@JsonProperty(value="numerada")boolean numerada,@JsonProperty(value="capidad") int capacidad,
			@JsonProperty(value="precio")double precio,@JsonProperty(value="idFuncion")int idFuncion
			)
	{
		this.id = id;
		this.localidad = localidad;
		this.numerada = numerada;
		this.capacidad = capacidad;
		this.precio = precio;
		this.idFuncion = idFuncion;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public String getLocalidad()
	{
		return localidad;
	}
	
	public void setLocalidad(String i)
	{
		localidad= i;
		
	}
	
	public boolean getNumerada()
	{
		return numerada;
	}
	
	public void setNumerada(boolean i)
	{
		numerada= i;
		
	}
	public int getCapacidad()
	{
		return capacidad;
	}
	
	public void setCapacidad(int i)
	{
		capacidad= i;
		
	}
	public double getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(double i)
	{
		precio= i;
		
	}
	
	
	
	
	
	public int getIdFuncion()
	{
		return idFuncion;
	}
	
	public void setIdFuncion(int i)
	{
		idFuncion= i;
		
	}
	
	
	
}
