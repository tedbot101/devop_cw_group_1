package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("db:3306", 30000);
        // Disconnect from database
        System.out.println("\n\n*****************************************************\nAll the countries in the world organised by largest population to smallest.\n");
        ArrayList<Country> contries= a.getCountryPopLargesttoSmallest();
        a.display(contries);
        System.out.println("\n\n*****************************************************\nAll the countries in a continent organised by largest population to smallest\n");
        ArrayList<Country> contries2= a.getCountryPopbyContinent("Asia");
        a.display(contries2);
        System.out.println("\n\n*****************************************************\nAll the countries in a region organised by largest population to smallest\n");
        ArrayList<Country> contries3= a.getCountryPopbyRegion("Caribbean");
        a.display(contries3);

    }

    /**
     * Connect to the MySQL database.

     */
    public void connect(String conString, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                //Added allowPublicKeyRetrieval=true to get Integration Tests to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {
        String sql ="SELECT Name,Continent,Region, Capital, Population from country order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {
        String sql ="select Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryPopbyRegion(String reg) throws SQLException {
        String sql ="select Name,Continent,Region, Capital, Population from country where Region=? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,reg);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {Country  c = new Country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }



    public void display(ArrayList<Country> conts)
    {
        for(Country c: conts)
        {
            System.out.println(String.format("%-10s %-25s %-25s %-10s", "Name", "CountryCode", "District", "Population"));
        }
    }


}

