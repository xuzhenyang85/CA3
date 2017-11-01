/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Place;
import java.util.List;

/**
 *
 * @author Menja
 */
public interface IPlaceFacade {

    public List<Place> getAllPlaces();

    public Place getPlaceById(int id);

    public List<Place> getPlaceByCity(String city);
//
//    public Place findByDescription();
//
//    public Place findByGeolat();
//
//    public Place findByGeolng();
//
//    public Place findByImage();
//
//    public Place findByRating();
//
//    public Place findByStreet();
//
//    public Place findByZip();
}
