package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.TmEspacio;
import tm.TmFestival;
import vos.Espacio;
import vos.Festival;
import vos.ListaEspacio;
import vos.ListaFestival;
@Path("espacio")
public class restEspacio extends Services {

	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEspacioes() {
		TmEspacio tm = new TmEspacio(getPath());
		ListaEspacio Espacio;
		try {
			Espacio = tm.darEspacioes();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Espacio.getEspacio()).build();
	}
	

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEspacio(Espacio Espacio) {
		TmEspacio tm = new TmEspacio(getPath());
		try {
			tm.addEspacio(Espacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Espacio).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEspacio(Espacio Espacio) {
		TmEspacio tm = new TmEspacio(getPath());
		try {
			tm.updateEspacio(Espacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Espacio).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEspacio(Espacio f) {
		TmEspacio tm = new TmEspacio(getPath());
		try {
			tm.deleteEspacio(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}
	
	
}
