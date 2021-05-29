package Day3_lab4;




public class Pyramids {
    private String pharoh; 
    private String modern_name;
    private String site;
    private Double hight;

    public Pyramids(String pharoh, String modern_name, String site, Double hight) {
        this.pharoh = pharoh;
        this.modern_name = modern_name;
        this.site = site;
        this.hight = hight;
    }

    public String getPharoh() {
        return pharoh;
    }

    public void setPharoh(String pharoh) {
        this.pharoh = pharoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getHight() {
        return hight;
    }

    public void setHight(Double hight) {
        this.hight = hight;
    }

   
}
