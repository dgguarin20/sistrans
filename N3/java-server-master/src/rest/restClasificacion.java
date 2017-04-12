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
import tm.TmClasificacion;
import tm.TmFestival;
import vos.Boleta;
import vos.Clasificacion;
import vos.Festival;
import vos.ListaClasificacion;
import vos.ListaFestival;

@Path("clasificacion")
public class restClasificacion extends Services{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClasificaciones() {
		TmClasificacion tm = new TmClasificacion(getPath());
		ListaClasificacion Clasificacion;
		
		TMBoleta tmb = new TMBoleta(getPath());
		Boleta Boleta;
		
		
		
		try {
			Clasificacion = tm.darClasificaciones();
			
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		
		
	
		
		return Response.status(200).entity(Clasificacion.getClasificacion()).build();
	}
/**	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getClasificacion(@PathParam("id") Long id) {
		TmClasificacion tm = new TmClasificacion(getPath());
		Clasificacion Clasificacion;
		try {
			Clasificacion = tm.darClasificacion(id);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Clasificacion).build();
	}
	**/
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClasificacion(Clasificacion Clasificacion) {
		TmClasificacion tm = new TmClasificacion(getPath());
		try {
			tm.addClasificacion(Clasificacion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Clasificacion).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateClasificacion(Clasificacion Clasificacion) {
		TmClasificacion tm = new TmClasificacion(getPath());
		try {
			tm.updateClasificacion(Clasificacion);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(Clasificacion).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClasificacion(Clasificacion f) {
		TmClasificacion tm = new TmClasificacion(getPath());
		try {
			tm.deleteClasificacion(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}

}
