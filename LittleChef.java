import java.util.*;
class LittleChef{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while(t-->0){
            int N = sc.nextInt();
            ArrayList<Integer> arrlist = new ArrayList<Integer>();
            ArrayList<Integer> arrlist1 = new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                int temp = sc.nextInt();
                arrlist.add(temp);
                arrlist1.add(temp);
            }
            
            Collections.sort(arrlist1);    
            System.out.println(arrlist.indexOf(arrlist1.get(0))+1);

        }
    }

}