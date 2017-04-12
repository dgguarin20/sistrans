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
import tm.TmTipoEspacio;
import vos.Boleta;
import vos.TipoEspacio;
import vos.ListaTipoEspacio;
@Path("tipoEspacio")
public class restTipoEspacio extends Services{
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoEspacioes() {
		TmTipoEspacio tm = new TmTipoEspacio(getPath());
		ListaTipoEspacio TipoEspacio;
		
		TMBoleta tmb = new TMBoleta(getPath());
		Boleta Boleta;
		
		
		
		try {
			TipoEspacio = tm.darTipoEspacioes();
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		
	
		
		return Response.status(200).entity(TipoEspacio.getTipoEspacio()).build();
	}
/**	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTipoEspacio(@PathParam("id") Long id) {
		TmTipoEspacio tm = new TmTipoEspacio(getPath());
		TipoEspacio TipoEspacio;
		try {
			TipoEspacio = tm.darTipoEspacio(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoEspacio).build();
	}
	**/
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTipoEspacio(TipoEspacio TipoEspacio) {
		TmTipoEspacio tm = new TmTipoEspacio(getPath());
		try {
			tm.addTipoEspacio(TipoEspacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoEspacio).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTipoEspacio(TipoEspacio TipoEspacio) {
		TmTipoEspacio tm = new TmTipoEspacio(getPath());
		try {
			tm.updateTipoEspacio(TipoEspacio);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(TipoEspacio).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTipoEspacio(TipoEspacio f) {
		TmTipoEspacio tm = new TmTipoEspacio(getPath());
		try {
			tm.deleteTipoEspacio(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}

}
