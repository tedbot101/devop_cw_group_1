package com.napier.sem;

import org.junit.jupiter.api.*;
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
        /// test function for display city function
        app.displayCity(null);
    }

    @Test
    void DisplayCountryTest_null()
    {
        /// test function for display country function
        app.displayCountry(null);
    }
}