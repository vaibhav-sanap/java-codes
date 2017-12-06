import java.util.*;


//vaibhav sanap vabhi42@gmail.com
class smallestpositiveinteger{

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); //length of array
        int []arr = new int[n];
        int maxsum =0;
        for(int i=0;i<n;i++){    //getting the array values
            arr[i] = sc.nextInt();
            maxsum = maxsum+arr[i];
        }

        boolean sol[] = new boolean[maxsum];
        Arrays.fill(sol,false);

        sol[0] = true;
        for(int i=0;i<n;i++)
            sol[arr[i]] = true;

        for(int i=0;i<n;i++){
            for(int j=arr[i];j<maxsum;j++){
                sol[j] = sol[j-arr[i]];
            }
        }

        boolean printmax = true;
        for(int i=0;i<maxsum;i++){
            if(sol[i] == false){
                System.out.println(i);
                printmax = false;
                break;
            }
        }

        if(printmax)
            System.out.println(maxsum+1);    
    }
}