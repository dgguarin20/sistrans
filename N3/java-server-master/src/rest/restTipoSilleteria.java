package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.TMBoleta;
import tm.TmTipoSilleteria;
import vos.Boleta;
import vos.TipoSilleteria;
import vos.ListaTipoSilleteria;

@Path("tipoSilleteria")
public class restTipoSilleteria extends Services{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoSilleteriaes() {
		TmTipoSilleteria tm = new TmTipoSilleteria(getPath());
		ListaTipoSilleteria TipoSilleteria;
		
		TMBoleta tmb = new TMBoleta(getPath());
		Boleta Boleta;
		
		
		
		try {
			TipoSilleteria = tm.darTipoSilleteriaes();
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		
	
		
		return Response.status(200).entity(TipoSilleteria.getTipoSilleteria()).build();
	}
/**	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoSilleteria(@PathParam("id") Long id) {
		TmTipoSilleteria tm = new TmTipoSilleteria(getPath());
		TipoSilleteria TipoSilleteria;
		try {
			TipoSilleteria = tm.darTipoSilleteria(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoSilleteria).build();
	}
	**/
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTipoSilleteria(TipoSilleteria TipoSilleteria) {
		TmTipoSilleteria tm = new TmTipoSilleteria(getPath());
		try {
			tm.addTipoSilleteria(TipoSilleteria);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoSilleteria).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTipoSilleteria(TipoSilleteria TipoSilleteria) {
		TmTipoSilleteria tm = new TmTipoSilleteria(getPath());
		try {
			tm.updateTipoSilleteria(TipoSilleteria);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoSilleteria).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTipoSilleteria(TipoSilleteria f) {
		TmTipoSilleteria tm = new TmTipoSilleteria(getPath());
		try {
			tm.deleteTipoSilleteria(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}

}
