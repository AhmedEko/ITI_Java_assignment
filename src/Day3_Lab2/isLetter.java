package Day3_Lab2;

import java.util.function.Predicate;

public class isLetter{
      
  boolean IsLetter(String str1,Predicate<String> predicate){
      return predicate.test(str1);
      
  }
    
}