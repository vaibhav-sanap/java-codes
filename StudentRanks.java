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
        Scanner sc = new Scanner(System.in);
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
            markmap.put(secondline[0],Integer.parseInt(secondline[4]));
            markmap.put(secondline[5],Integer.parseInt(secondline[9]));
            markmap.put(secondline[10],Integer.parseInt(secondline[14]));
            markmap.put(secondline[16],Integer.parseInt(secondline[20]));
            markmap.put(secondline[21],Integer.parseInt(secondline[25]));
            markmap.put(secondline[27],Integer.parseInt(secondline[31]));

            studentobj.Marks= sortByComparator(markmap,false);
            
            obj.StudentList.add(studentobj);
            sc.nextLine();
            if(!sc.hasNextLine())
                break;
            sc.nextLine();
        }

        //until now is structure for all quetion from here it is specific to every question
        Map<String,Integer> nametomarksum= new HashMap<String,Integer>();
        Iterator<Student> studentlistIt = obj.StudentList.iterator(); 
        while(studentlistIt.hasNext()){  
            Student studentobj = studentlistIt.next();
            int sum=0,count=0,nextvalue=0;
            boolean isEngdone = false;
            for (Map.Entry<String, Integer> entry : studentobj.Marks.entrySet()) {  
               sum = sum + entry.getValue();
            }

            
           nametomarksum.put(Long.toString(studentobj.UniqueId)+","+studentobj.FirstName+" "+studentobj.SecondName,sum); 
        }

         nametomarksum = sortByComparator(nametomarksum,false);   

         //print top 10
         int rank = 1;
         for (Map.Entry<String, Integer> entry : nametomarksum.entrySet()) {
               System.out.println(entry.getKey()+","+rank);
               rank++;
               if(rank==11)
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
}