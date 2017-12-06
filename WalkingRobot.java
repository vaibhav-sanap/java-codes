class WalkingRobot{

 public static void main(String []args){
     int inx = Integer.parseInt(args[0]); 
     int iny = Integer.parseInt(args[1]);
     String cf = args[2];
     String walks = args[3];
     char []arr = walks.toCharArray();

     int fx=inx,fy=iny;   

     for(int i=0;i<arr.length;i++){  
         if(arr[i]=='R'){
             if(cf.equalsIgnoreCase("North")){
                 cf = "East";
                 continue;
             }
             if(cf.equalsIgnoreCase("East")){
                 cf = "South";
                 continue;
             }
             if(cf.equalsIgnoreCase("South")){
                cf = "West";
                continue;
             }
             if(cf.equalsIgnoreCase("West")){
                cf = "North";
                continue;
             }
         }

         if(arr[i]=='L'){
             if(cf.equalsIgnoreCase("North")){
                cf = "West";
                continue;
             }
             if(cf.equalsIgnoreCase("East")){
                cf = "North";
                continue;
             }
             if(cf.equalsIgnoreCase("South")){
                cf = "East";
                continue;
             }
             if(cf.equalsIgnoreCase("West")){
                cf = "South";
                continue;
             }

         }


         if(arr[i]=='W'){
             if(cf.equalsIgnoreCase("North")){
                    i++;
                    fy = fy + Integer.parseInt(String.valueOf(arr[i]));
             }
             if(cf.equalsIgnoreCase("East")){
                    i++;
                    fx = fx+ Integer.parseInt(String.valueOf(arr[i]));
             }
             if(cf.equalsIgnoreCase("South")){
                    i++;
                    fy = fy-Integer.parseInt(String.valueOf(arr[i]));
             }
             if(cf.equalsIgnoreCase("West")){
                    i++;
                    fx = fx - Integer.parseInt(String.valueOf(arr[i]));
             }
         }
     }

     System.out.println(fx+" "+fy+" "+cf); 

 }   
}