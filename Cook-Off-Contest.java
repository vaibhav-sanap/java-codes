
import java.util.*;
class CookOffContest{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            int N = sc.nextInt();
            boolean cakewalk=false,simple=false,easy=false,easymedium=false,medium=false,mediumhard=false,hard=false;
            
            while(N-->0){

                String problemlevel = sc.next();

                if(problemlevel.equals("cakewalk"))
                    cakewalk = true;
                if(problemlevel.equals("simple"))
                    simple = true;
                if(problemlevel.equals("easy"))
                    easy = true;


                if(problemlevel.equals("easy-medium"))
                    easymedium = true;     
            

                if(problemlevel.equals("medium"))
                    medium = true;     
                    

                if(problemlevel.equals("medium-hard"))
                    mediumhard = true;        
                if(problemlevel.equals("hard"))
                    hard = true;      

            }
            if(cakewalk && simple && easy && (medium||easymedium) && (hard||mediumhard))
                System.out.println("Yes");
            else
                System.out.println("No");    
            
        }

    }

}