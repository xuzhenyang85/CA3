
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import security.IUser;

public class JsonConverter
{
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public User getUserFromJson(String javascript)
    {
        return GSON.fromJson(javascript, User.class);
    }

    public String getJSONFromUser(IUser user)
    {
        return GSON.toJson(user);
    }
    
    public String getJSONFromUsers(List<IUser> users)
    {
        return GSON.toJson(users);
    }
    
}
