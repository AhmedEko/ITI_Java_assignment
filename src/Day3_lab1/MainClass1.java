package Day3_lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class MainClass1 {

 
    public static void main(String[] args) {
        CitiesDAO pDAO = new CitiesDAO();
        // Exsersice 1
        //Read from csv file
        List<Cities> cities = pDAO.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\ITI_G8_JAVA_SE_Assignments\\src\\Day3_lab1\\city.csv");
        //print csv files
        cities.forEach((citiy) -> {
            System.out.println(String.format("%-20s | %-50s | %-20s | %-30s| %-10s", citiy.getCode(), citiy.getName(), citiy.getContinent(),citiy.getSurface_area(), citiy.getPopulation()));
        });
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          CountriesDAO pDAO1 = new CountriesDAO();
        List<Countries> countries = pDAO1.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\City-country\\src\\country.csv");              
        countries.forEach((Country) -> {
            System.out.println(String.format("%-20s | %-50s | %-20s ", Country.getCode(), Country.getName(), Country.getContinent()));
        }); //hash map ceration
        
        Map<Integer,List<Cities>> CountryCity =new HashMap<>();
        cities.forEach((c) -> {
            if(!CountryCity.containsKey(c.getCode())){
                List<Cities>city= new ArrayList<>();
                city.add(c);
                CountryCity.put(c.getCode(), city);
            }
            else{
                CountryCity.get(c.getCode()).add(c);
            }
        });
             System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");

              CountryCity.forEach((k, v) ->
             System.out.println("key=" + k + ", value=" + v));
               System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
  
              
             Iterator<Integer> iter =CountryCity.keySet().iterator();
             iter.forEachRemaining(key->{
                 CountryCity.get(key).sort((i1,i2)->{
                 if(i1.getPopulation()<i2.getPopulation())
                     return 1;
                 else if (i1.getPopulation()==i2.getPopulation()) 
                     return 0;
                    return -1;
                 
             });
                 
             });
             // end of lap 1
             // start lap 2
              System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       
                      // CountryCity.forEach((k, v) ->
             //System.out.println("key=" + k + ", value=" + v));
         
        
        
    }
    
}
