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

        // Report obj calls
        System.out.println("[system] In main ");

        // city report
        // All the cities in the world organised by largest population to smallest.
        System.out.println("\n[*] All the cities in the world organised by largest population to smallest.[*] \n");
        a.displayCity( a.getCityPopLargesttoSmallest());

        // All the cities in the continent organised by largest population to smallest
        System.out.println("\n[*] All the cities in the continent organised by largest population to smallest.[*] \n");
        a.displayCity(a.getCityContinentPopLargesttoSmallest("Africa"));

        // All the cities in the region organised by largest population to smallest
        System.out.println("\n[*] All the cities in the region organised by largest population to smallest.[*]\n");
        a.displayCity(a.getCityRegionPopLargesttoSmallest("South America"));

        // All the cities in a country organised by largest population to smallest
        System.out.println("\n[*] All the cities in a country organised by largest population to smallest. [*]\n");
        a.displayCity(a.getCityCountryPopLargesttoSmallest("Japan"));

        // All the cities in a district organised by largest population to smallest.
        System.out.println("\n[*] All the cities in a district organised by largest population to smallest. [*]\n");
        a.displayCity(a.getCityDistrictPopLargesttoSmallest("Noord-Brabant"));

        // country report
        // the countries in the world organised by largest population to smallest
        System.out.println("\n[*] All the countries in the world organised by largest population to smallest. [*]\n");
        a.displayCountry(a.getCountryPopLargesttoSmallest());

        // the countries in a continent organised by largest population to smallest
        System.out.println("\n[*] All the countries in a continent organised by largest population to smallest [*]\n");
        a.displayCountry(a.getCountryPopbyContinent("Asia"));

        // the countries in a region organised by largest population to smallest
        System.out.println("\n[*] All the countries in a region organised by largest population to smallest [*]\n");
        a.displayCountry(a.getCountryPopbyRegion("Caribbean"));


        // Disconnect from database
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
            System.out.println("[system] Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("[system] Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                //Added allowPublicKeyRetrieval=true to get Integration Tests to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("[system] Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("[system] Thread interrupted? Should not happen.");
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
                System.out.println("[system] Error closing connection to database");
            }
        }
    }

    public ArrayList<Country> getCountryPopLargesttoSmallest() throws SQLException {

        //
        // Description :
        // report function for countires sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryPopLargesttoSmallest()


        String sql = "SELECT Name,Continent,Region, Capital, Population from country order by Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Country c = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryPopbyContinent(String contn) throws SQLException {

        //
        // Description :
        // report function for countires in selected continent sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryPopLargesttoSmallest("Asia")


        String sql = "select Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Country c = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryPopbyRegion(String reg) throws SQLException {

        //
        // Description :
        // report function for countires in selected region sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryPopbyRegion("region")


        String sql = "select Name,Continent,Region, Capital, Population from country where Region=? order by Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Country c = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<City> getCityPopLargesttoSmallest() throws SQLException {

        //
        // Description :
        // report function for cities from largest population to smallest
        //
        // Usage:
        //  object.getCityPopLargesttoSmallest()


        String sql = "select ID,Name,CountryCode, District, Population from city order by Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // City in the continent
    public ArrayList<City> getCityContinentPopLargesttoSmallest(String contn) throws SQLException {

        //
        // Description :
        // report function for cities in selected continent sorted from largest population to smallest
        //
        // Usage:
        //  object.getCityContinentPopLargesttoSmallest('continent')


        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Continent = ? order by city.Population desc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // City in the region
    public ArrayList<City> getCityRegionPopLargesttoSmallest(String reg) throws SQLException {

        //
        // Description :
        // report function for cities in selected region sorted from largest population to smallest
        //
        // Usage:
        //  object.getCityRegionPopLargesttoSmallest('region')


        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Region = ? order by city.Population desc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // Cities in a country
    public ArrayList<City> getCityCountryPopLargesttoSmallest(String coun) throws SQLException {

        //
        // Description :
        // report function for cities in selected countries sorted from largest population to smallest
        //
        // Usage:
        //  object.getCityCountryPopLargesttoSmallest("country")


        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Name = ? order by city.Population desc ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, coun);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;
    }

    // Cities in District
    public ArrayList<City> getCityDistrictPopLargesttoSmallest(String dist) throws SQLException {

        //
        // Description :
        // report function for cities in selected disctrict sorted from largest population to smallest
        //
        // Usage:
        //  object.getCityDistrictPopLargesttoSmallest("district")


        String sql = "select ID,Name,CountryCode, District, Population from city where District = ? order by Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, dist);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }

    public void displayCountry(ArrayList<Country> conts) {


        //
        // Description :
        //  Display function for countires
        //
        // Usage:
        //  object.displayCity(Array)
        if (conts == null)
        {
            System.out.println("[system] No countires");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-25s %-25s %-25s %-25s", "Name", "Continent", "Region", "Capital", "Population"));
        // Loop over all city in the list
        for (Country country : conts) {
            if (country == null)
                continue;
            String cty_string =
                    String.format("%-20s %-25s %-25s %-25s %-25s",
                            country.getName(), country.getContinent(), country.getRegion(), country.getCapital(), country.getPopulation());
            System.out.println(cty_string);
        }
    }

    public void displayCity(ArrayList<City> conts) {

        //
        // Description :
        //  Display function for Country
        //
        // Usage:
        //  object.displayCountry(Array)
        // Check employees is not null
        if (conts == null)
        {
            System.out.println("[system] No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s %-25s %-25s %-25s %-25s", "ID", "Name", "CountryCode", "District", "Population"));
        // Loop over all city in the list
        for (City c : conts) {
            if (c == null)
                continue;
            String city_string =
                    String.format("%-20s %-25s %-25s %-25s %-25s",
                            c.getID(), c.getName(), c.getCountryCode(), c.getDistrict(), c.getPopulation());
            System.out.println(city_string);
        }
    }


}