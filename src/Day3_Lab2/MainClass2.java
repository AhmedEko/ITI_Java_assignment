package Day3_Lab2;

import java.util.function.BiPredicate;


public class MainClass2 {

    public static void main(String[] args) {
       String s1="AhmedTarek";
       String s2="Go now study";
       
       
        CompareString C =new CompareString();
        BiPredicate<String , String> bipredicate1=(str1,str2)->str1.length()>str2.length();
           
       String finallout= C.isbetter_string(s1, s2, bipredicate1);
        System.out.println(finallout);
                
        
        
        
          isLetter I = new isLetter();
          
          
        Boolean checker= I.IsLetter(s2, (Str1)-> {
             for (int i=0 ; i<Str1.length();i++){
             if(! Character.isLetter(Str1.charAt(i)))
                 return false;
             
         }
             return true;
 
         });
                  
         System.out.println(checker);
                
                
                
               
           
      
       
    }
    
}
