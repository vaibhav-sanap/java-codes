import java.util.*;

class Sorted{

    public static void main(String []args){
        try{
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();
            
            long ans=0;
            for(int i=1;i<N;i++){
                if(arr[i]<=arr[i-1]){
                    int temp = arr[i-1] - arr[i] + 1;
                    ans = ans+temp;
                    arr[i] = arr[i]+temp;
                }
            }
            System.out.println(ans);
            System.out.println(Arrays.toString(arr));
        }catch(Exception e){
            
        }
    }

}