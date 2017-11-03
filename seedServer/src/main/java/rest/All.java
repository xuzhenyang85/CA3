package rest;

import com.google.gson.Gson;
import entity.Place;
import facades.PlaceFacade;
import interfaces.IPlaceFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.IUserFacade;
import security.UserFacadeFactory;

/**
 * REST Web Service
 *
 * @author xu
 */
@Path("all")
public class All {

    IUserFacade userFacade;
    EntityManagerFactory emf;
    
    private final IPlaceFacade placeFacade = new PlaceFacade(emf);
    private final JsonConverter jsonConverter = new JsonConverter();

    @Context
    private UriInfo context;

    public All() {
        userFacade = UserFacadeFactory.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getText() {
        return " {\"message\" : \"result for all\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/places")
    public String getAllPlaces() {
        List<Place> places = placeFacade.getAllPlaces();
        return jsonConverter.getJSONFromPlaces(places);
    }

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(String content) {
        entity.User u = new Gson().fromJson(content, entity.User.class);
        System.out.println("username :" + u.getUserName() + " password: " + u.getPasswordHash());
        userFacade.createUser(u.getUserName(), u.getPasswordHash());
    }

}
