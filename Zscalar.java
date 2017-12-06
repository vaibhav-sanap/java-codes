import java.util.*;
import java.io.*;
class Zscalar{
    public static void main(String args[]) throws IOException{
        Scan sc = new Scan();
        Print pr = new Print();

        int n = sc.scanInt();
        int q = sc.scanInt();
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=n;i++){
            int university = sc.scanInt();
            if(map.get(university) ==null){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(university,temp);

            }else{
                ArrayList<Integer> temp = map.get(university);
                temp.add(i);
                map.put(university,temp);
            }
        }

        while(q-->0){
            int a = sc.scanInt();
            int b = sc.scanInt();

            ArrayList<Integer> list1 = map.get(a);
            ArrayList<Integer> list2 = map.get(b);

            int ans = n;
            for(int i=0;i<list1.size();i++){
                for(int j=0;j<list2.size();j++){
                        int temp = Math.abs(list1.get(i) - list2.get(j));
                        if(temp>n/2)    temp = n-temp;
                        temp = temp/2;
                        if(temp<ans)
                            ans = temp;

                }
            }
            pr.printLine(Integer.toString(ans));
        }
        pr.close();    

        
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