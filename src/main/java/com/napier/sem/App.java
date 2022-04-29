package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        if(args.length < 1){
            // Connect to database
            a.connect("localhost:33060", 30000);
        }else{
            a.connect("db:3306", 30000);
        }

        // Report obj calls

        System.out.println("[system] In main ");


        // city report
        // All the cities in the world organised by largest population to smallest.

        /*System.out.println("\n[*] All the cities in the world organised by largest population to smallest.[*] \n");
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

        // Top N populated cities
        //All the top cities in the world organised by largest population to smallest
        System.out.println("\n[*]All the top cities in the world organised by largest population to smallest.\n");
        ArrayList<City> city6 = a.getTopCityPopLargesttoSmallest(10);
        a.displayCity(city6);


        // Top N populated cities
        //The top N populated cities in a continent where N is provided by the user
        System.out.println("\n[*]All The Top City Continent Population Largest to Smallest.\n");
        ArrayList<City> city7 = a.getTopCityContinentPopLargesttoSmallest("Asia", 10);
        a.displayCity(city7);

        //The top N populated cities in a region where N is provided by the user
        System.out.println("\n[*]All The Top City Region Population Largest to Smallest.\n");
        ArrayList<City> city8 = a.getTopCityRegionPopLargesttoSmallest("Caribbean", 10);
        a.displayCity(city8);

        //The top N populated cities in a country where N is provided by the user.
        System.out.println("\n[*]All The Top City Country Population Largest to Smallest.\n");
        ArrayList<City> city9 = a.getTopCityCountryPopLargesttoSmallest("Japan", 10);
        a.displayCity(city9);

        //The top N populated cities in a district where N is provided by the user
        System.out.println("\n[*]All The Top City District Population Largest to Smallest.\n");
        ArrayList<City> city10 = a.getTopCityDistrictPopLargesttoSmallest("Noord-Brabant", 10);
        a.displayCity(city10);


        // CapitalCity report
        // All the Capital City in the world organised by largest population to smallest
        System.out.println("\n[*] All the Capital City in the world organised by largest population to smallest.\n");
        a.displayCapitalCity(a.getCapitalCityPopLargesttoSmallest());

        // All the Capital City in the Continent by largest population to smallest
        System.out.println("\n[*] All the Capital City in the Continent by largest population to smallest.\n");
        a.displayCapitalCity(a.getCapitalCityContinentPopLargesttoSmallest("Asia"));

        // All the Capital City in the Region by largest population to smallest.
        System.out.println("\n[*] All the Capital City in the Region by largest population to smallest.\n");
        a.displayCapitalCity(a.getCapitalCityRegionPopLargesttoSmallest("South America"));

        // Top N populated countires
        //The top N populated countries in the world where N is provided by the user
        System.out.println("\n[*]The top N populated countries in the world where N is provided by the user.\n[*]");
        a.displayCountry(a.getCountryTopNPopLargesttoSmallest(10));

        //The top N populated countries in a continent where N is provided by the user.
        System.out.println("\n[*]The top N populated countries in a continent where N is provided by the user.\n[*]");
        a.displayCountry(a.getCountryTopNPopbyContinent("Asia",6));

        //The top N populated countries in a region where N is provided by the user.
        System.out.println("\n[*]The top N populated countries in a region where N is provided by the user.\n[*]");
        a.displayCountry(a.getCountryTopNPopbyRegion("Caribbean",6));


        // top N populated capital cities report
        //The top N populated capital cities in the world where N is provided by the user.
        System.out.println("\n[*] All the Top Population Capital City in the world organised by largest population to smallest.\n");
        a.displayCapitalCity(a.getTopPopCapitalCityLargesttoSmallest(10));

        //The top N populated capital cities in a continent where N is provided by the user
        System.out.println("\n[*]The top N populated capital cities in a continent where N is provided by the user.\n[*]");
        a.displayCapitalCity(a.getTopPopCapitalCityContinentLargesttoSmallest("Asia",4));

        //The top N populated capital cities in a region where N is provided by the user
        System.out.println("\n[*]The top N populated capital cities in a continent where N is provided by the user.\n[*]");
        a.displayCapitalCity(a. getTopPopCapitalCityRegionLargesttoSmallest("Caribbean",6));*/


        //The top N populated capital cities in a region where N is provided by the user
        System.out.println("\n[*]The top N populated capital cities in a continent where N is provided by the user.\n[*]");
        a.getLanguagePopPerLargesttoSmallest();

        //Summerize Total Population
        System.out.println("[*] All the population in the World");
        a.getPopWorld();
        System.out.println("[*] The population of a Continent");
        a.getPopContinent("Asia");
        System.out.println(("[*] The population of a Region"));
        a.getPopRegion("Southern and Central Asia");
        System.out.println(("[*] The population of a Country"));
        a.getPopCountry("Aruba");
        System.out.println(("[*] The population of a District"));
        a.getPopDistrict("Noord-Brabant");
        System.out.println(("[*] The population of a City"));
        a.getPopCity("Kabul");
      
        //the number of people who speak Chinese, English, Hindi, Spanish, Arabic languages from greatest number to smallest
        System.out.println("\n[*]The the number of people who speak Chinese, English, Hindi, Spanish, Arabic languages from greatest number to smalles.\n[*]");
        a.getLanguagePopPerLargesttoSmallest();
      
        // Population Report
        a.outputPopulation(population,"population.md");
        a.ReportPopulation(a.getCountryPop(),"CountryPopulation.md");
        a.ReportPopulation(a.getContinentPop("Africa"),"ContinentPopulation.md");
        a.ReportPopulation(a.getRegionPop("South America"),"RegionPopulation.md");



        // Report file Generator
        // Country report
        a.outputCountry(a.getCountryPopLargesttoSmallest(), "CountryPopLargesttoSmallest.md");
        a.outputCountry(a.getCountryPopbyContinent("Asia"), "CountryPopbyContinent.md");
        a.outputCountry(a.getCountryPopbyRegion("Caribbean"), "CountryPopbyRegion.md");
        // top N populated Country
        a.outputCountry(a.getCountryTopNPopLargesttoSmallest(10), "CountryTopNPopLargesttoSmallest.md");
        a.outputCountry(a.getCountryTopNPopbyContinent("Asia",6), "CountryTopNPopbyContinent.md");
        a.outputCountry(a.getCountryTopNPopbyRegion("Caribbean",6), "CountryTopNPopbyRegion.md");

        // City report
        a.outputCity(a.getCityPopLargesttoSmallest(), "CityPopLargesttoSmallest.md");
        a.outputCity(a.getCityContinentPopLargesttoSmallest("Africa"), "CityContinentPopLargesttoSmallest.md");
        a.outputCity(a.getCityRegionPopLargesttoSmallest("South America"), "CityRegionPopLargesttoSmallest.md");
        a.outputCity(a.getCityCountryPopLargesttoSmallest("Japan"), "CityCountryPopLargesttoSmallest.md");
        a.outputCity(a.getCityDistrictPopLargesttoSmallest("Noord-Brabant"), "CityDistrictPopLargesttoSmallest.md");
        // top N populated City
        a.outputCity(a.getTopCityPopLargesttoSmallest(10), "TopCityPopLargesttoSmallest.md");
        a.outputCity(a.getTopCityRegionPopLargesttoSmallest("Caribbean", 10), "TopCityRegionPopLargesttoSmallest.md");
        a.outputCity(a.getTopCityContinentPopLargesttoSmallest("Asia", 10), "TopCityContinentPopLargesttoSmallest.md");
        a.outputCity(a.getTopCityCountryPopLargesttoSmallest("Japan", 10), "TopCityCountryPopLargesttoSmallest.md");
        a.outputCity(a.getTopCityDistrictPopLargesttoSmallest("Noord-Brabant", 10), "TopCityDistrictPopLargesttoSmallest.md");

        // Capital City Report
        a.outputCapitalCity(a.getCapitalCityPopLargesttoSmallest(), "CapitalCityPopLargesttoSmallest.md");
        a.outputCapitalCity(a.getCapitalCityContinentPopLargesttoSmallest("Asia"), "CapitalCityContinentPopLargesttoSmallest.md");
        a.outputCapitalCity(a.getCapitalCityRegionPopLargesttoSmallest("South America"), "CapitalCityRegionPopLargesttoSmallest.md");
        // Top N populated Capital City Report
        a.outputCapitalCity(a.getTopPopCapitalCityLargesttoSmallest(10), "TopPopCapitalCityLargesttoSmallest.md");
        a.outputCapitalCity(a.getTopPopCapitalCityContinentLargesttoSmallest("Asia",4), "TopPopCapitalCityContinentLargesttoSmallest.md");
        a.outputCapitalCity(a.getTopPopCapitalCityRegionLargesttoSmallest("Caribbean",6), "TopPopCapitalCityRegionLargesttoSmallest.md");


        


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
    //All the countries in the world organised by largest population to smallest.
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
    //All the countries in a continent organised by largest population to smallest.
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

    //All the countries in a region organised by largest population to smallest.
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

    public ArrayList<Country> getCountryTopNPopLargesttoSmallest(int ci) throws SQLException {

        //
        // Description :
        // report function for Top N countires sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryTopNPopLargesttoSmallest(

        String sql = "SELECT Name,Continent,Region, Capital, Population from country order by Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ci);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Country c = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }


    public ArrayList<Country> getCountryTopNPopbyContinent(String contn, int ci) throws SQLException {

        //
        // Description :
        // report function for Top N countires according to continent sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryTopNPopbyContinent(

        String sql = "SELECT Name,Continent,Region, Capital, Population from country where Continent=? order by Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, ci);
        ArrayList<Country> countries = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Country c = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            countries.add(c);
        }
        return countries;
    }

    public ArrayList<Country> getCountryTopNPopbyRegion(String reg, int re) throws SQLException {

        //
        // Description :
        // report function for Top N countires according to region sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryTopNPopbyRegion(

        String sql = "SELECT Name,Continent,Region, Capital, Population from country where Region=? order by Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        pstmt.setInt(2, re);
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
    //The top N populated cities in the world where N is provided by the user.
    public ArrayList<City> getTopCityPopLargesttoSmallest(int ci) throws SQLException {

        //
        //Description :
        //report function for Top N populated according to the cities sorted from largest population to smallest
        //
        //Usage :
        // object.getTopCityPopLargesttoSmallest(

        String sql = "select ID,Name,CountryCode, District, Population from city order by Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ci);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }

    //The top N populated cities in a continent where N is provided by the user.
    public ArrayList<City> getTopCityContinentPopLargesttoSmallest(String contn, int ci) throws SQLException {

        //
        //Description :
        //report function for Top N populated according to the continent sorted from largest population to smallest
        //
        //Usage :
        // object.getTopCityContinentPopLargesttoSmallest(

        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Continent = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, ci);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }

    //The top N populated cities in a region where N is provided by the use
    public ArrayList<City> getTopCityRegionPopLargesttoSmallest(String reg, int ci) throws SQLException {

        //
        //Description :
        //report function for Top N populated according to the region sorted from largest population to smallest
        //
        //Usage :
        // object.getTopCityRegionPopLargesttoSmallest((

        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Region = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        pstmt.setInt(2, ci);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }

    //The top N populated cities in a country where N is provided by the user.
    public ArrayList<City> getTopCityCountryPopLargesttoSmallest(String country, int ci) throws SQLException {

        //
        //Description :
        //report function for Top N populated according to the country sorted from largest population to smallest
        //
        //Usage :
        // object.getTopCityCountryPopLargesttoSmallest(

        String sql = "select city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Code, country.Region from city, country where city.CountryCode = country.Code And country.Name = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, country);
        pstmt.setInt(2, ci);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }

    //The top N populated cities in a district where N is provided by the user
    public ArrayList<City> getTopCityDistrictPopLargesttoSmallest(String district, int ci) throws SQLException {
        String sql = "select ID,Name,CountryCode, District, Population from city where District = ? order by Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, district);
        pstmt.setInt(2, ci);
        ArrayList<City> cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            City c = new City(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5));
            cities.add(c);
        }
        return cities;

    }






    //Capital City by Population
    public ArrayList<CapitalCity> getCapitalCityPopLargesttoSmallest() throws SQLException {
        //
        // description :
        // report function for capital city in the world from largest to smallest population
        //
        // Usage:
        // object .getCapitalCityPopLargesttoSmallest()

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }
    // Capital City in a continent
    public ArrayList<CapitalCity> getCapitalCityContinentPopLargesttoSmallest(String contn) throws SQLException {
        //
        // description :
        // report function for capital city in selected Continent "Asia" from largest to smallest population
        //
        // Usage:
        // object .getCapitalCityContinentPopLargesttoSmallest("Asia")
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Continent = ? order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    public ArrayList<CapitalCity> getCapitalCityRegionPopLargesttoSmallest(String contn) throws SQLException {
        //
        // description :
        // report function for capital city in selected Region "South America" from largest to smallest population
        //
        // Usage:
        // object .getCapitalCityContinentPopLargesttoSmallest("South America")
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Region = ? order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }


    //The top N populated capital cities in the world where N is provided by the user.
    public ArrayList<CapitalCity> getTopPopCapitalCityLargesttoSmallest(int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in the world from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    //The top N populated capital cities in a continent where N is provided by the user
    public ArrayList<CapitalCity>getTopPopCapitalCityContinentLargesttoSmallest(String contn , int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in continent from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityContinentLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Continent = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    //The top N populated capital cities in a region where N is provided by the user
    public ArrayList<CapitalCity>getTopPopCapitalCityRegionLargesttoSmallest(String reg , int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in region from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityRegionLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Region = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        pstmt.setInt(2, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    public void getLanguagePopPerLargesttoSmallest() throws SQLException {

        //
        // Description :
        // report function for countires sorted from largest population to smallest
        //
        // Usage:
        //  object.getCountryPopLargesttoSmallest()
        String pop = "SELECT SUM(country.Population) From country";
        PreparedStatement pstmts = con.prepareStatement(pop);
        ResultSet rests = pstmts.executeQuery();
        Long w = 0l;
        while (rests.next()){
            w = rests.getLong(1);
            System.out.println(w);}


        String sql = "SELECT countrylanguage.Language, SUM(country.Population) From country, countrylanguage Where country.Code = countrylanguage.CountryCode AND countrylanguage.Language IN ('Chinese','English','Hindi','Spanish','Arabic') AND countrylanguage.IsOfficial = 'T' Group by countrylanguage.Language" ;
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Language> languages = new ArrayList<Language>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {
            Language p = new Language(rset.getString(1), rset.getInt(2));
            languages.add(p);
        }
        displayLanguage(languages,w);
    }

    public void displayLanguage(ArrayList<Language> lag, long w) {

        //
        // Description :
        //  Display function for Capital Cities
        //
        // Usage:
        //  object.displayCountry(Array)


        if (lag == null)
        {
            System.out.println("[system] No Capital cities");
            return;
        }
        System.out.println(String.format("%-20s %-25s %-25s", "Language", "Country Population", "World Population %"));
        // Loop over all city in the list
        for (Language language : lag) {
            if (language == null)
                continue;
            String lag_string =
                    String.format("%-20s %-25s %.2f",
                            language.getLanguage(),  language.getPopper(), 100.0f*language.getPopper()/w);
            System.out.println(lag_string);
        }
    }


    //The top N populated capital cities in the world where N is provided by the user.
    public ArrayList<CapitalCity> getTopPopCapitalCityLargesttoSmallest(int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in the world from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    //The top N populated capital cities in a continent where N is provided by the user
    public ArrayList<CapitalCity>getTopPopCapitalCityContinentLargesttoSmallest(String contn , int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in continent from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityContinentLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Continent = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        pstmt.setInt(2, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    //The top N populated capital cities in a region where N is provided by the user
    public ArrayList<CapitalCity>getTopPopCapitalCityRegionLargesttoSmallest(String reg , int ci) throws SQLException {
        //
        // description :
        // report function for top populated capital city in region from largest to smallest population
        //
        // Usage:
        // object .getTopPopCapitalCityRegionLargesttoSmallest

        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code And country.Capital = city.ID and country.Region = ? order by city.Population desc limit ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        pstmt.setInt(2, ci);
        ArrayList<CapitalCity> capitalcity = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        //String name, String continent, String region, String capital, float population
        while (rset.next()) {

            CapitalCity c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capitalcity.add(c);
        }
        return capitalcity;
    }

    // Summrize Total Population Section

    //Total World Population

    public Float getPopWorld() throws SQLException {
        String sql = "SELECT SUM(country.Population) As Population FROM country \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        //float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;
    }

    //A Continent Population

    public Float getPopContinent(String contn) throws SQLException {
        String sql = "SELECT SUM(country.Population) As Population FROM country where Continent=? \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ResultSet rset = pstmt.executeQuery();
        // float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;

    }

    //A Region (Southen and Central Asia) Population

    public Float getPopRegion(String contn) throws SQLException {
        String sql = "SELECT SUM(country.Population) As Population FROM country where Region=? \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ResultSet rset = pstmt.executeQuery();
        //float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;

    }
    //A Country (Aruba) Population
    public Float getPopCountry(String contn) throws SQLException {
        String sql = "SELECT SUM(country.Population) As Population FROM country where Name=? \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ResultSet rset = pstmt.executeQuery();
        // float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;

    }

    //A District (Noord-Brabant) Population
    public Float getPopDistrict(String contn) throws SQLException {
        String sql = "SELECT SUM(city.Population) As Population FROM country, city where city.District=? \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ResultSet rset = pstmt.executeQuery();
        // float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;

    }

    //A City (Kabul) Population
    public Float getPopCity(String contn) throws SQLException {
        String sql = "SELECT SUM(city.Population) As Population FROM city where city.Name=? \n";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ResultSet rset = pstmt.executeQuery();
        // float population
        Float result = null;
        while (rset.next()) {
            result = rset.getFloat(1);
        }
        return result;
    }

    public void getLanguagePopPerLargesttoSmallest() throws SQLException {

        //
        // Description :
        // report function for language
        //
        // Usage:
        //  object.getLanguagePopPerLargesttoSmallest()
        String pop = "SELECT SUM(country.Population) From country";
        PreparedStatement pstmts = con.prepareStatement(pop);
        ResultSet rests = pstmts.executeQuery();
        Long w = 0l;
        while (rests.next()){
            w = rests.getLong(1);
            System.out.println(w);}


        String sql = "SELECT countrylanguage.Language, SUM(country.Population) From country, countrylanguage Where country.Code = countrylanguage.CountryCode AND countrylanguage.Language IN ('Chinese','English','Hindi','Spanish','Arabic') AND countrylanguage.IsOfficial = 'T' Group by countrylanguage.Language" ;
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Language> languages = new ArrayList<Language>();
        ResultSet rset = pstmt.executeQuery();
        //String language, float popper
        while (rset.next()) {
            Language p = new Language(rset.getString(1), rset.getInt(2));
            languages.add(p);
        }
        displayLanguage(languages,w);
    }





    public void displayCapitalCity(ArrayList<CapitalCity> conts) {

        //
        // Description :
        //  Display function for Capital Cities
        //
        // Usage:
        //  object.displayCountry(Array)


        if (conts == null)
        {
            System.out.println("[system] No Capital cities");
            return;
        }
        System.out.println(String.format("%-20s %-25s %-25s", "Name", "Country", "Population"));
        // Loop over all city in the list
        for (CapitalCity capitalcity : conts) {
            if (capitalcity == null)
                continue;
            String cty_string =
                    String.format("%-20s %-25s %-25s",
                            capitalcity.getName(),  capitalcity.getCountry(), capitalcity.getPopulation());
            System.out.println(cty_string);
        }
    }

    public void displayLanguage(ArrayList<Language> lag, long w) {

        //
        // Description :
        //  Display function for language
        //
        // Usage:
        //  object.displayLanguage(Array)


        if (lag == null)
        {
            System.out.println("[system] No Capital cities");
            return;
        }
        System.out.println(String.format("%-20s %-25s %-25s", "Language", "Country Population", "World Population %"));
        // Loop over all language
        for (Language language : lag) {
            if (language == null)
                continue;
            String lag_string =
                    String.format("%-20s %-25s %.2f",
                            language.getLanguage(),  language.getPopper(), 100.0f*language.getPopper()/w);
            System.out.println(lag_string);
        }
    }


    public void displayCity(ArrayList<City> conts) {

        //
        // Description :
        //  Display function for Country
        //
        // Usage:
        //  object.displayCountry(Array)

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


    public void displayPopulation(ArrayList<Population> conts) {

        //
        // Description :
        //  Display function for population
        //
        // Usage:
        //  object.displayPopulation (Array)

        if (conts == null)
        {
            System.out.println("[system] No population");
            return;
        }
        System.out.println(String.format("%-40s %-30s %-30s %-30s", "Country Name", "Country Population", "Living in city Population", "Not living in city Population"));
        // Loop over all city in the list
        for (Population population : conts) {
            if (population == null)
                continue;
            String pop_string =
                    String.format("%-40s %-30s %-30s %-30s",
                            population.getName(), population.getPopulation(), population.getLivingpopulation() + " ("+population.getLiving()+"%)", population.getNotlivingpopulation() + " ("+ population.getNotliving()+"%)");
            System.out.println(pop_string);
        }
    }

    public void displaytotalpop(ArrayList<Country> conts) {

        //
        // Description :
        //  Display function for total population


        if (conts == null) {
            System.out.println("[system] No countires");
            return;
        }
        System.out.println(String.format("%-20s", "Population"));
        // Loop over all city in the list
        for (Country country : conts) {
            if (country == null)
                continue;
            String cty_string =
                    String.format("%-20s", country.getPopulation());
            System.out.println(cty_string);
        }
    }

    public void outputCountry(ArrayList<Country> country, String filename) {
        // Check Country
        if (country == null) {
            System.out.println("[system] No Country");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        //String name, String continent, String region, String capital, float population
        sb.append("| Name | Continent | Region | Capital | Population | \r\n");
        sb.append("| --- | --- | --- | --- | --- |\r\n");
        // Loop over all countries in the list
        for (Country c : country) {
            if (c == null) continue;
            sb.append("| " + c.getName() + " | " +
                    c.getContinent() + " | " + c.getRegion() + " | " +
                    c.getCapital() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new                                 File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputCity(ArrayList<City> city, String filename) {
        // Check City
        if (city == null) {
            System.out.println("[system] No City");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        //| ID | Name | CountryCode | District | Population |
        sb.append("| ID | Name | CountryCode | District | Population | \r\n");
        sb.append("| --- | --- | --- | --- | --- |\r\n");
        // Loop over all countries in the list
        for (City c : city) {
            if (c == null) continue;
            sb.append("| " + c.getID() + " | " +
                    c.getName() + " | " + c.getCountryCode() + " | " +
                    c.getDistrict() + " | " + c.getPopulation() + " |\r\n");
        }
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new                                 File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputCapitalCity(ArrayList<CapitalCity> capitalcity, String filename) {
        // Check CapitalCity
        if (capitalcity == null) {
            System.out.println("[system] No City");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        //| ID | Name | CountryCode | District | Population |
        sb.append("| Name | Country | Population | \r\n");
        sb.append("| --- | --- | --- | \r\n");
        // Loop over all countries in the list
        for (CapitalCity c : capitalcity) {
            if (c == null) continue;
            sb.append(" | " + c.getName() + " | " + c.getCountry() + " | " +
                    c.getPopulation() + " | " + " |\r\n");

        }
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new                                 File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String outputtotalpop(ArrayList<Country> conts, String s) {

        //
        // Description :
        //  Display function for total population


        if (conts == null) {
            System.out.println("[system] No countires");
            return "";
        }
        System.out.println(String.format("%-20s", "Population"));
        // Loop over all city in the list
        String cty_string = null;
        for (Country country : conts) {
            if (country == null)
                continue;
            cty_string = String.format("%-20s", country.getPopulation());
        }
        return cty_string;
    }

    public void outputPopulation(ArrayList<Float> poplist, String filename) {
        // Check CapitalCity
        if (poplist == null) {
            System.out.println("[system] Empty Array");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        //| World | Continent | region | Country | District | City
        sb.append("| World | Continent | region | Country | District | City | \r\n");
        sb.append("| --- | --- | --- | --- | --- | --- | \r\n");
        sb.append(" | " );
        // Loop over all countries in the list
        for (Float p : poplist) {
            if (p == null) continue;
            sb.append( p + " | ");

        }
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new                                 File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void ReportPopulation(ArrayList<Population> populations, String filename) {
        // Check CapitalCity
        if (populations == null) {
            System.out.println("[system] Empty Array");
            return;
        }

        StringBuilder sb = new StringBuilder();
        // Print header
        //| World | Continent | region | Country | District | City
        sb.append("| Name | Population | Living Population | NotLiving Population | \r\n");
        sb.append("| --- | --- | --- | --- | \r\n");

        // Loop over all countries in the list
        for (Population p : populations) {
            if (p == null) continue;
            sb.append(" | " + p.getName() +
                    " | " + p.getPopulation() +
                    " | " + p.getLivingpopulation() +
                    " (" + p.getLiving() +
                    " %)| " + p.getNotlivingpopulation() +
                    " (" + p.getNotliving()
                    + " %) |\r\n");

        }
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new                                 File("./reports/" + filename)));
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }



}