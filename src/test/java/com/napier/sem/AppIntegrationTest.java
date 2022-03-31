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

}