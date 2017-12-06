import java.io.File;

public class CountCsvFiles {

    private String Corrupted_folder_path;
    private String Sink_folder_location;
    static  int count=0;

        public int CountOfCSVInCorruptedFolderPath(String Corrupted_folder_path) {
            int count = 0;
            File f = new File(Corrupted_folder_path);        
            if  ( !(f.exists() && f.isDirectory()) ) 
             return 0;

            this.Corrupted_folder_path = Corrupted_folder_path;
            try {
                final File folder = new File(this.Corrupted_folder_path);
                for (final File fileEntry : folder.listFiles()) {
                    if (fileEntry.getName().endsWith("csv")) {
                        count++;
                    } else {
                        continue;
                    }
                }
            }catch (Exception e){

                e.getStackTrace();
            }
            return count;
        }

        public int CountOfCSVInSinkFolder(String Sink_folder_location){
            this.Sink_folder_location=Sink_folder_location;
            try {
                final File folder = new File(this.Sink_folder_location);
                for (final File fileEntry : folder.listFiles()) {
                    if(fileEntry.isDirectory()==true){                  
                    CountOfCSVInSinkFolder(Sink_folder_location+"/"+fileEntry.getName());
                    }
                    else if (fileEntry.getName().endsWith("csv")) {
                        count++;
                    } else {
                        continue;
                    }
                }
            }catch (Exception e){

                e.getStackTrace();
            }
    return count;
    }

}
