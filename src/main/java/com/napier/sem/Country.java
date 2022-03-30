package com.napier.sem;

public class Country {
            /*Code.
            Name.
            Continent.
            Region.
            Population.
            Capital. */
    private String name;
    private String continent;
    private String region;
    private String capital;
    private float population;

    public Country() {

    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Country(String name, String continent, String region, String capital, float population) {
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.capital = capital;
        this.population = population;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getCapital() {
        return capital;
    }

    public float getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
