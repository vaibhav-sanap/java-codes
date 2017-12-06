import java.util.*;
class RainBow{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int []arr = new int[n];

            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            
            boolean ans = true;

            for(int i=0,j=n-1; i<n/2&&j>=n/2 ; i++,j--) {

                if((i != n/2-1 + n%2 ))
                if( (i != n/2-1 + n%2 ) && !( arr[i]==arr[i+1] || ( (arr[i]+1) ==arr[i+1] ) )  ){
                    ans = false;
                    break;

                }

                if(arr[i] != arr[j] ) {
                    ans = false;
                    break;
                }    
            }

            if(ans)
                System.out.println("yes");
            else
                System.out.println("no");    
        }

    }
}