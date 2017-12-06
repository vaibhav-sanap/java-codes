import java.util.*;
import java.io.*;
class BuyHatke2{
    public static void main(String []args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){

            StringTokenizer tk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int q = Integer.parseInt(tk.nextToken());

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            while(q-->0){

                int j = Integer.parseInt(br.readLine());

                 if(j==1 || j==n){
                    System.out.println(0);
                    continue;
                }

                int ij = 0; 
                for(int i=1;i<j;i++)
                    if(arr[i-1] <= arr[j-1] && ij < arr[i-1])
                        ij = arr[i-1];

                if(ij==0){
                    System.out.println(0);
                    continue;
                }

                int jk=0;
                for(int k=j+1;k<=n;k++)
                    if(arr[j-1] >= arr[k-1] && jk < arr[k-1])
                        jk = arr[k-1];    

                long finalans = ij*jk;
                finalans = finalans*arr[j-1];
                System.out.println(finalans);
            }    
        }
        }catch(Exception e){
            System.out.println();
        }
    }
}