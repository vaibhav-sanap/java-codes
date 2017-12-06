import java.util.*;

class Rupsa{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int sum=0;
            int N = sc.nextInt();
            int []arr = new int[N+1];
            for(int i=0;i<=N;i++)
                arr[i] = sc.nextInt();
            
            for(int i=N;i>0;i--){
                int poselement = arr[i];

                for(int j=0;j<i;j++){
                    sum = ( sum + (poselement*arr[j])*Math.pow(2,N-i+1)) % (Math.pow(10,9)+1) ;

                }
            }
            System.out.println(sum);
        }
    }

}