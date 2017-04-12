package vos;


import org.codehaus.jackson.annotate.*;

public class Compania {

	@JsonProperty(value="id")
	private Integer id;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	
	@JsonProperty(value="SitioWeb")
	private String sitioWeb;
	
	
	@JsonProperty(value="Representante")
	private String representante;
	
	
	@JsonProperty(value="pais")
	private String pais;
	
	public Compania(@JsonProperty(value="id")Integer id, @JsonProperty(value="nombre") String nombre, @JsonProperty(value="SitioWeb")String sitioWeb, @JsonProperty(value="Representante")String representante, @JsonProperty(value="pais")String pais)
	{
		this.id = id;
		this.nombre = nombre;
		this.sitioWeb = sitioWeb;
		this.representante = representante;
		this.pais = pais;
		
	}
	
	
	
	public Integer getId()
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
	public String getSitioWeb()
	{
		return sitioWeb;
	}
	
	public void setSitioWeb(String i)
	{
		sitioWeb= i;
		
	}
	public String getPais()
	{
		return pais;
	}
	
	public void setPais(String i)
	{
		pais= i;
		
	}
	public String getRepresentante()
	{
		return representante;
	}
	
	public void setRepresentante(String i)
	{
		representante= i;
		
	}
	
	
	
	
}
