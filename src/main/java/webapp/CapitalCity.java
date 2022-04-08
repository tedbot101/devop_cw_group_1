package webapp;

public class CapitalCity {

   private String name;
   private String country;
   private float population;

    public CapitalCity(String name, String country, float population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public CapitalCity() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public float getPopulation() {
        return population;
    }
}
