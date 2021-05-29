package Pyramids_Day2;
import java.util.List;
public class MainClass {

    public static void main(String[] args) {
       PyramidsDAO pDAO = new PyramidsDAO();
        List<Pyramids> pyramids = pDAO.ReadFromCSV("C:\\Users\\ahmed\\Desktop\\ITI_G8_JAVA_SE_Assignments\\src\\Pyramids_Day2\\pyramids.csv");
        System.out.println(String.format("%-20s | %-50s | %-20s | %-30s", "Pharaoh", "Modern Name", "Site", "Height (meters)"));
        int i=0;
        for (Pyramids pyramid : pyramids){
           System.out.println(String.format("%-20s | %-50s | %-20s | %-30s", pyramid.getPharoh(), pyramid.getModern_name(), pyramid.getSite(), pyramid.getHight()));
        }
    }
    
}
