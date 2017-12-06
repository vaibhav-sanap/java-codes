
import java.util.*;
class CoinGame{
    public static void main(String []args){
         Scanner sc = new Scanner(System.in);
         int t = sc.nextInt();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        map.put(2,1);
        map.put(4,2);
        map.put(6,1);
        map.put()
        for(int i=10;i<1000000000;i++)
            if(i%2==0)
                arr[i] = 1+arr[i/2];
        
         while(t-->0){
             int total=0;
             int N = sc.nextInt();
             for(int i=0;i<N;i++){
                 int temp = sc.nextInt();
                 total = total+arr[temp];
             }

             if(total%2==0)
                System.out.println("Alan");
             else
                System.out.println("Charlie");         
         }   
    }
}