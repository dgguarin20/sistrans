package rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.Sistrans;

import vos.ListaBoleta;

import vos.*;

public class SistransServices {

	@Context
	private ServletContext context;
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	
	/*@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getBoleta() {
		Sistrans tm = new Sistrans(getPath());
		ListaBoleta boleta;
		try {
			boleta = tm.darBoletas();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}
	
	@PUT
	@Path("/boletas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBoleta(ListaBoleta boleta) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addBoletas(boleta);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(boleta).build();
	}*/
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClasificacion() {
		Sistrans tm = new Sistrans(getPath());
		ListaClasificacion Clasificacion;
		try {
			Clasificacion = tm.darClasificacions();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Clasificacion).build();
	}
	
	@PUT
	@Path("/clasificaciones")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClasificacion(ListaClasificacion Clasificacion) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addClasificacions(Clasificacion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Clasificacion).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompania() {
		Sistrans tm = new Sistrans(getPath());
		ListaCompania Compania;
		try {
			Compania = tm.darCompania();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Compania).build();
	}
	
	@PUT
	@Path("/companias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompania(ListaCompania Compania) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addCompanias(Compania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Compania).build();
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEspacio() {
		Sistrans tm = new Sistrans(getPath());
		ListaEspacio Espacio;
		try {
			Espacio = tm.darEspacios();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Espacio).build();
	}
	
	@PUT
	@Path("/espacios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEspacio(ListaEspacio Espacio) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addEspacios(Espacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Espacio).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestivalCompania() {
		Sistrans tm = new Sistrans(getPath());
		ListaFestivalCompania FestivalCompania;
		try {
			FestivalCompania = tm.darFestivalCompanias();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(FestivalCompania).build();
	}
	
	@PUT
	@Path("/festivalCompania")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFestivalCompania(ListaFestivalCompania FestivalCompania) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addFestivalCompanias(FestivalCompania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(FestivalCompania).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFuncion() {
		Sistrans tm = new Sistrans(getPath());
		ListaFuncion Funcion;
		try {
			Funcion = tm.darFuncions();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Funcion).build();
	}
	
	@PUT
	@Path("/funciones")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncion(ListaFuncion Funcion) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addFuncions(Funcion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Funcion).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLocalidad() {
		Sistrans tm = new Sistrans(getPath());
		ListaLocalidad Localidad;
		try {
			Localidad = tm.darLocalidads();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Localidad).build();
	}
	
	@PUT
	@Path("/localidades")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addLocalidad(ListaLocalidad Localidad) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addLocalidads(Localidad);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Localidad).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoEspacio() {
		Sistrans tm = new Sistrans(getPath());
		ListaTipoEspacio TipoEspacio;
		try {
			TipoEspacio = tm.darTipoEspacios();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoEspacio).build();
	}
	
	@PUT
	@Path("/tipoespacios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTipoEspacio(ListaTipoEspacio TipoEspacio) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addTipoEspacios(TipoEspacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoEspacio).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoSilleteria() {
		Sistrans tm = new Sistrans(getPath());
		ListaTipoSilleteria TipoSilleteria;
		try {
			TipoSilleteria = tm.darTipoSilleterias();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoSilleteria).build();
	}
	
	@PUT
	@Path("/TipoSilleterias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTipoSilleteria(ListaTipoSilleteria TipoSilleteria) {
		Sistrans tm = new Sistrans(getPath());
		try {
			tm.addTipoSilleterias(TipoSilleteria);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoSilleteria).build();
	}
}
