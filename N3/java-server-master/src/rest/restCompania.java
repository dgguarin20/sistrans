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


import tm.TmCompania;

import vos.Compania;
import vos.ListaCompania;

@Path("compania")
public class restCompania extends Services {
	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompaniaes() {
		TmCompania tm = new TmCompania(getPath());
		ListaCompania Compania;

		
		try {
			Compania = tm.darCompaniaes();
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		
		
		return Response.status(200).entity(Compania.getCompania()).build();
	}
	/**
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCompania(@PathParam("id") Long id) {
		TmCompania tm = new TmCompania(getPath());
		Compania Compania;
		try {
			Compania = tm.darCompania(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Compania).build();
	}
	*/
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompania(Compania Compania) {
		TmCompania tm = new TmCompania(getPath());
		try {
			tm.addCompania(Compania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Compania).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompania(Compania Compania) {
		TmCompania tm = new TmCompania(getPath());
		try {
			tm.updateCompania(Compania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Compania).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompania(Compania f) {
		TmCompania tm = new TmCompania(getPath());
		try {
			tm.deleteCompania(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}
}
