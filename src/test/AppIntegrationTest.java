package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    void testGetCountry()
    {
        // Test country record

        Country ctry = app.getCountry('China');
        //String name, String continent, String region, String capital, float population
        assertEquals(ctry.Name, 'China');
        assertEquals(ctry.continent, "Asia");
        assertEquals(ctry.region, "Eastern Asia");
        assertEquals(ctry.capital, "1891");
        assertEquals(ctry.population, (float) 1.27755802E9);

    }

}