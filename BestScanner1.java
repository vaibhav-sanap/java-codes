import java.util.*;
import java.io.*;

 
public class BestScanner1 {
    
    public static boolean[][] vis;
    public static int[][] dp;
    public static int[] arr;
    
    public static int solve(int i,int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(vis[i][j]) return dp[i][j];
        vis[i][j]=true;
        int mn=solve(i+1, j)+1;
        
        for(int k=i+1;k<=j;k++){
            if(arr[i]==arr[k])
                mn=min(mn,solve(i+1, k-1)+solve(k+1, j));
        }
        return dp[i][j]=mn;
    }
    
    public static void main(String[] args) throws IOException{
 
        Scan sc = new Scan();
        Print pr = new Print();
        int n=sc.scanInt();
        arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.scanInt();
        dp=new int[n][n];
        vis=new boolean[n][n];
        
        pr.print( Integer.toString(solve(0, n-1)) );
        pr.close();
    }

    public static int min(int a,int b){
        return (a<b)?a:b;
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