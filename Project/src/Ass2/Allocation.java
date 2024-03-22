/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// ----- Assignment 2 package Imported -----
package Ass2;

// ----- Packages Imorted -----
import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jay bhole
 */
// ----- Entity class declaration -----
@Entity

// ----- Java Persistence Query Language declared for Allocation class -----
@NamedQueries({
    @NamedQuery(name = "getAllAllocations", query = "select a from Allocation a")})

@Table(name = "Allocation") // Table name declared

public class Allocation implements Serializable // Allocation class declared which implements serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID") // Id column added in allocation table
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto gengerated ID declared
    private Long id; // Id variable declared

    // ----- many-to-one relationship between entitieshas been implemented -----
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})

    // ----- joined subclass strategy applied with reference column and name from PROPERTY MANAGER CLASS -----
    @JoinColumn(name = "propertymanager_fk", referencedColumnName = "ID")

    private PropertyManager manager; // property manager class instance declared
    private Property property; // Property class instance declared

    // ----- default constructor declared -----
    public Allocation() {
        this(new PropertyManager(), new Property());
    }

    // ----- Parameterized constructor declared -----
    public Allocation(PropertyManager manager, Property property) {

        this.manager = manager;
        this.property = property;
    }

    // ----- Getter setter methods declare for the declared variable -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Property manager getter setter has been declared -----
    public PropertyManager getManager() {
        return manager;
    }

    public void setManager(PropertyManager manager) {
        this.manager = manager;
    }

    // ----- property class getter setter has been declared -----
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    // ---- Autogengerated code ------
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

}
