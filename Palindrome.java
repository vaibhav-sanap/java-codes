import java.util.*;
class Palindrome{

    static char []carr;
    static int len;
    static boolean iscomputed[][];
    static boolean isPalindrome[][];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        iscomputed = new boolean[len][len];
        isPalindrome = new boolean[len][len];
        Arrays.fill(isPalindrome,false);
        Arrays.fill(iscomputed,false);
        carr = str.toCharArray();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(iscomputed[i][j])
                    isPalindromef(i,j);
            }
        }

        int ans=0;
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                if(isPalindrome[i][j]==true)
                    ans++;
        System.out.println(ans);
    }

    public static void isPalindromef(int i,int j){

        if(i==len || j==-1) return;

        if(!iscomputed[i][j]){
            iscomputed[i][j]=true;
            if(i==j) {
                isPalindrome[i][j]=true;
                return;
            }
            if(j==i+1){
                if(carr[i] == carr[j])
                    isPalindrome[i][j]=true;
                return;
            }
            if(carr[i] == carr[j]){
                isPalindromef(i+1,j-1);
                if( isPalindrome[i+1][j-1] )
                    isPalindrome[i][j] = true;
                return;    
            }
        }
    return;
    }

}