package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class funcion {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="idEspectaculo")
	private int idEspectaculo;
	
	@JsonProperty(value="idEspacio")
	private int idEspacio;
	
	@JsonProperty(value="fecha")
	private Date fecha;
	
	@JsonProperty(value="terminadaBien")
	private boolean terminadaBien;
	
	
	public funcion(@JsonProperty(value="id")
	int id,
	@JsonProperty(value="idEspectaculo")
	int idEspectaculo,
	@JsonProperty(value="idEspacio")
	int idEspacio,
	@JsonProperty(value="fecha")
	Date fecha,
	@JsonProperty(value="terminadaBien")
	boolean terminadaBien)
	{
		this.id = id;
		this.idEspectaculo = idEspectaculo;
		this.idEspacio = idEspacio;
		this.fecha = fecha;
		this.terminadaBien = terminadaBien;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	
	public boolean getTerminadaBien()
	{
		return terminadaBien;
	}
	public void setTerminadaBien(boolean b)
	{
		terminadaBien = b;
	}
	
	
	public int getIdEspacio()
	{
		return idEspacio;
	}
	
	public void setIdEspacio(int i)
	{
		idEspacio= i;
		
	}
	public int getIdEspectaculo()
	{
		return idEspectaculo;
	}
	
	public void setIdEspectaculo(int i)
	{
		idEspectaculo= i;
		
	}
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date f)
	{
		fecha = f;
		
	}
	
	
}
