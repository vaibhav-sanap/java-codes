/* name        -vaibhav sanap
   contact no. -9403597457/7975251740
   mail id     -vabhi42@gmail.com 
 */


import java.util.*;
class RobotMV 
{
    static int countpath(int grid[][],int row,int col) {

        if (row<0 || col<0 || row>=4 || col>=4)                             //if checking the path is going outside the grid return
            return 0;
    
        if ( grid[row][col] == 1 )                                         //if this place is already visited this skip this path and return 0
            return 0;

        if ( row == 3 && col == 3 )                                        //if we reach to bottom corner then return 1  
            return 1;

        int arr[][]=new int[4][4];
                                                                           //copy grid to temprory array so we can use temprory array to pass to next step  
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j]=grid[i][j];
            }
        }

        arr[row][col] = 1;
        return countpath(arr,row,col+1)+countpath(arr,row,col-1)+countpath(arr,row+1,col)+countpath(arr,row-1,col);  //calling count function recursivly to traverse all path 
    }

    public static void main(String[] args) 
    {
        int grid[][]=new int[4][4];
        System.out.println(countpath(grid, 0, 0));
    }
}