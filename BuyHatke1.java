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

            radixsort(curw,n);
            
            int ans=0;
            for(int i=0;i<n;i++){
                int curans=0;
                int availablework=w;

                for(int j=i;j>=0;j--){
                    
                    int curdiff = curw[i]-curw[j];

                    if(availablework >= curdiff){
                        curans++;
                        availablework = availablework-curdiff;
                    }
                    else
                        break;
                }

            System.out.println(curans);    
            if(curans >ans)
                ans = curans;
            
            }
              


        
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

     static int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n){
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}