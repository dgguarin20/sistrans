package vos;

import java.sql.Time;

import org.codehaus.jackson.annotate.*;

public class Espacio {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="idType")
	private int idType;
	
	@JsonProperty(value="Capacidad")
	private int capacidad;
	
	@JsonProperty(value="Especiales")
	private Boolean especiales;
	
	
	@JsonProperty(value="Apertura")
	private Time Apertura;
	
	
	
	@JsonProperty(value="Cierre")
	private Time Cierre;
	
	
	@JsonProperty(value="id_Tipo_Silleteria")
	private int idTipoSilleteria;
	
	
	
	@JsonProperty(value="Proteccion")
	private Boolean proteccion;
	
	
	public Espacio (@JsonProperty(value="id")int id,
			@JsonProperty(value="nombre")
	String nombre,@JsonProperty(value="idType")int idType,@JsonProperty(value="Capacidad")int capacidad, @JsonProperty(value="Especiales")Boolean especiales,@JsonProperty(value="Apertura")Time Apertura,@JsonProperty(value="Cierre")Time Cierre,@JsonProperty(value="id_Tipo_Silleteria")int idTipoSilleteria, @JsonProperty(value="Proteccion")Boolean proteccion)
	{	
		this.nombre = nombre;
		this.id = id;
		this.idType= idType;
		this.capacidad = capacidad;
		this.especiales = especiales;
		this.Apertura = Apertura;
		this.Cierre = Cierre;
		this.idTipoSilleteria = idTipoSilleteria;
		this.proteccion = proteccion;
		
		
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
	
	public void setNombre(String i)
	{
		nombre= i;
		
	}
	
	public int getIdType()
	{
		return idType;
	}
	
	public void setIdType(int i)
	{
		idType= i;
		
	}
	
	public int getIdTipoSilleteria()
	{
		return idTipoSilleteria;
	}
	
	public void setIdTipoSilleteria(int i)
	{
		idTipoSilleteria= i;
		
	}
	
	public int getCapacidad()
	{
		return capacidad;
	}
	
	public void setCapacidad(int i)
	{
		capacidad= i;
		
	}
	
	public Boolean getEspeciales()
	{
		return especiales;
	}
	
	public void setEspeciales(Boolean i)
	{
		especiales= i;
		
	}
	public Boolean getProteccion()
	{
		return proteccion;
	}
	
	public void setProteccion(Boolean i)
	{
		proteccion= i;
		
	}
	public Time getApertura()
	{
		return Apertura;
	}
	public void setApertura(Time i)
	{
		Apertura = i;
	}
	public Time getCierre()
	{
		return Cierre;
	}
	public void setCierre(Time i)
	{
		Cierre = i;
	}
	
	
}
