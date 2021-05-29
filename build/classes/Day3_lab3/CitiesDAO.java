
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CitiesDAO {
  List<Cities>ReadFromCitiesCSV;

    public CitiesDAO() {
        this.ReadFromCitiesCSV=new ArrayList<Cities>();
    }
    
  public List<Cities> ReadFromCSV(String filename){
      File file =new File(filename);
      
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            
            for(int index =1;index<lines.size();index++){
                String line=lines.get(index);
                String[] metadata=line.split(",");
                ReadFromCitiesCSV.add(createPyramid(metadata));
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(CitiesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      
      
      return ReadFromCitiesCSV;
      
      
      
  }
  
  
  public Cities createPyramid(String[] metadata){
      int code =Integer.parseInt(metadata[0]);
      double surface_area=Double.parseDouble(metadata[3]);
      int population =Integer.parseInt(metadata[4]);
      Cities cities = new Cities(code, metadata[1], metadata[2],surface_area,population);
      
      return cities;
      
  }
  
  
    
}
