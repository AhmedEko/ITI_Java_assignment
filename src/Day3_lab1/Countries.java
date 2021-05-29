package Day3_lab1;


public class Countries {
        private int code;
    private String name;
    private String continent;

    public Countries(int code, String name, String continent) {
        this.code = code;
        this.name = name;
        this.continent = continent;
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
    
}
