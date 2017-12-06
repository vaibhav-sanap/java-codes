import java.util.*;

class Grid{

    int grid[][];
    int col;
    int row;
    int ans;
    int trailingzero(int num){
        int zeroes = 0;
        while(num%10 == 0 && num != 0) {
            zeroes++;
            num /= 10;
        }
        System.out.println(zeroes);
        if(zeroes<ans)
            ans = zeroes;
        return zeroes;
    }

    int minfunction(int a,int b){
       return( (a<b)?a:b );
    }

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        Grid obj = new Grid();
        obj.row = sc.nextInt();
        obj.col = sc.nextInt();
        obj.ans = 10000;
        obj.grid = new int[obj.row][obj.col];
        for(int i=0;i<obj.row;i++){
            for(int j=0;j<obj.col;j++){
                obj.grid[i][j] = sc.nextInt();
            }
        }

    obj.traversegrid(0,0,obj.grid[0][0]);
    System.out.println(obj.ans);
    }

    int traversegrid(int currentrow,int currentcol,int product){

         if(currentrow ==row-1 && currentcol==col-1){
             return(trailingzero(product));
         }

         if(currentcol == col-1 && currentrow < row)
             return traversegrid(currentrow+1,currentcol,product*grid[currentrow+1][currentcol]);

         if(currentrow == row-1 && currentcol <col)
            return traversegrid(currentrow,currentcol+1,product*grid[currentrow][currentcol+1]); 

        return( minfunction(   traversegrid(currentrow+1,currentcol,product*grid[currentrow+1][currentcol]), traversegrid(currentrow,currentcol+1,product*grid[currentrow][currentcol+1] )     )        );   
               
    }
}

