import java.util.*;
import java.io.*;
import java.math.BigInteger;
class LongestQuery{

    public static void main(String []args) throws Exception{

        try{
        Scan sc = new Scan();
        Print pr = new Print();
        int len = sc.scanInt();
        int q  = sc.scanInt();
        String str = sc.scanString();
        char arr[] = str.toCharArray();
        
        int result=0;
        boolean skipresultcalculation=true;
        while(q-->0){
            int type = sc.scanInt();
            if(type==1){

                if(!skipresultcalculation){

                    BigInteger temp = new BigInteger(String.valueOf(arr), 2);    
                    result = maxConsecutiveOnes(temp);
                }

                pr.printLine(Integer.toString(result));   
            }
            else{
                int pos = sc.scanInt();
                if(arr[pos-1]=='0'){
                    arr[pos-1] = '1'; 
                    skipresultcalculation=false;
                }else
                    skipresultcalculation=true;
            
            }

           }
        pr.close();

        }catch(Exception e){
            System.out.println(e.getClass().getSimpleName());
        }

    }

    public static int maxConsecutiveOnes(BigInteger bi)
    {
        
        Long x = bi.longValue();
        int count = 0;
 
        while (x!=0)
        {
            x = (x & (x << 1));
            count++;
        }
        return count;
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