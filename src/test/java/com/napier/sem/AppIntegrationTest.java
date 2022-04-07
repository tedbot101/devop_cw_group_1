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

    void testgetCapitalCityPopLargesttoSmallest() throws SQLException {

        // Test testgetCapitalCityPopLargesttoSmallest record

        // testing only one instance
        CapitalCity unit8 = app.getCapitalCityPopLargesttoSmallest().get(0);
        assertEquals(unit8.getName(),"Seoul");
        assertEquals(unit8.getCountry(),"South Korea");
        assertEquals(unit8.getPopulation(),9981619);
    }

    @Test
    void testgetCapitalCityContinentPopLargesttoSmallest() throws SQLException {

        // Test testgetCapitalCityContinentPopLargesttoSmallest record

        // testing only one instance
        CapitalCity unit9 = app.getCapitalCityContinentPopLargesttoSmallest("Asia").get(0);
        assertEquals(unit9.getName(),"Seoul");
        assertEquals(unit9.getCountry(),"South Korea");
        assertEquals(unit9.getPopulation(),9981619);
    }
    @Test
    void testgetCapitalCityRegionPopLargesttoSmallest() throws SQLException {

        // Test testgetCapitalCityRegionPopLargesttoSmallest record

        // testing only one instance
        CapitalCity unit9 = app.getCapitalCityRegionPopLargesttoSmallest("Eastern Asia").get(0);
        assertEquals(unit9.getName(),"Seoul");
        assertEquals(unit9.getCountry(),"South Korea");
        assertEquals(unit9.getPopulation(),9981619);
    }





    @Test
    void testgetCountryTopNPopLargesttoSmallest() throws SQLException {

        // Test CountryPopLargesttoSmallest record

        // testing only one instance
        Country unit11 = app.getCountryTopNPopLargesttoSmallest(10).get(0);
        assertEquals(unit11.getName(),"China");
        assertEquals(unit11.getContinent(),"Asia");
        assertEquals(unit11.getRegion(),"Eastern Asia");
        assertEquals(unit11.getCapital(),"1891");
        assertEquals(unit11.getPopulation(),1.277558016E9 );

    }

    @Test
    void testgetCountryTopNPopbyContinent() throws SQLException {

        // Test CountryPopLargesttoSmallest record

        // testing only one instance
        Country unit11 = app.getCountryTopNPopbyContinent("Asia",6).get(0);
        assertEquals(unit11.getName(),"China");
        assertEquals(unit11.getContinent(),"Asia");
        assertEquals(unit11.getRegion(),"Eastern Asia");
        assertEquals(unit11.getCapital(),"1891");
        assertEquals(unit11.getPopulation(),1.277558016E9 );

    }

    @Test
    void testgetCountryTopNPopbyRegion() throws SQLException {

        // Test CountryPopLargesttoSmallest record

        // testing only one instance
        Country unit11 = app.getCountryTopNPopbyRegion("Caribbean",6).get(0);
        assertEquals(unit11.getName(),"Cuba");
        assertEquals(unit11.getContinent(),"North America");
        assertEquals(unit11.getRegion(),"Caribbean");
        assertEquals(unit11.getCapital(),"2413");
        assertEquals(unit11.getPopulation(),1.1201E7 );

    }

    @Test
    void testgetCountryPop() throws SQLException {

        Population unit12 = app.getCountryPop().get(0);
        // testing only one instance
        assertEquals(unit12.getName(),"China");
        assertEquals(unit12.getPopulation(),1277558000);
        assertEquals(unit12.getLivingpopulation(),171180941);
        assertEquals(unit12.getNotlivingpopulation(),1106377059);


    }

    @Test
    void testgetContinentPop() throws SQLException {


        Population unit12 = app.getContinentPop("Africa").get(0);
        // testing only one instance
        assertEquals(unit12.getName(),"Nigeria");
        assertEquals(unit12.getPopulation(),111506000);
        assertEquals(unit12.getLivingpopulation(),17366900);
        assertEquals(unit12.getNotlivingpopulation(),94139100);

    }

    @Test
    void testgetRegionPop() throws SQLException {

        Population unit12 = app.getRegionPop("South America").get(0);
        // testing only one instance
        assertEquals(unit12.getName(),"Brazil");
        assertEquals(unit12.getPopulation(),170115000);
        assertEquals(unit12.getLivingpopulation(),85751265);
        assertEquals(unit12.getNotlivingpopulation(),84363735);

    }


}