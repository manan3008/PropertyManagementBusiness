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
    @NamedNativeQuery(name = "findAllSaleProperty", query = "select * from SaleProperty", resultClass = SaleProperty.class)})
@Table(name = "SaleProperty") // Table name declared

public class SaleProperty extends Property // Sales property extends Property
{

    private double salePrice; // Sales Prices declaration

    // ----- Parameterized constructor declaration -----
    public SaleProperty(double salePrice) {
        this.salePrice = salePrice;
    }

    // ----- Default constructor declaration -----
    public SaleProperty() {
        this(0.0);
    }

    // ----- Getter setter for price variable -----
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

}
