// ----- Assignment 2 package Imported -----
package Ass2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jay bhole
 */
// ----- Packages Imorted -----
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

public class Main // Main class dcalration
{

    public static void main(String[] args) // Main method declaration
    {

        // ----- Scanner class declared for input choice ------
        Scanner inputChoice = new Scanner(System.in);

        // ----- Persisting the data ----
        RentProperty rp1 = new RentProperty();          // Rent 1 property declared
        rp1.setAddress(" Rent 1 Example street");
        rp1.setDescription("Rent description 1");
        rp1.setWeeklyRent(100.12);

        RentProperty rp2 = new RentProperty();          // Rent 2 property declared
        rp2.setAddress("Rent 2 Example street");
        rp2.setDescription("Rent description 2");
        rp2.setWeeklyRent(100.12);

        SaleProperty sp1 = new SaleProperty();          // Sale 1 property declared
        sp1.setAddress("Sale Example street");
        sp1.setDescription("Sale description");
        sp1.setSalePrice(100.22);

        InRentProperty inr1 = new InRentProperty();         // InRent 1 property declared
        inr1.setAddress("In rent property Example street");
        inr1.setDescription("in rent description");
        inr1.setTenantName("MANAN");

        PropertyManager pm1 = new PropertyManager();        // property manager declared
        pm1.setName("MANAN PATEL");
        pm1.setPhoneNumber("456449879");

        Allocation al = new Allocation();                   // Allocation 1 declared
        al.setManager(pm1);
        al.setProperty(rp1);

        Allocation al2 = new Allocation();                  // Allocation 2 declared
        al2.setManager(pm1);
        al2.setProperty(rp2);

        ArrayList<Allocation> allocations = new ArrayList(); // Adding both the allocation in new arraylist
        allocations.add(al);
        allocations.add(al2);

        pm1.setAllocation(allocations);                     // setting allocation to the project manager

        // persisting the data into database
        // Entity Manager class objects declared for persisting the data into database -----
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment_2"); //Setting up persistance name
        EntityManager em = emf.createEntityManager();       // Creating entity manager 
        EntityTransaction tx = em.getTransaction();         // Getting the transcation

        // Beginning the transcation 
        tx.begin();

        // peristing rent property data 
        em.persist(rp1);
        em.persist(rp2);

        // peristing sale property data 
        em.persist(sp1);

        // peristing in rent property data 
        em.persist(inr1);

        // peristing property manager data 
        em.persist(pm1);

        // Persisting both the allocated data ----
        em.persist(al);
        em.persist(al2);

        // ==================== Displaying the persisted Sale property data ====================================
        System.out.println("===================================================");
        System.out.println("Persisted Properties");

        // Displaying sale property
        System.out.println("FOR SALE :\n");

        // Getting the data using the query class
        Query queryForSale = em.createNamedQuery("findAllSaleProperty", SaleProperty.class);

        // List declared for storing the sale propert data in list
        List<SaleProperty> listForSaleProperty = queryForSale.getResultList();

        tx.commit(); // Commiting the data 

        // ----- For loop declared for printing the data -----
        for (int index = 0; index < listForSaleProperty.size(); index++) {
            SaleProperty displaySale = listForSaleProperty.get(index);
            System.out.println("Property ID :" + displaySale.getId());
            System.out.println("Address :" + displaySale.getAddress());
            System.out.println("Description :" + displaySale.getDescription());
            System.out.println("Sale Price : $" + displaySale.getSalePrice());
            System.out.println("\n");

        }

        // ==================== Displaying the persisted  rent property data ====================================
        System.out.println("FOR RENT :\n");

        // Getting the data using the query class
        Query queryForRent = em.createNamedQuery("findAllRentProperty", RentProperty.class);

        // List declared for storing the rent propert data in list
        List<RentProperty> listForRentProperty = queryForRent.getResultList();

        // ----- For loop declared for printing the data -----
        for (int index = 0; index < listForRentProperty.size(); index++) {
            RentProperty dislayRent = listForRentProperty.get(index);
            System.out.println("Property ID :" + dislayRent.getId());
            System.out.println("Address :" + dislayRent.getAddress());
            System.out.println("Description :" + dislayRent.getDescription());
            System.out.println("Rent Price : $" + dislayRent.getWeeklyRent());
            System.out.println("\n");

        }

        // ==================== Displaying the persisted  in-rent property data ====================================
        System.out.println("FOR IN RENT PROPERTY :\n");

        // Getting the data using the query class
        Query queryForInRent = em.createNamedQuery("findAllInRentProperty", InRentProperty.class);

        // List declared for storing the in rent property data in list
        List<InRentProperty> listForInRentProperty = queryForInRent.getResultList();

        // ----- For loop declared for printing the data -----
        for (int index = 0; index < listForInRentProperty.size(); index++) {
            InRentProperty displayInRent = listForInRentProperty.get(index);
            System.out.println("Property ID :" + displayInRent.getId());
            System.out.println("Address :" + displayInRent.getAddress());
            System.out.println("Description :" + displayInRent.getDescription());
            System.out.println("Tenant name : " + displayInRent.getTenantName());
            System.out.println("\n");

        }

        // ==================== Displaying the persisted Property manager data ====================================
        System.out.println("===================================================");
        System.out.println("Persisted Properties Managers");

        // Getting the data using the query class
        Query queryForPropertyManager = em.createNamedQuery("getAllPropertyManagers", PropertyManager.class);

        // List declared for storing the property manager data in list
        List<PropertyManager> listForPropertyManager = queryForPropertyManager.getResultList();

        // ----- For loop declared for printing the data -----
        for (int i = 0; i < listForPropertyManager.size(); i++) {
            PropertyManager ppm1 = listForPropertyManager.get(i);
            System.out.println("MANAGER ID :" + ppm1.getId());
            System.out.println("NAME :" + ppm1.getName());
            System.out.println("PHONE NUMBER :" + ppm1.getPhoneNumber());
            System.out.println("\n");

        }

        // ==================== Displaying the persisted Property Allocation data ====================================
        System.out.println("===================================================");
        System.out.println("Persisted Properties Allocations");

        // Getting the data using the query class
        Query queryForAllocation = em.createNamedQuery("getAllAllocations", Allocation.class);

        // List declared for storing the allocation property data in list
        List<Allocation> listForAllocation = queryForAllocation.getResultList();

        // ----- For loop declared for printing the data -----
        for (int i = 0; i < listForAllocation.size(); i++) {
            Allocation allocationData = listForAllocation.get(i);

            // Property manager and property instances for getting the data 
            PropertyManager propertManagerAllocation = allocationData.getManager();
            Property propertyData = allocationData.getProperty();

            System.out.println("Allocation ID :" + allocationData.getId());
            System.out.println("MANAGER NAME :" + propertManagerAllocation.getName());
            System.out.println("Description :" + propertyData.getAddress());
            System.out.println("\n");

        }

        // ================================== Testing the data =========================================
        boolean valid = true; // boolean variable for loop 
        int ans = 0; // answer variable for choice limit
        do {

            // ----- promprt for data selection -----
            System.out.println("\n************************");

            System.out.println("Query a Property............ 1");
            System.out.println("Query a Property Manager.... 2");
            System.out.println("Query Allocation............ 3");
            System.out.println("Exit........................ 4");

            System.out.println("\nEnter your choice :");
            ans = inputChoice.nextInt(); // adding the choice using scanner object

            // try- catch surronded for error handling -----
            try {

                // if the user press 1 then following code will execute 
                if (ans == 1) {
                    String findAddress; // string variable for storing address

                    System.out.println("Enter the address : ");
                    inputChoice.nextLine(); // getting the data using scanner object

                    findAddress = inputChoice.nextLine();

                    // getting the data using parameterized query -----
                    TypedQuery<Property> q6 = em.createNamedQuery("findWIthParameterProperty", Property.class);
                    q6.setParameter("findAddress", findAddress);

                    Property property = q6.getSingleResult(); // getting the single result

                    // checking the instance of different property class
                    System.out.println(property.getClass().getSimpleName());

                    if (property instanceof SaleProperty) { // printing the data if the instance is of sale property

                        System.out.println("Property ID :" + ((SaleProperty) property).getId());
                        System.out.println("Address :" + ((SaleProperty) property).getAddress());
                        System.out.println("Description :" + ((SaleProperty) property).getDescription());
                        System.out.println("Sale Price : $" + ((SaleProperty) property).getSalePrice());
                        System.out.println("\n");

                    } else if (property instanceof RentProperty) { // printing the data if the instance is of rent property
                        System.out.println("Property ID :" + ((RentProperty) property).getId());
                        System.out.println("Address :" + ((RentProperty) property).getAddress());
                        System.out.println("Description :" + ((RentProperty) property).getDescription());
                        System.out.println("Rent Price : $" + ((RentProperty) property).getWeeklyRent());
                        System.out.println("\n");

                    } else if (property instanceof InRentProperty) { // printing the data if the instance is of inrent property
                        System.out.println("Property ID :" + ((InRentProperty) property).getId());
                        System.out.println("Address :" + ((InRentProperty) property).getAddress());
                        System.out.println("Description :" + ((InRentProperty) property).getDescription());
                        System.out.println("Tenant name : " + ((InRentProperty) property).getTenantName());
                        System.out.println("\n");
                    } else {
                        System.out.println("NOT FOUND SORRY"); // not found data
                    }
                } else if (ans == 2) {  // operation 2 performed
                    String name; // name variable declared

                    System.out.println("Enter the name : ");
                    inputChoice.nextLine(); // gettting the name

                    name = inputChoice.nextLine();

                    // getting the data using parameterized query -----
                    TypedQuery<PropertyManager> q7 = em.createNamedQuery("findPropertyManagerwithParameters", PropertyManager.class);
                    q7.setParameter("findName", name);

                    // printing the required data
                    PropertyManager propertymanager = q7.getSingleResult();

                    System.out.println("MANAGER ID :" + propertymanager.getId());
                    System.out.println("NAME :" + propertymanager.getName());
                    System.out.println("PHONE NUMBER :" + propertymanager.getPhoneNumber());
                    System.out.println("\n");

                } else if (ans == 3) { // performing third oeration
                    String allocationName; // getting the allocating name

                    System.out.println("Enter the name : ");
                    inputChoice.nextLine(); // getting the name

                    allocationName = inputChoice.nextLine();

                    // getting the data using parameterized query -----
                    TypedQuery<PropertyManager> q8 = em.createNamedQuery("findPropertyManagerwithParameters", PropertyManager.class);
                    q8.setParameter("findName", allocationName);

                    // printing the required data
                    PropertyManager propertymanager = q8.getSingleResult();

                    System.out.println("Allocation ID :" + propertymanager.getId());

                    for (int i = 0; i < propertymanager.getAllocation().size(); i++) {
                        System.out.println("Property location :" + propertymanager.getAllocation().get(i).getProperty().getAddress());
                    }

                    System.out.println("\n");
                }
                else if (ans == 4)
                {
                    valid=false; // exiting the loop
                }
            } catch (Exception e) { // exceptional handling
                System.out.println("IO: " + e.getMessage());

            }

        } while (valid); // end loop

        em.close();// close

    }

}
