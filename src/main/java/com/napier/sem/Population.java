package com.napier.sem;

public class Population {
    public Population(String name, int population, int livingpopulation, float living, int notlivingpopulation, float notliving) {
        this.name = name;
        this.population = population;
        this.livingpopulation = livingpopulation;
        this.living = living;
        this.notlivingpopulation = notlivingpopulation;
        this.notliving = notliving;
    }
    /*Code.
                Country Name.
                Country Population.
                Living in city Population.
                Living in city Population percentage.
                Not Living in city Population.
                Not Living in city Population percentage. */
    private String name;
    private int population;
    private int livingpopulation;
    private float living;
    private int notlivingpopulation;
    private float notliving;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLivingpopulation() {
        return livingpopulation;
    }

    public void setLivingpopulation(int livingpopulation) {
        this.livingpopulation = livingpopulation;
    }

    public int getNotlivingpopulation() {
        return notlivingpopulation;
    }

    public void setNotlivingpopulation(int notlivingpopulation) {
        this.notlivingpopulation = notlivingpopulation;
    }

    public float getLiving() {
        return living;
    }

    public void setLiving(float living) {
        this.living = living;
    }

    public float getNotliving() {
        return notliving;
    }

    public void setNotliving(float notliving) {
        this.notliving = notliving;
    }
}
