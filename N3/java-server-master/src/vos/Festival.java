package vos;

import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.annotate.*;


public class Festival {

	@JsonProperty(value="id")
	private Integer id;

	@JsonProperty(value="nombre")
	private String nombre;

	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;


	@JsonProperty(value="fechaFin")
	private Date fechaFin;

	@JsonProperty(value="boletas")
	private ArrayList<Boleta> boleta;

	public Festival(@JsonProperty(value="id") Integer id, 
			@JsonProperty(value="nombre")String nombre, 
			@JsonProperty(value="fechaInicio")Date fechaInicio, 
			@JsonProperty(value="fechaFin")Date fechaFin,@JsonProperty(value="boletas")
	 ArrayList<Boleta> boleta) {
		this.id = id;
		this.nombre = nombre;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.boleta = boleta;
	}


	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Boleta> getBoleta() {
		return boleta;
	}

	public void setBoleta(ArrayList<Boleta> boleta) {
		this. =boleta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
