import java.util.*;
class MagicFab{

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int []N = new int[t];
        int []M = new int[t];
        int []K = new int[t];
        for(int i=0;i<t;i++){
            N[i] = sc.nextInt();
            M[i] = sc.nextInt();
            K[i] = sc.nextInt();
        }

        //find max
        int mx = M[0];
        for (int i = 1; i < t; i++)
            if (M[i] > mx)
                mx = M[i];

        long fab[] = new long[mx+1];
        long fact[] = new long[mx+1];
        fact[0]=1;
        fact[1]=1;
        fact[2]=2;
        fact[3]=6;
    
        fab[0]=1;
        fab[1]=1;
        fab[2]=2;
        fab[3]=3;
        for(int i=4;i<=mx;i++){
            fab[i] = fab[i-1]+fab[i-2];
            fact[i]=fact[i-1]*i;
        }

        for(int i=0;i<t;i++){
            long sum=0;
            for(int j=N[i];j<=M[i];j++){
                sum = sum+fab[j]*fact[j];
                sum = sum%1000000007;
            }

            long ans =(long) (Math.floor(sum/K[i]));
            System.out.println(ans);
        }    
    }
}