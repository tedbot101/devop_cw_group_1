package webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@SpringBootApplication
@RestController
public class App {

    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;

    public static void main(String[] args) throws SQLException {

        if(args.length < 1){
            // Connect to database
            connect("localhost:33060", 30000);
        }else{
            connect("db:3306", 30000);
        }

        SpringApplication.run(App.class, args);

    }

    /**
     * Connect to the MySQL database.
     */
    public static void connect(String conString, int delay) {
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
    public static void disconnect() {
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
    @RequestMapping("CountryPopLargesttoSmallest")
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
    @RequestMapping("CountryPopbyContinent")
    public ArrayList<Country> getCountryPopbyContinent(@RequestParam(value = "continent") String contn) throws SQLException {

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
    @RequestMapping("CountryPopbyRegion")
    public ArrayList<Country> getCountryPopbyRegion(@RequestParam(value = "region") String reg) throws SQLException {

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

    @RequestMapping("CountryTopNPopLargesttoSmallest")
    public ArrayList<Country> getCountryTopNPopLargesttoSmallest(@RequestParam(value = "n")int ci) throws SQLException {

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

    @RequestMapping("CountryTopNPopbyContinent")
    public ArrayList<Country> getCountryTopNPopbyContinent(@RequestParam(value = "continent")String contn, @RequestParam(value = "n")int ci) throws SQLException {

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


    @RequestMapping("CountryTopNPopbyRegion")
    public ArrayList<Country> getCountryTopNPopbyRegion(@RequestParam(value = "region") String reg,@RequestParam(value = "n") int re) throws SQLException {

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

    public ArrayList<Population>getCountryPop() throws SQLException {

        //
        // Description :
        // report function for population of people, people living in cities, and people not living in cities in each country
        //
        // Usage:
        //  object.getCountryPop()


        String sql = "SELECT country.Name, country.Population,SUM(DISTINCT city.Population), (SUM(DISTINCT city.Population)/country.Population)*100, country.Population-SUM(DISTINCT city.Population),((country.Population-SUM(DISTINCT city.Population))/country.Population)*100 FROM city, country WHERE country.Code = city.CountryCode GROUP BY country.Name, country.Population order by country.Population DESC";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ArrayList<Population> population = new ArrayList<Population>();
        ResultSet rset = pstmt.executeQuery();
        //private String name, int populatin, int livingpopulation, float living, int notlivingpopulation, float notliving;
        while (rset.next()) {
            Population p = new Population(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getFloat(4), rset.getInt(5), rset.getFloat(6));
            population.add(p);
        }
        return population;
    }

    public ArrayList<Population>getContinentPop(String contn) throws SQLException {

        //
        // Description :
        // report function for population of people, people living in cities, and people not living in cities in each Continent
        //
        // Usage:
        //  object.getContinentPop()


        String sql = "SELECT country.Name, country.Population,SUM(DISTINCT city.Population), (SUM(DISTINCT city.Population)/country.Population)*100, country.Population-SUM(DISTINCT city.Population),((country.Population-SUM(DISTINCT city.Population))/country.Population)*100 FROM city, country WHERE country.Code = city.CountryCode And country.Continent = ? GROUP BY country.Name, country.Population order by country.Population DESC";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, contn);
        ArrayList<Population> population = new ArrayList<Population>();
        ResultSet rset = pstmt.executeQuery();
        //private String name, int populatin, int livingpopulation, float living, int notlivingpopulation, float notliving;
        while (rset.next()) {
            Population p = new Population(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getFloat(4), rset.getInt(5), rset.getFloat(6));
            population.add(p);
        }
        return population;
    }

    public ArrayList<Population>getRegionPop(String reg) throws SQLException {

        //
        // Description :
        // report function for population of people, people living in cities, and people not living in cities in each Continent
        //
        // Usage:
        //  object.getContinentPop()


        String sql = "SELECT country.Name, country.Population,SUM(DISTINCT city.Population), (SUM(DISTINCT city.Population)/country.Population)*100, country.Population-SUM(DISTINCT city.Population),((country.Population-SUM(DISTINCT city.Population))/country.Population)*100 FROM city, country WHERE country.Code = city.CountryCode And country.Region = ? GROUP BY country.Name, country.Population order by country.Population DESC";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reg);
        ArrayList<Population> population = new ArrayList<Population>();
        ResultSet rset = pstmt.executeQuery();
        //private String name, int populatin, int livingpopulation, float living, int notlivingpopulation, float notliving;
        while (rset.next()) {
            Population p = new Population(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getFloat(4), rset.getInt(5), rset.getFloat(6));
            population.add(p);
        }
        return population;
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



    public void displayCity(ArrayList<City> conts) {

        //
        // Description :
        //  Display function for City
        //
        // Usage:
        //  object.displayCity(Array)

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