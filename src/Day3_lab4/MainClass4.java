package Day3_lab4;
import Day3_lab3.Cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass4 {

    public static void main(String[] args) {
       PyramidsDAO pDAO = new PyramidsDAO();
        List<Pyramids> pyramids = pDAO.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\ITI_G8_JAVA_SE_Assignments\\src\\Day3_lab4\\pyramids.csv");
        System.out.println(String.format("%-20s | %-50s | %-20s | %-30s", "Pharaoh", "Modern Name", "Site", "Height (meters)"));
        int i=0;
        for (Pyramids pyramid : pyramids){
           System.out.println(String.format("%-20s | %-50s | %-20s | %-30s", pyramid.getPharoh(), pyramid.getModern_name(), pyramid.getSite(), pyramid.getHight()));
        }


        Object[] hightscsv = pyramids
                .stream()
                .map(Pyramids::getHight)
                .sorted()
                .toArray();

List<Double> basem1 =new ArrayList<>();
        for (Object r : hightscsv){
            basem1.add((Double) r);

        }
        System.out.println("List of base m1");
        System.out.println(basem1);

        long cout=basem1.stream().count();
        System.out.println("Number of elemnts");
        System.out.println(cout);

        System.out.println("Median is");
        int quartile=0;
        if(cout%2==0){

            int countr= (int) cout;
            System.out.println(basem1.get(countr/2-1)+basem1.get(countr/2));
        }
        else{
            int countr= (int) cout;
            System.out.println(basem1.get(countr/2));
        }

        System.out.println("Avaerage is");
        Double sum = basem1.stream()
                .reduce(0.0, Double::sum);
        System.out.println(sum/cout);

        if( (cout/2)%2==0  ){
            System.out.println("Lower Quartile is is");
            System.out.println(basem1.get((int) (((cout/2)/2))+1) +basem1.get((int) (((cout/2)/2))) ) ;
            System.out.println("Upper Quartile is is");
            System.out.println(basem1.get(((int) (((cout/2)/2))+1)*2) +basem1.get(((int) (((cout/2)/2)))*2) ) ;

        }
        else{
            System.out.println("Lower Quartile is is");
            System.out.println(basem1.get((int) (((cout/2)/2))+1)  ) ;
            System.out.println("Upper Quartile is is");
            System.out.println(basem1.get(((int) (((cout/2)/2))+1)*2)  ) ;
        }





    }

    
}
