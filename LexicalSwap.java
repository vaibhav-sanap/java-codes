import java.util.*;
import java.io.*;

class LexicalSwap{
    public static void main(String args[]) throws IOException{

        try{
        Scan sc = new Scan();
        Print pr = new Print();

        int t = sc.scanInt();
        while(t-->0){
            int n = sc.scanInt();
            int k = sc.scanInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.scanInt();
            
            int startindex=0;
            int finalindex=0;
            while(k>0){

                if(k>n)
                    finalindex=n;
                else
                    finalindex=k+startindex+1;

                int min=10000000,minpos=0;
                for(int i=startindex;i<finalindex;i++){
                    if(arr[i]<min){
                        min=arr[i];
                        minpos=i;
                    }
                }
                for(int i=minpos;i>startindex;i--)
                     arr[i]=arr[i-1];   
                
                arr[startindex]=min;
                k=k-(minpos-startindex);

                startindex++;
            }
            pr.printLine(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", "").trim());
            
        }
    pr.close();

    }catch(Exception e){
        System.out.println(e);
    }
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