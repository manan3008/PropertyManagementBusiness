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

// ----- Java Persistence Query Language declared for Sales property -----
@NamedNativeQueries({
    @NamedNativeQuery(name = "findAllInRentProperty", query = "select * from InRentProperty", resultClass = InRentProperty.class)})

@Table(name = "InRentProperty") // Table name declared

public class InRentProperty extends Property // InRent property extends Property
{

    private String tenantName; // Variable declaration for tenant name

    // ----- Parameterized constructor -----
    public InRentProperty(String tenantName) {
        this.tenantName = tenantName;
    }

    // ----- Default Constructor -----
    public InRentProperty() {
        this("");
    }

    // ----- Getter setter for setting tenant name variable -----
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

}
