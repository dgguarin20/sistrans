package vos;


import org.codehaus.jackson.annotate.*;


public class Espectaculo {

	@JsonProperty(value="id")
	private int id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="duracion")
	private int duracion;
	
	@JsonProperty(value="intermedio")
	private boolean intermedio;
	
	@JsonProperty(value="idioma")
	private String idioma;
	
	
	@JsonProperty(value="traduccion")
	private boolean traduccion;
	
	@JsonProperty(value="synopsis")
	private String synopsis;
	
	
	@JsonProperty(value="costoRealizacion")
	private double costoRealizacion;
	
	
	@JsonProperty(value="publicoObjetivo")
	private String publicoObjetivo;
	
	@JsonProperty(value="publicEspectador")
	private boolean publicEspectador;

	public Espectaculo(@JsonProperty(value="id")int id, @JsonProperty(value="nombre")String nombre, @JsonProperty(value="duracion")int duracion, @JsonProperty(value="intermedio")boolean intermedio, @JsonProperty(value="idioma")String idioma, @JsonProperty(value="traduccion")boolean traduccion, @JsonProperty(value="synopsis")String synopsis, @JsonProperty(value="costoRealizacion")double costoRealizacion, @JsonProperty(value="publicoObjetivo")String publicoObjetivo,@JsonProperty(value="publicEspectador")boolean publicEspectador)
	{
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.intermedio = intermedio;
		this.idioma = idioma;
		this.synopsis = synopsis;
		this.costoRealizacion = costoRealizacion;
		this.publicoObjetivo = publicoObjetivo;
		this.publicEspectador = publicEspectador;
		
		
	}
	
	
	
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int i)
	{
		id= i;
		
	}
	public String getSynopsis()
	{
		return synopsis;
	}
	public void setsynopsis(String Synopsi)
	{
		synopsis = Synopsi;
	}
	public double getCostoRealizacion()
	{
		return costoRealizacion;
	}
	public void setCostoRealizacion(double c)
	{
		costoRealizacion = c;
	}
	
	public String getPublicoObjetivo()
	{
		return publicoObjetivo;
	}
	public void setPublicObjetivo(String p)
	{
		publicoObjetivo = p;
	}
	public boolean getPublicoEspectador()
	{
		return publicEspectador;
	}
	public void setPublicoEspectador(boolean e)
	{
		publicEspectador = e;
	}
	public int getDuracion()
	{
		return duracion;
	}
	public void setDuracion(int d)
	
	{
		duracion = d;
	}
	public boolean getIntermedio()
	{
		return intermedio;
	}
	public void setIntermedio(boolean i)
	{
		intermedio = i;
	}
	public String getIdioma()
	{
		return idioma;
	}
	public void setIdioma(String idio)
	{
		idioma = idio;
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
