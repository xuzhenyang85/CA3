/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Place;

/**
 *
 * @author Menja
 */
public interface IPlaceFacade {
    public Place getPlaceById();
    public Place getPlaceByCity();
}
