package Day3_lab3;


public class Cities {
    private int code;
    private String name;
    private String continent;
    private double surface_area;
    private int population;
    private boolean capital;


    public Cities(int code, String name, String continent, double surface_area, int population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surface_area = surface_area;
        this.population = population;
    }

    public Cities(int code, String name, String continent, double surface_area, int population, boolean capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surface_area = surface_area;
        this.population = population;
        this.capital = capital;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(double surface_area) {
        this.surface_area = surface_area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }


    
        @Override
    public String toString() {
        return getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
