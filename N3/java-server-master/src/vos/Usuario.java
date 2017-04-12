package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario {

	@JsonProperty(value="id")
	private Long id;
	
	@JsonProperty(value="nombre")
	private String nombres;
	
	@JsonProperty(value="identificacion")
	private String identificacion;
	
	@JsonProperty(value="correo")
	private String correo;
	
	@JsonProperty(value="clave")
	private String clave;
	
	@JsonProperty(value="idTipoCliente")
	private Integer idTipoCliente;
	
	
	public Usuario(@JsonProperty(value="id") Long id, 
			@JsonProperty(value="nombres") String nombres, 
			@JsonProperty(value="identificacion") String identificacion, 
			@JsonProperty(value="correo") String correo, 
			@JsonProperty(value="clave") String clave, 
			@JsonProperty(value="idTipoCliente") Integer idTipoCliente)
	{
		this.id = id;
		this.nombres = nombres;
		this.identificacion = identificacion;
		this.clave = clave;
		this.idTipoCliente = idTipoCliente;
		this.correo = correo;
		
	}
	
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long i)
	{
		id= i;
		
	}
	public String getCorreo()
	{
		return correo;
	}
	
	public void setCorreo(String i)
	{
		correo= i;
		
	}
	public String getClave()
	{
		return clave;
	}
	
	public void setClave(String i)
	{
		clave= i;
		
	}
	public String getIdentificion()
	{
		return identificacion;
	}
	
	public void setIdentificacion(String i)
	{
		identificacion= i;
		
	}
	
	public Integer getIdTipoCliente()
	{
		return idTipoCliente;
	}
	
	public void setIdTipoCliente(Integer i)
	{
		idTipoCliente= i;
		
	}
	
	public String getNombres()
	{
		return nombres;
	}
	
	public void setNombres(String i)
	{
		nombres= i;
		
	}
	
	
}
