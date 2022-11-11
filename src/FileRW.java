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
        catch (IOException ignored){
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
        possibleIssues.add("нужно как минимум два слова для составления пар");

        if (possibleIssues.contains(objectToWrite.getResult())){
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectToWrite.getFilePath()))){

                SolutionPattern solution = (SolutionPattern) ois.readObject();
                if (solution != null) {
                    try(AppendableObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(objectToWrite.getFilePath(), true))){
                        oos.writeObject(objectToWrite);
                        oos.flush();
                    }

                } else {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectToWrite.getFilePath()))) {
                        oos.writeObject(objectToWrite);
                        oos.flush();
                    }
                }

        }
        catch (FileNotFoundException e){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectToWrite.getFilePath()))) {
                oos.writeObject(objectToWrite);
                oos.flush();
            }
            catch (IOException ignored){}
        }
        catch (ClassNotFoundException e){
            System.out.println("Чтение постороннего класса");
        }
        catch (IOException ignored){}
    }

    // Delete object from file
    public static void deleteObjectFromFile(SolutionPattern solutionObj, int index){
        ArrayList<SolutionPattern> solutionsAfterRemove = readPreviousResults(solutionObj.getFilePath());
        try{
            solutionsAfterRemove.remove(index-1);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Позиция не найдена");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(solutionObj.getFilePath()))) {
            for (SolutionPattern solution : solutionsAfterRemove){
                oos.writeObject(solution);
            }
            oos.flush();
        }
        catch (IOException ignored){}


    }

}
