import java.util.*;
class alex{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int N = sc.nextInt();
            long []arr = new long[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextLong();

            long ans=10000000;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    long lcm = lcm(arr[i],arr[j]);
                    if(lcm<ans){
                        ans = lcm;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static long lcm(long a,long b){
        long tempa = a,tempb = b;
        while(b>0){
            long  temp = b;
            b = b%a;
            a = temp;
        }
        System.out.println(tempa+"******"+tempb+"**********"+tempa*tempb/a);
        return tempa*tempb/a;
    }
}