import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
public class MainClass {

 
    public static void main(String[] args) {
        CitiesDAO pDAO = new CitiesDAO();
        List<Cities> cities = pDAO.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\City-country\\src\\city.csv");
        
        System.out.println(String.format("%-20s | %-50s | %-20s | %-30s| %-10s", "City code", "City name", "Contenet","Surface area", "Population"));
        for (Cities citiy : cities){
           System.out.println(String.format("%-20s | %-50s | %-20s | %-30s| %-10s", citiy.getCode(), citiy.getName(), citiy.getContinent(),citiy.getSurface_area(), citiy.getPopulation()));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          CountriesDAO pDAO1 = new CountriesDAO();
        List<Countries> countries = pDAO1.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\City-country\\src\\country.csv");
        
        System.out.println(String.format("%-20s | %-50s | %-20s ", "Contry code","name", "Contenent"));
        for (Countries Country : countries){
           System.out.println(String.format("%-20s | %-50s | %-20s ", Country.getCode(), Country.getName(), Country.getContinent()));
        }
        Map<Integer,List<Cities>> CountryCity =new HashMap<>();
             for (Cities c : cities){
                 if(!CountryCity.containsKey(c.getCode())){
                   List<Cities>city= new ArrayList<>();
                   city.add(c);
                   CountryCity.put(c.getCode(), city); 
                 }
                 else{
                     CountryCity.get(c.getCode()).add(c); 
                 }
        }
            
             
              System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                       
              Iterator<Entry<Integer, List<Cities>>> it = CountryCity.entrySet().iterator();

        it.forEachRemaining((maxcity) -> {

            try {
                Cities max = maxcity.getValue().stream()
                        .max((Cities c1, Cities c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())).get();

                System.out.print(maxcity.getKey() + ": " + max.getName());

                System.out.println();
            } catch (NoSuchElementException e) {
                System.out
                .println(maxcity.getKey() + " has no cities ");
            }
        });

              System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

              System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
              Iterator<Entry<Integer, List<Cities>>> it1 = CountryCity.entrySet().iterator();
              
        it1.forEachRemaining((maxcontenet) -> {

            try {
                Cities max = maxcontenet.getValue().stream()
                        .max((Cities c1, Cities c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())).get();
                 int onetime=1;
                if(onetime==1){
                    System.out.print(maxcontenet.getKey() + ": " + max.getContinent() +"    :   "+ max.getPopulation());
                    System.out.println();
                    onetime=onetime+1;    
                }
                        

            } catch (NoSuchElementException e) {
                System.out
                .println(maxcontenet.getKey() + " has no Continent ");
            }
        });
        
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
    }
    
}
