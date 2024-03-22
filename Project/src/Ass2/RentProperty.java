/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// ----- Assignment 2 package Imported -----
package Ass2;

// ----- Packages Imorted -----
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 *
 * @author jay bhole
 */
// ----- Entity class declaration -----
@Entity

// ----- Java Persistence Query Language declared for Rent property -----
@NamedNativeQueries({
    @NamedNativeQuery(name = "findAllRentProperty", query = "select * from RentalProperty", resultClass = RentProperty.class)})

@Table(name = "RentalProperty") // Table name declared

public class RentProperty extends Property // Rent property extends property class
{

    private Double weeklyRent; // variable declaration for weeklyRent

    // ----- PParameterized constructor -----
    public RentProperty(Double weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    // ----- Default constructor -----
    public RentProperty() {
        this(0.0);
    }

    //----- Getter setter for weeklyrent variable -----
    public Double getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(Double weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

}
