/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Place;
import interfaces.IPlaceFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Menja
 */
public class PlaceFacade implements IPlaceFacade {

    EntityManagerFactory emf;

    /*CONSTRUCTOR*/
    public PlaceFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /*MAIN METHOD*/
    public static void main(String[] args) {
        //Creates a persistence unit and new instance of Placefacade
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        PlaceFacade pf = new PlaceFacade(emf);

        /*Runs the different methods*/
        System.out.println(pf.getPlaceByCity("Lyngby"));
        //System.out.println("ALL PLACES: \n" + pf.getAllPlaces());
        //System.out.println("PLACE BY ID: \n" + pf.getPlaceById(12));
    }

    /*THE METHODS*/
    @Override
    public List<Place> getAllPlaces() {
        EntityManager em = emf.createEntityManager();
        List<Place> places = em.createNamedQuery("Place.findAll").getResultList();
        return places;
    }

    @Override
    public Place getPlaceById(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            Place place = em.find(Place.class, id);
            return place;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<Place> getPlaceByCity(String city) {
        EntityManager em = emf.createEntityManager();

        Query q = em.createNamedQuery("Place.findByCity");
        q.setParameter("city", city);
        List<Place> places = q.getResultList();
        return places;
    }

//    @Override
//    public Place findByDescription() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByGeolat() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByGeolng() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByImage() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByRating() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByStreet() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Place findByZip() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
