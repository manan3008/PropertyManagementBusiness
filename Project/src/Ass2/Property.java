/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// ----- Assignment 2 package Imported -----
package Ass2;

// ----- Packages Imorted -----
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jay bhole
 */
// ----- Entity class declaration -----
@Entity
// ----- Java Persistence Query Language declared for  property class -----

@NamedQueries({
    @NamedQuery(name = "findWIthParameterProperty", query = "select p from Property p where p.address = :findAddress")})

@Table(name = "Property Table")  // Table name declared

// -----inheritance between entities implemented by joined subclass strategy -----
@Inheritance(strategy = InheritanceType.JOINED)

public class Property implements Serializable // Property class immpements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id") // Coluumn name ID declared in table
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto generated ID

    private Long id; // Variable id declared

    @Column(name = "description") // Coluumn name declared in table
    private String description; // Variable description declared

    @Column(name = "address") // Coluumn address declared in table
    private String address; // Variable address declared

    protected Allocation allocations; // creating instance of alloxation class

    // ----- Getter setter for allocation ID to particular property -----
    public Allocation getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocation allocations) {
        this.allocations = allocations;
    }

    // ----- parameterized constructor declared -----
    public Property(String description, String address) {
        super();
        this.description = description;
        this.address = address;
    }

    // ----- default constructor declared -----
    public Property() {
        this("", "");
    }

    // Getter setter of all the variables to store the data -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ----- Serializable auto generated codes -----
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ass2.Property[ id=" + id + " ]";
    }

}
