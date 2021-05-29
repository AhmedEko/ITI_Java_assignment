package Day3_Lab2;
import java.util.function.BiPredicate;

public class CompareString {
    
    String isbetter_string(String str1,String str2,BiPredicate<String , String> bipredicate){
        if(bipredicate.test(str1, str2))
            return str1;
        return str1;
        
    }
    
}


