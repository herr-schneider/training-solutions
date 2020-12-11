package week07d05;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class SaveInput {

    public SaveErrors fileWriter(String writableStr, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(writableStr);
            myWriter.close();
            return SaveErrors.WRITESUCCESS;
        } catch (IOException e) {
            return SaveErrors.WRITEFAILED;
        }
    }

    public SaveErrors fileCreator(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                return SaveErrors.CREATESUCCESS;
            } else {
                return SaveErrors.FILEALLREADY;
            }
        } catch (IOException e) {
            return SaveErrors.CREATEFAILED;
        }
    }

    public void input(String data1, String data2 , String filename){
        if (fileCreator(filename) == SaveErrors.FILEALLREADY){
            System.out.println("Már van ilyen fájl, de nem nem baj!");}
        else {
            System.out.println("Van baj, nem kevés!");}
        System.out.println(fileWriter(data1.concat(" " + data2),filename));
    }

}
