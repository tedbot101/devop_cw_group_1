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
        System.out.println("In main");

        // city report
        // All the cities in the world organised by largest population to smallest.
        /*System.out.println("*******************************\n\n\nAll the cities in the world organised by largest population to smallest.\n");
        System.out.println("*******************************\n\n\n");
        ArrayList<City> city1 = a.getCityPopLargesttoSmallest();
        a.display(city1);

        // All the cities in the continent organised by largest population to smallest
        System.out.println("*******************************\n\n\nAll the cities in the continent organised by largest population to smallest.\n");
        System.out.println("*******************************\n\n\n");
        ArrayList<City> city2 = a.getCityContinentPopLargesttoSmallest("Africa");
        a.display(city2);

        // All the cities in the region organised by largest population to smallest
        System.out.println("*******************************\n\n\nAll the cities in the region organised by largest population to smallest.\n");
        System.out.println("*******************************\n\n\n");
        ArrayList<City> city3 = a.getCityRegionPopLargesttoSmallest("South America");
        a.display(city3);

        // All the cities in a country organised by largest population to smallest
        System.out.println("*******************************\n\n\nAll the cities in a country organised by largest population to smallest.\n");
        System.out.println("*******************************\n\n\n");
        ArrayList<City> city4 = a.getCityCountryPopLargesttoSmallest("Japan");
        a.display(city4);

        // All the cities in a district organised by largest population to smallest.
        System.out.println("*******************************\n\n\nAll the cities in a district organised by largest population to smallest.\n");
        System.out.println("*******************************\n\n\n");
        ArrayList<City> city5 = a.getCityDistrictPopLargesttoSmallest("Noord-Brabant");
        a.display(city5);

        // country report
        // the countries in the world organised by largest population to smallest
        System.out.println("\n\n\n*****************************************************\nAll the countries in the world organised by largest population to smallest.\n");
        ArrayList<Country> contries = a.getCountryPopLargesttoSmallest();
        a.display_1(contries);

        // the countries in a continent organised by largest population to smallest
        System.out.println("\n\n*****************************************************\nAll the countries in a continent organised by largest population to smallest\n");
        ArrayList<Country> contries2 = a.getCountryPopbyContinent("Asia");
        a.display_1(contries2);

        // the countries in a region organised by largest population to smallest
        System.out.println("\n\n*****************************************************\nAll the countries in a region organised by largest population to smallest\n");
        ArrayList<Country> contries3 = a.getCountryPopbyRegion("Caribbean");
        a.display_1(contries3);*/

        //All the top cities in the world organised by largest population to smallest
        System.out.println("\n[*]All the top cities in the world organised by largest population to smallest.\n");
        ArrayList<City> city6 = a.getTopCityPopLargesttoSmallest(10);
        a.display(city6);

        //The top N populated cities in a continent where N is provided by the user
        System.out.println("\n[*]All The Top City Continent Population Largest to Smallest.\n");
        ArrayList<City> city7 = a.getTopCityContinentPopLargesttoSmallest("Asia", 10);
        a.display(city7);

        //The top N populated cities in a region where N is provided by the user
        System.out.println("\n[*]All The Top City Region Population Largest to Smallest.\n");
        ArrayList<City> city8 = a.getTopCityRegionPopLargesttoSmallest("Caribbean", 10);
        a.display(city8);

        //The top N populated cities in a country where N is provided by the user.
        System.out.println("\n[*]All The Top City Country Population Largest to Smallest.\n");
        ArrayList<City> city9 = a.getTopCityCountryPopLargesttoSmallest("Japan", 10);
        a.display(city9);

        //The top N populated cities in a district where N is provided by the user
        System.out.println("\n[*]All The Top City District Population Largest to Smallest.\n");
        ArrayList<City> city10 = a.getTopCityDistrictPopLargesttoSmallest("Noord-Brabant", 10);
        a.display(city10);



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





    public void display_1(ArrayList<Country> conts) {
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

    public void display(ArrayList<City> conts) {
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