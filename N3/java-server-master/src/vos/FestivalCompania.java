package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class FestivalCompania {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="idCompania")
	private int idCompania;
	
	
	@JsonProperty(value="llegada")
	private Date llegada;
	
	
	@JsonProperty(value="Salida")
	private Date salida;
	
	
	public FestivalCompania(@JsonProperty(value="id") int id, @JsonProperty(value="idCompania")int idCompania,@JsonProperty(value="llegada")Date llegada,@JsonProperty(value="Salida")Date salida)
	{
		this.id = id;
		this.idCompania = idCompania;
		this.llegada = llegada;
		this.salida = salida;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public int getIdCompania()
	{
		return idCompania;
	}
	
	public void setIdCompania(int i)
	{
		idCompania= i;
		
	}
	
	public Date getLlegada()
	{
		return llegada;
	}
	public void setLlegada(Date f)
	{
		llegada = f;
	}
	
	public Date getSalida()
	{
		return salida;
	}
	public void setSalida(Date f)
	{
		salida = f;
	}
	
	
}
