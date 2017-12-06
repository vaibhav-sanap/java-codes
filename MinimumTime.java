import java.io.*;
import java.util.*;

class MinimumTime{
    public static void main(String args[]) throws IOException{
        Scan sc = new Scan();

        int N = sc.scanInt();
        int d = sc.scanInt();
        int arr[] = new int[N+1];
        arr[0]=0;
        for(int i=1;i<=N;i++)
            arr[i] = sc.scanInt();

        int cached=0;
        for(int i=0;i<=N;i++){
                cached= cached+arr[i];
				int cached2 = cached;
                int j;
                for(j=i+1;j<=N;){
                        cached2 =cached2+arr[j];
						//System.out.println("cached2---- "+cached2+"   "+j);
                        if( cached2 < d )
                            break;
						cached=cached-d;
						cached2=cached2-d;
						j++;
                }

                if(j==N+1){
                    System.out.println(i+1);
                    break;
                }
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