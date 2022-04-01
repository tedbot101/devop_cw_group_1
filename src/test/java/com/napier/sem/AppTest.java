package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        // app instance
        app = new App();
    }

    @Test

    void DisplayCapitalCityTest_null()
    {
        /// test if return value is null
        app.displayCapitalCity(null);
    }


    @Test
    void DisplayCityTest_null()
    {
        /// test if return value is null
        app.displayCity(null);
    }

    @Test
    void DisplayCountryTest_null()
    {
        /// test if return value is null
        app.displayCountry(null);
    }

    @Test
    void DisplayCityTest_Empty()
    {
        /// test if return value is empty array
        ArrayList<City> cities = new ArrayList<>();
        app.displayCity(cities);
    }

    @Test
    void DisplayCountryTest_Empty()
    {
        /// test if return value is empty array
        ArrayList<Country> countries = new ArrayList<>();
        app.displayCountry(countries);
    }

    @Test

    void DisplayTopCapitalCityTest_null()
    {
        /// test if return value is null
        app.displayCapitalCity(null);
    }



    @Test
    void DisplayCityTest_ContainsNull()
    {
        /// test if the array contains null var
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.displayCity(cities);
    }

    @Test
    void DisplayCountryTest_ContainsNull()
    {
        /// test if the array contains null var
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.displayCountry(countries);
    }

    @Test
    void DisplayTopCapitalCityTest_ContainsNull()
    {
        /// test if the array contains null var
        ArrayList<CapitalCity> capitalcity = new ArrayList<>();
        capitalcity.add(null);
        app.displayCapitalCity(capitalcity);
    }


    @Test
    void printCountries()
    {
        /// test for normal condition Country
        ArrayList<Country> countries = new ArrayList<>();
        Country ctry = new Country();
        ctry.setName("China");
        ctry.setContinent("Asia");
        ctry.setRegion("Eastern Asia");
        ctry.setCapital("1891");
        ctry.setPopulation((float) 1.27755802E9);
        countries.add(ctry);
        app.displayCountry(countries);
    }

    @Test
    void printCities()
    {
        /// test for normal condition City
        ArrayList<City> cities = new ArrayList<>();
        City cty = new City();
        cty.setID(1024);
        cty.setName("China");
        cty.setCountryCode("IND");
        cty.setDistrict("Maharashtra");
        cty.setPopulation((float) 1.05E7);
        cities.add(cty);
        app.displayCity(cities);
    }

    @Test
    void printTopCapitalCity()
    {
        /// test for normal condition TopCapitalCity
        ArrayList<CapitalCity> capitalcity = new ArrayList<>();
        CapitalCity cap = new CapitalCity();
        cap.setName("Seoul");
        cap.setCountry("South Korea");
        cap.setPopulation((float) 9981619);
        capitalcity.add(cap);
        app.displayCapitalCity(capitalcity);
    }

}