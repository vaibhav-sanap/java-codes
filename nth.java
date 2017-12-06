import java.util.*;
class divisiblenumner{

    public static void main(String []args){


            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0){

                int a = sc.nextInt();
                int b = sc.nextInt();
                long N = sc.nextLong();

                int ans = (int) Math.ceil( (N*a*b)/(a+b-1) );
                System.out.println(ans);
                
            }
        }

}
