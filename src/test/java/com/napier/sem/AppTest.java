package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


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
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCity(cities);
    }

    @Test
    void DisplayCountryTest_Empty()
    {
        /// test if return value is empty array
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountry(countries);
    }
}