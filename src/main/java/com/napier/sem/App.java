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

        System.out.println("In main");
        System.out.println("*******************************\nAll the cities in the world organised by largest population to smallest.\n");
        System.out.println("*******************************\n");
        ArrayList<City> city1= a.getCityPopLargesttoSmallest();
        a.display(city1);

        System.out.println("*******************************\nAll the cities in the continent organised by largest population to smallest.\n");
        System.out.println("*******************************\n");
        ArrayList<City> city2= a.getCityContinentPopLargesttoSmallest("Africa");
        a.display(city2);

        System.out.println("*******************************\nAll the cities in the region organised by largest population to smallest.\n");
        System.out.println("*******************************\n");
        ArrayList<City> city3= a.getCityRegionPopLargesttoSmallest("South America");
        a.display(city3);

        System.out.println("*******************************\nAll the cities in a country organised by largest population to smallest.\n");
        System.out.println("*******************************\n");
        ArrayList<City> city4= a.getCityCountryPopLargesttoSmallest("Japan");
        a.display(city4);

        System.out.println("*******************************\nAll the cities in a district organised by largest population to smallest.\n");
        System.out.println("*******************************\n");
        ArrayList<City> city5= a.getCityDistrictPopLargesttoSmallest("Noord-Brabant");
         a.display(city5);

        a.disconnect();
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
    public ArrayList<City>getCityPopLargesttoSmallest() throws SQLException {
        String sql ="select ID,Name,CountryCode, District, Population from city order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  c = new City(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // City in the continent
    public ArrayList<City>getCityContinentPopLargesttoSmallest(String contn) throws SQLException {
        String sql ="select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Continent = ? order by city.Population desc ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,contn);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  c = new City(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // City in the region
    public ArrayList<City>getCityRegionPopLargesttoSmallest(String reg) throws SQLException {
        String sql ="select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Region = ? order by city.Population desc ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,reg);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  c = new City(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }
    // Cities in a country
    public ArrayList<City>getCityCountryPopLargesttoSmallest(String coun) throws SQLException {
        String sql ="select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Name = ? order by city.Population desc ";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,coun);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  c = new City(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // Cities in District
    public ArrayList<City>getCityDistrictPopLargesttoSmallest(String dist) throws SQLException {
        String sql ="select ID,Name,CountryCode, District, Population from city where District = ? order by Population desc";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setString(1,dist);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset =pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while(rset.next())
        {City  c = new City(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }



    public void display(ArrayList<City> conts)
    {
        for(City c: conts)
        {
            System.out.println(c.getID()+"\t"+c.getName()+"\t"+c.getCountryCode()+"\t"+c.getDistrict()+"\t"+c.getPopulation());
        }
    }


}