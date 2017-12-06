import java.util.*;
class xor{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n =sc.nextLong();
            long maxxor = maxXORInRange(0,n-1);
            long count=0;
            for(long i=0;i<n;i++)
                for(long j=0;j<n;j++)
                    if((i^j)==maxxor)
                        count++;
        
        System.out.println(maxxor+" "+count);
        }
        
        
    }
    
    static long maxXORInRange(long L, long R)
    {
        // get xor of limits
        long LXR = L ^ R;
      
        //  loop to get msb position of L^R
        long msbPos = 0;
        while (LXR > 0)
        {
            msbPos++;
            LXR >>= 1;
        }
      
        // construct result by adding 1,
        // msbPos times
        long maxXOR = 0;
        long two = 1;
        while (msbPos-- >0)
        {
            maxXOR += two;
            two <<= 1;
        }
      
        return maxXOR;
    }
}