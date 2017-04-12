package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.*;

public class Boleta {
	@JsonProperty(value="id")
	private Integer id;
	
	@JsonProperty(value="idFestival")
	private Integer idFestival;
	
	@JsonProperty(value="idLocalidad")
	private Integer idLocalidad;
	
	@JsonProperty(value="silla")
	private String silla;
	
	@JsonProperty(value="descuento")
	private Double descuento;
	
	@JsonProperty(value="fechaCompra")
	private Date fechaCompra;
	
	@JsonProperty(value="asistio")
	private Integer asistio;
	
	@JsonProperty(value="idCliente")
	private Integer idCliente;

	public Boleta(
			@JsonProperty(value="id") Integer id, 
			@JsonProperty(value="idFestival") Integer idFestival, 
			@JsonProperty(value="idLocalidad") Integer idLocalidad, 
			@JsonProperty(value="silla") String silla, 
			@JsonProperty(value="descuento") Double descuento, 
			@JsonProperty(value="fechaCompra") Date fechaCompra,
			@JsonProperty(value="asistio") Integer asistio, 
			@JsonProperty(value="idCliente") Integer idCliente) {
		super();
		this.id = id;
		this.idFestival = idFestival;
		this.idLocalidad = idLocalidad;
		this.silla = silla;
		this.descuento = descuento;
		this.fechaCompra = fechaCompra;
		this.asistio = asistio;
		this.idCliente = idCliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(Integer idFestival) {
		this.idFestival = idFestival;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getSilla() {
		return silla;
	}

	public void setSilla(String silla) {
		this.silla = silla;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getAsistio() {
		return asistio;
	}

	public void setAsistio(Integer asistio) {
		this.asistio = asistio;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
