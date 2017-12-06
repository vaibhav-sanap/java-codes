import java.util.*;
import java.io.*;
class BuyHatke1{
    public static void main(String []args){
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int w = Integer.parseInt(tk.nextToken());
        int[] curw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        //data manupulation
        ArrayList<ArrayList<Integer>> outerwdiff = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> inner = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                int cudiff = curw[i] - curw[j];
                if(cudiff >=0 ){
                    inner.add(cudiff);
                }
            }
            Collections.sort(inner);
            outerwdiff.add(inner);
        }

        //actual logic block
        int ans =0;
        for(ArrayList inner: outerwdiff){
             
            if(ans<inner.size()){
                int count=0;
                int availablework = w;  
                for(int i=0;i<inner.size();i++){
                    int d = (int)inner.get(i);
                    if(d <= availablework ){
                        availablework =availablework-d;
                        count++; 
                    }
                    else
                        break;
                }

                if(ans<count)
                    ans = count;
                
            }
        
        }
        System.out.println(ans);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}