package rest;

import facades.UserFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.IUser;
import security.IUserFacade;
import security.UserFacadeFactory;

/**
 * REST Web Service
 *
 * @author Dogan, Xu
 */

@Path("demoadmin")
@RolesAllowed("Admin")
public class Admin {

    IUserFacade uf = UserFacadeFactory.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        String now = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
        return "{\"message\" : \"Hello Admin from server (call accesible by only authenticated ADMINS)\",\n" + "\"serverTime\": \"" + now + "\"}";
    }

    @GET
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserList() {
        try {
            String json = "{\"users\":[\"";
            List<IUser> users = uf.getAllUsers();
            for (int i = 0; i < users.size(); i++) {
                json += users.get(i).getUserName();
                if (i == users.size() - 1) {
                    json += "\"]}";
                } else {
                    json += "\",\"";
                }
            }
            System.out.println(json);
            return json;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
