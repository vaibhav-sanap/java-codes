import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class distinct {
    public static void main(String []args){
        String text = "123-345-3452";
        String text1 = "11111111(111) 234-8888888";

         Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
         Matcher matcher = pattern.matcher(text);
         System.out.print(matcher.find() + matcher.group(0)); 

         Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
         Matcher matcher1 = pattern1.matcher(text1);
         System.out.print(matcher1.find());   



    }
            
    }