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

import tm.TMBoleta;
import tm.TmFestival;
import vos.Boleta;
import vos.Festival;
import vos.ListaBoleta;
import vos.ListaFestival;

@Path("festival")
public class restFestival extends Services {
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestivales() {
		TmFestival tm = new TmFestival(getPath());
		ListaFestival Festival;
		
		TMBoleta tmb = new TMBoleta(getPath());
		Boleta Boleta;
		
		
		
		try {
			Festival = tm.darFestivales();
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		
		try {	
		Boleta = tmb.darBoleta(Festival.darid(1));
		} catch (Exception e) {
		return Response.status(500).entity(doErrorMessage(e)).build();
		
		}
		
		return Response.status(200).entity(Festival.getFestival()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestival(@PathParam("id") Long id) {
		TmFestival tm = new TmFestival(getPath());
		Festival festival;
		try {
			festival = tm.darFestival(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFestival(Festival festival) {
		TmFestival tm = new TmFestival(getPath());
		try {
			tm.addFestival(festival);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFestival(Festival festival) {
		TmFestival tm = new TmFestival(getPath());
		try {
			tm.updateFestival(festival);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(festival).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFestival(Festival f) {
		TmFestival tm = new TmFestival(getPath());
		try {
			tm.deleteFestival(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}

}
