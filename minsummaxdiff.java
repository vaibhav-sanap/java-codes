import java.util.*;
class test{

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-->0){
            boolean result = false;
            String str = sc.nextLine();
            char []chararr = str.toCharArray();

            for(int i=0;i<str.length();i++){

                for(int j=0;j<str.length();j++){

                    if(chararr[i] == chararr[j]){

                        for(int k=i+1;k<str.length();k++){

                            for(int f=j+1;f<str.length();f++){

                                if(chararr[k] == chararr[f] && k!=f ){

                                    System.out.println("yes"+i+j+k+f);
                                    result = true;
                                    break;
                                }
                            }

                            if(result)
                                break;
                        }
                    }
                    if(result)
                        break;
                }
                if(result)
                    break;
            }

            if(!result)
                System.out.println("no");   
        }
    }
}