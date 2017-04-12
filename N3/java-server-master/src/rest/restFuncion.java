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

import tm.TmFuncion;
import vos.ListaFuncion;
import vos.funcion;



@Path("funcion")
public class restFuncion extends Services {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFunciones() {
		TmFuncion tm = new TmFuncion(getPath());
		ListaFuncion Funcion;
		try {
			Funcion = tm.darFuncions();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Funcion.getFuncion()).build();
	}
	

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFuncion(funcion Funcion) {
		TmFuncion tm = new TmFuncion(getPath());
		try {
			tm.addFuncion(Funcion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Funcion).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFuncion(funcion Funcion) {
		TmFuncion tm = new TmFuncion(getPath());
		try {
			tm.updateFuncion(Funcion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Funcion).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFuncion(funcion f) {
		TmFuncion tm = new TmFuncion(getPath());
		try {
			tm.deleteFuncion(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}
	
}
