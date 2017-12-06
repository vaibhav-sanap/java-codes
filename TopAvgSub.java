import java.util.*;
import java.io.*;
class StudentRanking{

    class Student{
        long UniqueId;
        String FirstName,SecondName,gender;
        Map<String,Integer> Marks;

        Student(long UniqueId,String FirstName,String SecondName,String gender){
            this.UniqueId = UniqueId;
            this.FirstName = FirstName;
            this.SecondName = SecondName;
            this.gender = gender;
        }

    }
    LinkedList<Student> StudentList;

    public static void main(String []args) {

        try{
        Scanner sc = new Scanner(new File("input.txt"));
         String[] header; 
        if(sc.hasNextLine())
            header = sc.nextLine().split(" ");
        StudentRanking obj = new StudentRanking();
        obj.StudentList = new LinkedList<Student>();
        while(sc.hasNextLine()){
            
            String[] firstline = sc.nextLine().split(" ");
            Student studentobj = obj.new Student(Long.parseLong(firstline[0]),firstline[1],firstline[2],firstline[4]); 
            //System.out.println("uniqueID "+studentobj.UniqueId+" FirstName "+studentobj.FirstName+" SecondName "+studentobj.SecondName+" gender "+studentobj.gender);
            String[] secondline = sc.nextLine().split(" ");
        
            Map<String,Integer> markmap = new HashMap<String,Integer>();

            int i=0;
            while(i<secondline.length-2){
                if(secondline[i+1].equals("-") && secondline[i+3].equals("-")){
                    markmap.put(secondline[i],Integer.parseInt(secondline[i+4]));  
                     i=i+5;         
                }
                else{
                    i=i+1;
                }
            }

            /*for (Map.Entry<String, Integer> entry : markmap.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("*********************");
*/

            studentobj.Marks= sortByComparator(markmap,false);
            
            obj.StudentList.add(studentobj);
            sc.nextLine();
            if(!sc.hasNextLine())
                break;
            sc.nextLine();
         }
        
        //until now is structure for all quetion from here it is specific to every question
        //created the sum of subjects marks
        Iterator<Student> studentlistIt = obj.StudentList.iterator();
        HashMap<String,Integer> MarksSum = new HashMap<String,Integer>();
        HashMap<String,Integer> encouters = new HashMap<String,Integer>(); 

        while(studentlistIt.hasNext()){ 
            Student studentobj = studentlistIt.next();
             for (Map.Entry<String, Integer> entry : studentobj.Marks.entrySet()) {
                    String key = entry.getKey();
                    if(MarksSum.containsKey(key)){
                       MarksSum.put(key,MarksSum.get(key)+entry.getValue());
                       encouters.put(key,encouters.get(key)+1);
                    }else{
                        MarksSum.put(key,entry.getValue());
                        encouters.put(key,1);
                    }
                }
        }

        Map<String,Double> avgscore = new HashMap<String,Double>(); 
        for (Map.Entry<String, Integer> entry : MarksSum.entrySet()) {
            avgscore.put(entry.getKey(),(double)entry.getValue()/encouters.get(entry.getKey()));
        }

        avgscore = sortByComparatorFloat(avgscore,false);
        int i=0;
        for (Map.Entry<String, Double> entry : avgscore.entrySet()) {
           System.out.println(entry.getKey()+","+entry.getValue());
           i++;
           if(i>4)
            break;
        }

        


    }
    catch(Exception e){
        System.out.println(e);
    }


    }
      private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order){

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if (order)
                    return o1.getValue().compareTo(o2.getValue());
                else
                    return o2.getValue().compareTo(o1.getValue());

            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());
        
        return sortedMap;
    }

     private static Map<String, Double> sortByComparatorFloat(Map<String, Double> unsortMap, final boolean order){

        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>(){
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2){
                if (order)
                    return o1.getValue().compareTo(o2.getValue());
                else
                    return o2.getValue().compareTo(o1.getValue());

            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list)
            sortedMap.put(entry.getKey(), entry.getValue());
        
        return sortedMap;
    }
}