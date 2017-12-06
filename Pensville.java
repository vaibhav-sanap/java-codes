import java.util.*;
import java.io.*;
class PensVille{

    public static void main(String []args) throws IOException{
        Scan  sc = new Scan();
        Print pr = new Print();

        int n = sc.scanInt();
        int arr[] = new int[2*n];
        for(int i=0;i<2*n;i++)
            arr[i] = sc.scanInt();

        radixsort(arr,2*n);

        long ans=0;
        for(int i=0;i<2*n;i=i+2)
            ans=ans+arr[i];

        System.out.println(ans);
    }

    static int getMax(int arr[], int n){
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
        }

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
    
        static void radixsort(int arr[], int n){
            int m = getMax(arr, n);
            for (int exp = 1; m/exp > 0; exp *= 10)
                countSort(arr, n, exp);
        }

} 

 class Scan {
        private byte[] buf = new byte[1024];
        private int index;
        private InputStream in;
        private int total;
    
        public Scan() {
            in = System.in;
        }
    
        public int scan() throws IOException {
            if (total < 0)
                throw new InputMismatchException();
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0)
                    return -1;
            }
            return buf[index++];
        }
    
        public int scanInt() throws IOException {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
            return neg * integer;
        }
    
        public double scanDouble() throws IOException {
            double doub = 0;
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n) && n != '.') {
                if (n >= '0' && n <= '9') {
                    doub *= 10;
                    doub += n - '0';
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
            if (n == '.') {
                n = scan();
                double temp = 1;
                while (!isWhiteSpace(n)) {
                    if (n >= '0' && n <= '9') {
                        temp /= 10;
                        doub += (n - '0') * temp;
                        n = scan();
                    } else
                        throw new InputMismatchException();
                }
            }
            return doub * neg;
        }
    
        public String scanString() throws IOException {
            StringBuilder sb = new StringBuilder();
            int n = scan();
            while (isWhiteSpace(n))
                n = scan();
            while (!isWhiteSpace(n)) {
                sb.append((char) n);
                n = scan();
            }
            return sb.toString();
        }
    
        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
                return true;
            return false;
        }
}
    
    class Print {
        private final BufferedWriter bw;
    
        public Print() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    
        public void print(String str) throws IOException {
            bw.append(str);
        }
    
        public void printLine(String str) throws IOException {
            print(str);
            bw.append("\n");
        }
    
        public void close() throws IOException {
            bw.close();
        }
}  