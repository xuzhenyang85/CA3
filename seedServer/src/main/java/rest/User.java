package rest;

import com.google.gson.Gson;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import security.IUserFacade;
import security.UserFacadeFactory;

@Path("demouser")
@RolesAllowed("User")
public class User {

    IUserFacade userFacade;

    @Context
    private UriInfo context;
    
    public User() {
        userFacade = UserFacadeFactory.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        return "{\"message\" : \"Hello User from Server (Accesible by only authenticated USERS)\"}";
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
