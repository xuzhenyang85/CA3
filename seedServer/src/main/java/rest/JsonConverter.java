package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Place;
import interfaces.IPlaceFacade;
import java.util.List;
import security.IUser;

public class JsonConverter {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /*----------CONVERTER FOR USERS------------*/
    public User getUserFromJson(String javascript) {
        return GSON.fromJson(javascript, User.class);
    }

    public String getJSONFromUser(IUser user) {
        return GSON.toJson(user);
    }

    public String getJSONFromUsers(List<IUser> users) {
        return GSON.toJson(users);
    }

    /*----------CONVERTER FOR PLACES-----------*/
    public Place getPlaceFromJson(String javascript) {
        return GSON.fromJson(javascript, Place.class);
    }

    public String getJSONFromPlace(Place place) {
        return GSON.toJson(place);
    }

    public String getJSONFromPlaces(List<Place> places) {
        return GSON.toJson(places);
    }

}
