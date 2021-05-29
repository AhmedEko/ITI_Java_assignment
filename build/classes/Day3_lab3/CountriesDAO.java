
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CountriesDAO {
      List<Countries>ReadFromCountriesCSV;

    public CountriesDAO() {
          this.ReadFromCountriesCSV=new ArrayList<Countries>();
          
    }
    
     public List<Countries> ReadFromCSV(String filename){
         
          File file =new File(filename);
      
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            
            for(int index =1;index<lines.size();index++){
                String line=lines.get(index);
                String[] metadata=line.split(",");
                ReadFromCountriesCSV.add(createCountry(metadata));
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(CountriesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ReadFromCountriesCSV;    
     }
    
     
       
  public Countries createCountry(String[] metadata){
      int code =Integer.parseInt(metadata[0]);

      Countries countries = new Countries(code, metadata[1], metadata[2]);
      
      return countries;
      
  }
     
     
}
