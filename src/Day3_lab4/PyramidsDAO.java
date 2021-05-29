package Day3_lab4;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PyramidsDAO {
    List<Pyramids> ReadFromPyramidsCSV; 

    public PyramidsDAO() {
        this.ReadFromPyramidsCSV = new ArrayList<Pyramids>();
    }
    
    public List<Pyramids> ReadFromCSV (String filename){
      
    File file =new File(filename);
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            
            for(int index =1;index<lines.size();index++){
                String line=lines.get(index);
                String[] metadata=line.split(",");
                ReadFromPyramidsCSV.add(createPyramid(metadata));
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PyramidsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
      return ReadFromPyramidsCSV;
}
    
    public Pyramids createPyramid(String[] metadata){
        if(!(metadata[7] == null || metadata[5].isEmpty())){
            
            double hight = Double.parseDouble(metadata[5]);
     Pyramids pyramids = new Pyramids(metadata[0], metadata[2], metadata[4],hight);
     return pyramids;
            
        }
        
        
        
        else{       
     Pyramids pyramids = new Pyramids(metadata[0], metadata[2], metadata[4],null);
     return pyramids;            
        }
        
        
    }
    
    
}
