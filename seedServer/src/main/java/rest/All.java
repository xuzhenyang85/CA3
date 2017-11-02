package rest;

import com.google.gson.Gson;
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
