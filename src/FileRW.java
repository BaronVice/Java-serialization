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
//                System.out.println(solution);
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
            System.out.println("Чтение постороннего класса");
        }

        return solutions;
    }


    // Write object to file
    public static void writeObjectToFile(SolutionPattern objectToWrite){
        ArrayList<String> possibleIssues = new ArrayList<>();
        possibleIssues.add("задана пустая строка");
        possibleIssues.add("в массиве чисел встречен посторонний символ (для дроби используйте точку)");

        if (possibleIssues.contains(objectToWrite.getResult())){
            return;
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectToWrite.getFilePath(), true))){
            oos.writeObject(objectToWrite);
            oos.flush();
            oos.close();
        }
        catch (IOException e){
            System.out.println("Такой путь не найден");
        }
    }

}
