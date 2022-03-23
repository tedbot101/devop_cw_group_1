package com.napier.sem;

public class City {
    private Integer ID;
    private String Name;
    private String CountryCode;
    private String District;

    public City(Integer ID, String name, String countryCode, String district, float population) {
        this.ID = ID;
        Name = name;
        CountryCode = countryCode;
        District = district;
        Population = population;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public void setPopulation(float population) {
        Population = population;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public float getPopulation() {
        return Population;
    }

    private float Population;
}
