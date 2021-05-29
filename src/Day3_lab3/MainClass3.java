package Day3_lab3;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass3 {

 
    public static void main(String[] args) {
        CitiesDAO pDAO = new CitiesDAO();
        List<Cities> cities = pDAO.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\ITI_G8_JAVA_SE_Assignments\\src\\Day3_lab3\\city.csv");
        
        System.out.println(String.format("%-20s | %-50s | %-20s | %-30s| %-10s    | %-20s", "City code", "City name", "Contenet","Surface area", "Population","Captial"));
        for (Cities citiy : cities){
        System.out.println(String.format("%-20s | %-50s | %-20s | %-30s| %-10s | %-20s", citiy.getCode(), citiy.getName(), citiy.getContinent(),citiy.getSurface_area(), citiy.getPopulation(),citiy.isCapital()));
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
             //stream starts


        System.out.println(String.format("%-20s | %-30s | %-20s %-1s", "City code","City name","Population","\n"));
        Iterator<Entry<Integer, List<Cities>>> it = CountryCity.entrySet().iterator();
        it.forEachRemaining((maxcity)->{
            Cities max = maxcity.getValue().stream()
                    .max((Cities c1, Cities c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())).get();
            System.out.println(String.format("%-20s | %-30s | %-20s  %-1s ", maxcity.getKey(), max.getName(),max.getPopulation(),"\n"));

        });



// list of cities by country
        Iterator<Entry<Integer, List<Cities>>> it1 = CountryCity.entrySet().iterator();
        it1.forEachRemaining((continentCtyPair) -> {


                Cities maxPop = continentCtyPair.getValue().stream()
                        .max((Cities c1, Cities c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation())).get();

                System.out.print(continentCtyPair.getKey() + ": " + maxPop.getName()+maxPop.getContinent());

                System.out.println();

        });




        Map<String, List<Cities>> collect = cities
                .stream() // list of cities by contenent

                .collect(Collectors.groupingBy(Cities::getContinent));

        List<Integer> collect1 = cities
                .stream()
                .map(Cities::getPopulation)
                .sorted().collect(Collectors.toList());


        System.out.println(collect);
        System.out.println(collect1);

        Map<Boolean, List<Cities>> capitalture_false = cities
                .stream()
                .collect(Collectors.groupingBy(Cities::isCapital));


        List<Integer> capitalture_false1 = cities
                .stream()
                .map(Cities::getPopulation)

                .sorted().collect(Collectors.toList());
        System.out.println(capitalture_false);





    }

}
