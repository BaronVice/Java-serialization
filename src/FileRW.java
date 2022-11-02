import Solutions.SolutionPattern;

import java.io.*;
import java.util.ArrayList;

public class FileRW {

    // Read objects from file
    public static ArrayList<SolutionPattern> readPreviousResults(String filePath){
        ArrayList<SolutionPattern> solutions = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            while (true){
                SolutionPattern solution = (SolutionPattern)ois.readObject();
                if(solution != null){
                    solutions.add(solution);
                }
                else{
                    break;
                }
            }

//            ois.close();
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Wrong class");
        }

        return solutions;
    }


    // Write object to file
    public static void writeObjectToFile(String filePath, SolutionPattern objectToWrite){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){

            oos.writeObject(objectToWrite);
            oos.flush();
//            oos.close();
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }

}
