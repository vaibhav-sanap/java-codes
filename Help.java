import java.util.*;

class Help{
    static int ans = 1000000000;
    static int min(int a,int b){return (a<b)?a:b;}
    static int distance[],petrol[];
    static int N;

    public static void main(String args[]){

        try{
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        distance = new int[N];
        petrol = new int[N];

        int arr[][] = new int[N][2];
        for(int i=0;i<N;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        int d = sc.nextInt();
        int p = sc.nextInt();

        for(int i=0;i<N;i++)
           tm.put(d-arr[i][0],arr[i][1]); 

        int i=0;
        for(Map.Entry<Integer,Integer> entry : tm.entrySet()) {
            distance[i] = entry.getKey();
            petrol[i] = entry.getValue();
            i++;
        }
        

        int ans = findans(d,p,0,0);   
        if(ans == 1000000000)
            System.out.println(-1);
        else
            System.out.println(ans);    
        
        }catch(StackOverflowError t) {
            System.out.println(-1);
        }
    }

    static int findans(int d,int p,int pumpnumber,int count){

        if(d <= p ){
            if(count < ans){
                ans = count;
            }
            return ans;    
        }    

        if(pumpnumber == N)
            return ans;
   
        //next petrol pump not reachable print not possible

        if(distance[pumpnumber] > p){
            return 1000000000;
        }

        //select or not select petrolpump
        return min( findans(d , p+petrol[pumpnumber], pumpnumber+1, count+1), findans(d, p, pumpnumber+1, count) );    

    }
}