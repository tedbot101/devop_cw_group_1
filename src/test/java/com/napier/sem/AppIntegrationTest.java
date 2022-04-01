package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testCountryPopLargesttoSmallest() throws SQLException {

        // Test CountryPopLargesttoSmallest record

        // testing only one instance
        Country unit1 = app.getCountryPopLargesttoSmallest().get(0);
        assertEquals(unit1.getName(),"China");
        assertEquals(unit1.getContinent(),"Asia");
        assertEquals(unit1.getRegion(),"Eastern Asia");
        assertEquals(unit1.getCapital(),"1891");
        assertEquals(unit1.getPopulation(),1.277558016E9 );

    }

    @Test
    void testgetCountryPopbyContinent() throws SQLException {

        // Test CountryPopbyContinent record

        // testing only one instance
        Country unit2 = app.getCountryPopbyContinent("Asia").get(0);
        assertEquals(unit2.getName(),"China");
        assertEquals(unit2.getContinent(),"Asia");
        assertEquals(unit2.getRegion(),"Eastern Asia");
        assertEquals(unit2.getCapital(),"1891");
        assertEquals(unit2.getPopulation(),1.277558016E9 );


    }

    @Test
    void testgetCountryPopbyRegion() throws SQLException {

        // Test CountryPopbyRegion record

        // testing only one instance
        Country unit3 = app.getCountryPopbyRegion("Caribbean").get(0);
        assertEquals(unit3.getName(),"Cuba");
        assertEquals(unit3.getContinent(),"North America");
        assertEquals(unit3.getRegion(),"Caribbean");
        assertEquals(unit3.getCapital(),"2413");
        assertEquals(unit3.getPopulation(),1.1201E7 );

    }

    @Test
    void testgetCityPopLargesttoSmallest() throws SQLException {

        // Test getCityPopLargesttoSmallest record

        // testing only one instance
        City unit4 = app.getCityPopLargesttoSmallest().get(0);
        assertEquals(unit4.getID(),1024);
        assertEquals(unit4.getName(),"Mumbai (Bombay)");
        assertEquals(unit4.getCountryCode(),"IND");
        assertEquals(unit4.getDistrict(),"Maharashtra");
        assertEquals(unit4.getPopulation(),1.05E7 );

    }

    @Test
    void testgetCityContinentPopLargesttoSmallest() throws SQLException {

        // Test getCityContinentPopLargesttoSmallest record

        // testing only one instance
        City unit5 = app.getCityContinentPopLargesttoSmallest("Africa").get(0);
        assertEquals(unit5.getID(),608);
        assertEquals(unit5.getName(),"Cairo");
        assertEquals(unit5.getCountryCode(),"EGY");
        assertEquals(unit5.getDistrict(),"Kairo");
        assertEquals(unit5.getPopulation(),6789479.0 );

    }
    @Test
    void testgetCityRegionPopLargesttoSmallest() throws SQLException {

        // Test testgetCityRegionPopLargesttoSmallest record

        // testing only one instance
        City unit5 = app.getCityRegionPopLargesttoSmallest("South America").get(0);
        assertEquals(unit5.getID(),206);
        assertEquals(unit5.getName(),"São Paulo");
        assertEquals(unit5.getCountryCode(),"BRA");
        assertEquals(unit5.getDistrict(),"São Paulo");
        assertEquals(unit5.getPopulation(),9968485.0 );

    }

    @Test
    void testgetCityCountryPopLargesttoSmallest() throws SQLException {

        // Test testgetCityCountryPopLargesttoSmallest record

        // testing only one instance
        City unit6 = app.getCityCountryPopLargesttoSmallest("Japan").get(0);
        assertEquals(unit6.getID(),1532);
        assertEquals(unit6.getName(),"Tokyo");
        assertEquals(unit6.getCountryCode(),"JPN");
        assertEquals(unit6.getDistrict(),"Tokyo-to");
        assertEquals(unit6.getPopulation(),7980230.0 );

    }

    @Test
    void testgetCityDistrictPopLargesttoSmallest() throws SQLException {

        // Test testgetCityDistrictPopLargesttoSmallest record

        // testing only one instance
        City unit7 = app.getCityDistrictPopLargesttoSmallest("Noord-Brabant").get(0);
        assertEquals(unit7.getID(),9);
        assertEquals(unit7.getName(),"Eindhoven");
        assertEquals(unit7.getCountryCode(),"NLD");
        assertEquals(unit7.getDistrict(),"Noord-Brabant");
        assertEquals(unit7.getPopulation(),201843.0 );

    }

    @Test
    void testgetTopCityPopLargesttoSmallest() throws SQLException {

        // Test getCityPopLargesttoSmallest record

        // testing only one instance
        City unit15 = app.getTopCityPopLargesttoSmallest(10).get(0);
        assertEquals(unit15.getID(),1024);
        assertEquals(unit15.getName(),"Mumbai (Bombay)");
        assertEquals(unit15.getCountryCode(),"IND");
        assertEquals(unit15.getDistrict(),"Maharashtra");
        assertEquals(unit15.getPopulation(),1.05E7 );

    }

    @Test
    void testgetTopCityContinentPopLargesttoSmallest() throws SQLException {

        // Test getCityContinentPopLargesttoSmallest record

        // testing only one instance
        City unit16 = app.getTopCityContinentPopLargesttoSmallest("Africa", 1).get(0);
        assertEquals(unit16.getID(),608);
        assertEquals(unit16.getName(),"Cairo");
        assertEquals(unit16.getCountryCode(),"EGY");
        assertEquals(unit16.getDistrict(),"Kairo");
        assertEquals(unit16.getPopulation(),6789479.0 );

    }
    @Test
    void testTopgetCityRegionPopLargesttoSmallest() throws SQLException {

        // Test testgetCityRegionPopLargesttoSmallest record

        // testing only one instance
        City unit17 = app.getTopCityRegionPopLargesttoSmallest("South America", 1).get(0);
        assertEquals(unit17.getID(),206);
        assertEquals(unit17.getName(),"São Paulo");
        assertEquals(unit17.getCountryCode(),"BRA");
        assertEquals(unit17.getDistrict(),"São Paulo");
        assertEquals(unit17.getPopulation(),9968485.0 );

    }

    @Test
    void testgetTopCityCountryPopLargesttoSmallest() throws SQLException {

        // Test testgetCityCountryPopLargesttoSmallest record

        // testing only one instance
        City unit18 = app.getTopCityCountryPopLargesttoSmallest("Japan", 1).get(0);
        assertEquals(unit18.getID(),1532);
        assertEquals(unit18.getName(),"Tokyo");
        assertEquals(unit18.getCountryCode(),"JPN");
        assertEquals(unit18.getDistrict(),"Tokyo-to");
        assertEquals(unit18.getPopulation(),7980230.0 );

    }

    @Test
    void testgetTopCityDistrictPopLargesttoSmallest() throws SQLException {

        // Test testgetCityDistrictPopLargesttoSmallest record

        // testing only one instance
        City unit19 = app.getTopCityDistrictPopLargesttoSmallest("Noord-Brabant", 1).get(0);
        assertEquals(unit19.getID(),9);
        assertEquals(unit19.getName(),"Eindhoven");
        assertEquals(unit19.getCountryCode(),"NLD");
        assertEquals(unit19.getDistrict(),"Noord-Brabant");
        assertEquals(unit19.getPopulation(),201843.0 );

    }


}