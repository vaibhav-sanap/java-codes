/* name        -vaibhav sanap
   contact no. -9403597457/7975251740
   mail id     -vabhi42@gmail.com 
 */

import java.util.*;
import java.io.*;
class KnapSackList{

    static int max(int a, int b) { return (a > b)? a : b; }

    static int knapSack(int W, int wt[], int val[], int n,int visited[]){

    // Base Case
    if (n == 0 || W == 0)
        return 0;

    // If weight of the nth item is more than Knapsack capacity W, then
    // this item cannot be included in the optimal solution
    if (wt[n-1] > W)
        return knapSack(W, wt, val, n-1,visited);

    // Return the maximum of two cases: 
    // (1) nth item included 
    // (2) not included
    else {

        int v1[]=new int[visited.length];
        System.arraycopy(visited, 0, v1, 0, v1.length);
        int v2[]=new int[visited.length];
        System.arraycopy(visited, 0, v2, 0, v2.length);
        v1[n-1]=1;

        int ans1 = val[n-1] + knapSack(W-wt[n-1], wt, val, n-1,v1);
        int ans2 = knapSack(W, wt, val, n-1,v2);
        if(ans1>ans2){
            System.arraycopy(v1, 0, visited, 0, v1.length);
            return ans1;
        }
        else{
            System.arraycopy(v2, 0, visited, 0, v2.length);
            return ans2;
        }
    }            
      }


    public static void main(String []args) {

        try{
            Scanner sc = new Scanner(new File(args[0]));                                                          //reading through input file

            while( sc.hasNextLine() ){                                                                                      
                String line = sc.nextLine();
                String arr[] = line.split(" ");

                int bagweight = Integer.parseInt(arr[0])*100;

                int len = arr.length-2;

                int []wt  = new int[len];
                int []val = new int[len];
                int visited[] = new int[len];

                for(int i=2;i<arr.length;i++){
                    String tokens[] = arr[i].substring(1,arr[i].length()-1).split(",");                              //parsing the input 
                    wt[i-2]  = (int) ( Double.parseDouble(tokens[1])*100 );
                    val[i-2] = Integer.parseInt(tokens[2].substring( 1, tokens[2].length() ) );
                    //System.out.print("wt------"+wt[i-2]+"val-------"+val[i-2]);
                }

                knapSack(bagweight,wt,val,len,visited);                                                             //calling knapsack    

                StringBuilder ans = new StringBuilder("");                                                          //printing the answer            
                for(int i=0;i<len;i++)
                    if(visited[i]==1)
                        ans.append(i+1+",");

                if(ans.length()==0)
                    System.out.println("-");
                else            
                    System.out.println(ans.substring(0,ans.length()-1));        
                
            }
        }
        catch(Exception e){
                System.out.println("Exception occured"+e);
        }

    }

}