import java.util.*;
class Sgcd{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int count=0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(GCD(arr[i],arr[j]) !=1 )
                    count++;

        System.out.println(n*n+count*(n-1));     
    }
    
    public static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }


}