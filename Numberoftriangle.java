import java.util.*;
class NumberofTriangle{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int []inputarr = new int[t]; 
        for(int i=0;i<t;i++)
            inputarr[i] = sc.nextInt();

        //find max
        int mx = inputarr[0];
        for (int i = 1; i < t; i++)
            if (inputarr[i] > mx)
                mx = inputarr[i];  


       long []sol = new long[mx+1];           

       sol[0] = 1;
       sol[1] = 5;
       sol[2] = 17;
       for(int i=3;i<=mx;i++)
           sol[i]  = (3*sol[i-1]+2)%1000000007;

       for(int i=0;i<t;i++)
           System.out.println(sol[inputarr[i]]); 
       
    }
}