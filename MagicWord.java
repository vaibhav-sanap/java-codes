import java.util.*;
class MagicWorld{

    boolean iscomputed[][];
    boolean isPalindrom[][];
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            MagicWorld obj = new MagicWorld();  
            String str = sc.next();
            int n = str.length();
            obj.iscomputed = new boolean[n][n];
            obj.isPalindrom = new boolean[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(obj.solve(str,i,j)){
                        sum = sum+(j-i+1)*(j-i+1);    
                    }
                }

            }
            System.out.println(sum);
        }
    }
    boolean solve(String str,int i,int j){


            if(!iscomputed[i][j]){
                iscomputed[i][j] = true;
                if(i==j)
                    isPalindrom[i][j] = true;
                else if(i==j+1){
                    if(str.charAt(i) == str.charAt(j))
                        isPalindrom[i][j] =true;
                }
                else{
                    if(str.charAt(i) == str.charAt(j)){
                        if(solve(str,i+1,j-1))
                            isPalindrom[i][j] = true;    
                    
                    }
                }
            }
        return isPalindrom[i][j];
    }

}