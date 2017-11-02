/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Menja
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
    , @NamedQuery(name = "Place.findById", query = "SELECT p FROM Place p WHERE p.id = :id")
    , @NamedQuery(name = "Place.findByCity", query = "SELECT p FROM Place p WHERE p.city = :city")
    , @NamedQuery(name = "Place.findByDescription", query = "SELECT p FROM Place p WHERE p.description = :description")
    , @NamedQuery(name = "Place.findByGeolat", query = "SELECT p FROM Place p WHERE p.geolat = :geolat")
    , @NamedQuery(name = "Place.findByGeolng", query = "SELECT p FROM Place p WHERE p.geolng = :geolng")
    , @NamedQuery(name = "Place.findByImage", query = "SELECT p FROM Place p WHERE p.image = :image")
    , @NamedQuery(name = "Place.findByRating", query = "SELECT p FROM Place p WHERE p.rating = :rating")
    , @NamedQuery(name = "Place.findByStreet", query = "SELECT p FROM Place p WHERE p.street = :street")
    , @NamedQuery(name = "Place.findByZip", query = "SELECT p FROM Place p WHERE p.zip = :zip")})
public class Place implements Serializable {

    //constructor
    public Place() {
    }

    //variables
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String street;
    private String zip;
    private String city;
    private double geolat;
    private double geolng;
    private String description;
    private int rating;

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getGeolat() {
        return geolat;
    }

    public void setGeolat(double geolat) {
        this.geolat = geolat;
    }

    public double getGeolng() {
        return geolng;
    }

    public void setGeolng(double geolng) {
        this.geolng = geolng;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "PLACE:" + "\n"
                + "Id: " + id + "\n"
                + "Image: " + image + "\n"
                + "Street: " + street + "\n"
                + "Zip: " + zip + "\n"
                + "City: " + city + "\n"
                + "Geolat: " + geolat + "\n"
                + "Geolng: " + geolng + "\n"
                + "Description: " + description + "\n"
                + "Rating: " + rating + "\n";
    }

}
