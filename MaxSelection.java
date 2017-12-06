import java.util.*;
import java.io.*;
class MaxSelection{

    static int max(int a, int b) { return (a > b)? a : b; }

    static int knapSack(int W, int wt[], int val[], int n) {
        int K[][] = new int[n+1][W+1];
        StringBuilder ans = new StringBuilder("");

        for (int i = 0; i <= n; i++){

            for (int w = 0; w <= W; w++){
                
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max( val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
 
        return K[n][W];
    }

    public static void main(String []args) {

        try{
            Scanner sc = new Scanner(new File(args[0]));                                     //reading through input file

            while( sc.hasNextLine() ){
                String line = sc.nextLine();
                String arr[] = line.split(" ");

                int bagweight = Integer.parseInt(arr[0])*100;

                int len = arr.length-2;

                int []wt  = new int[len];
                int []val = new int[len];

                for(int i=2;i<arr.length;i++){
                    String tokens[] = arr[i].substring(1,arr[i].length()-1).split(",");
                    wt[i-2]  = (int) ( Double.parseDouble(tokens[1])*100 );
                    val[i-2] = Integer.parseInt(tokens[2].substring( 1, tokens[2].length() ) );
                    //System.out.print("wt------"+wt[i-2]+"val-------"+val[i-2]);
                }

                System.out.println(knapSack(bagweight,wt,val,len));
                
            }
        }
        catch(Exception e){

        }

    }

}