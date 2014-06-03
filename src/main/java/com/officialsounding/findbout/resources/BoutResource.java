package com.officialsounding.findbout.resources;

import com.officialsounding.findbout.dao.BoutDAO;
import com.officialsounding.findbout.model.Bout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/bout")
@Produces(MediaType.APPLICATION_JSON)
public class BoutResource {


    private final BoutDAO boutDAO;

    public BoutResource(BoutDAO boutDAO) {
        this.boutDAO = boutDAO;
    }

    @GET
    public List<Bout> getAll() {
        return boutDAO.getAll();
    }

    @GET
    @Path("precise")
    public List<Bout> getBoutsPrecise(@QueryParam("lat") double lat, @QueryParam("lng") double lng) {
        return boutDAO.getPrecise(lat,lng);
    }
}
