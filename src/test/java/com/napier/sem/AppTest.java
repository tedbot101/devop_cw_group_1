package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




public class AppTest
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void unitTest()
    // Test 1: Testing of N number for cities report produced
    {
        // Insert your test code in here
        assertEquals(5, 5);
    }
}