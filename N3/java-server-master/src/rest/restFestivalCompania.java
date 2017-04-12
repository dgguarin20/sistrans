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

import tm.TmFestivalCompania;
import vos.ListaFestivalCompania;
import vos.FestivalCompania;

@Path("festivalCompania")
public class restFestivalCompania extends Services {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getFestivalCompaniaes() {
		TmFestivalCompania tm = new TmFestivalCompania(getPath());
		ListaFestivalCompania FestivalCompania;
		try {
			FestivalCompania = tm.darFestivalCompanias();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(FestivalCompania.getFestivalCompania()).build();
	}
	

	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFestivalCompania(FestivalCompania FestivalCompania) {
		TmFestivalCompania tm = new TmFestivalCompania(getPath());
		try {
			tm.addFestivalCompania(FestivalCompania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(FestivalCompania).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFestivalCompania(FestivalCompania FestivalCompania) {
		TmFestivalCompania tm = new TmFestivalCompania(getPath());
		try {
			tm.updateFestivalCompania(FestivalCompania);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(FestivalCompania).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFestivalCompania(FestivalCompania f) {
		TmFestivalCompania tm = new TmFestivalCompania(getPath());
		try {
			tm.deleteFestivalCompania(f);
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
		return Response.status(200).entity(f).build();
	}
	
}
