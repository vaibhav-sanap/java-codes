import java.util.*;

class Hacker2{
    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int array[] = new int[11];

        StringBuilder strb = new StringBuilder();


        for(int i=0;i<array.length;i++)
            array[i] = sc.nextInt();
        for(int i=0;i<array.length;i++){

            int count=1;
            if(array[i]<0){                                          //negative number
                
                for(int j=i;j<array.length-1;j++)
                    if(array[j] == array[j+1]+1 && array[j]<0)
                         count++;
                    else 
                        break;     
                
            }
            
            else{
                for(int j=i;j<array.length-1;j++)
                    if(array[j]+1 == array[j+1] && array[j]>0)
                         count++;
                    else
                        break;     
            
            }

            if(count>=3){
                strb.append(""+array[i]+"-"+array[i+count-1]+",");
                i=i+count-1;

            }
            else{
                strb.append(""+array[i]+",");
            }
        }
        System.out.println(strb.substring(0,strb.length()-1));
    }
}