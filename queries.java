import java.util.*;

class queries{

    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int q = sc.nextInt();

        int []onepos = new int[q];

        int currentsize=0;
        int max =0;

        while(q-->0){
            int k = sc.nextInt();
            int y = sc.nextInt();

            if(k==1){
                if(y>max)
                    max = y;
                onepos[currentsize] = y;
                currentsize++;
                continue;
            }

            if( y > max ){
                System.out.println(-1);
                continue;
            }

            boolean ans = false;
            int curans = len+1;    
            for(int i=0;i<currentsize;i++)
                if(onepos[i] >= y && onepos[i] < curans){
                    curans = onepos[i];
                    ans = true;
                }
            
            if(ans)
                System.out.println(curans);
            else
                System.out.println(-1);    
        }

    }
}