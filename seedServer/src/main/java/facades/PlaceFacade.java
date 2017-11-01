/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Place;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Menja
 */
public class PlaceFacade {

    EntityManagerFactory emf;

    //Constructor
    public PlaceFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        //Creates a persistence unit and new instance of Placefacade
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        PlaceFacade pf = new PlaceFacade(emf);

        /*Runs the different methods*/
        System.out.println(pf.getAllPlaces());
    }

    //The methods
    public List<Place> getAllPlaces() {
        EntityManager em = emf.createEntityManager();
        List<Place> places = em.createNamedQuery("Place.findAll").getResultList();
        return places;
    }
//  public Place getPlaceById(){}
//  public Place getPlaceByCity(){}
}
