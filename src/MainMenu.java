import CustomExceptions.*;
import Solutions.SolutionPattern;
import Solutions.Tasks.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private TwoWordsCombinations solutionA = new TwoWordsCombinations();
    private ThreeWordsCombinations solutionB = new ThreeWordsCombinations();
    private TwoNumbersCombinations solutionC = new TwoNumbersCombinations();
    private ConsonantsCounter solutionD = new ConsonantsCounter();

    public MainMenu() throws Exception {
        System.out.println("Описание заданий:\n" +
                "a. Выпишите все возможные комбинации, состоящие из двух слов заданного предложения\n" +
                "b. Определите количество возможных комбинаций из трех слов заданного предложения\n" +
                "c. Дан одномерный числовой массив, определить число всевозможных комбинаций из двух элементов\n" +
                "данного массива таким образом чтобы первый элемент в паре был меньше второго более чем в два раза\n" +
                "d. Найдите число согласных букв в предложении");
        printDescription("main");
        chooseOption("main");
    }

    private void printDescription(String block) throws notExistentBlock {
        switch (block) {
            case "main" -> System.out.println(
                    "\nВыбор команды:\n" +
                    "1) Выполнить задание a.\n" +
                    "2) Выполнить задание b.\n" +
                    "3) Выполнить задание c.\n" +
                    "4) Выполнить задание d.\n" +
                    "5) Вывести предыдущие результаты\n" +
                    "6) Удалить один из результатов\n" +
                    "7) Выход\n");
            case "results" -> System.out.println(
                    "\nВыбор команды:\n" +
                    "1) Получить результаты a.\n" +
                    "2) Получить результаты b.\n" +
                    "3) Получить результаты c.\n" +
                    "4) Получить результаты d.\n" +
                    "5) Назад\n");
            case "remove" -> System.out.println(
                    "\nВыбор команды:\n" +
                    "1) Удалить результат a.\n" +
                    "2) Удалить результат b.\n" +
                    "3) Удалить результат c.\n" +
                    "4) Удалить результат d.\n" +
                    "5) Назад\n");

            default -> throw new notExistentBlock("Chosen block does not exists");
        }
    }

    private void chooseOption(String block) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выбор команды (ее номер): ");
        String chosenOption = scan.nextLine();

        switch (block) {
            case "main" -> requestMainOption(chosenOption);
            case "results" -> requestResultsOption(chosenOption);
            case "remove" -> requestRemoveOption(chosenOption);
            default -> throw new notExistentBlock("Chosen block does not exists");
        }
    }

    private String defineAlNum(String chosenOption) throws notExistentTask {
        return switch (chosenOption){
            case "1", "2", "4" -> "слова";
            case "3" -> "числа";
            default -> throw new notExistentTask("Chosen task is not included");
        };
    }

    private String sendRequest(String chosenOption) throws notExistentTask {
        System.out.printf("Введите %s через пробел: ", defineAlNum(chosenOption));

        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private void handleOption(SolutionPattern solution, String chosenOption) throws Exception{
        solution.setLine(sendRequest(chosenOption));
        solution.handleResult();
        FileRW.writeObjectToFile(solution);
    }

    private void requestMainOption(String chosenOption) throws Exception {
        String currentBlock = "main";

        switch (chosenOption) {
            case "1" -> handleOption(solutionA, chosenOption);
            case "2" -> handleOption(solutionB, chosenOption);
            case "3" -> handleOption(solutionC, chosenOption);
            case "4" -> handleOption(solutionD, chosenOption);
            case "5" -> {
                currentBlock = "results";
                printDescription("results");
            }
            case "6" -> {
                currentBlock = "remove";
                printDescription("remove");
            }
            case "7" -> System.exit(0);
            case "help" -> printDescription("main");
            default -> System.out.println("Не найдено. Для повторного вывода списка команд введите \"help\"");
        }

        chooseOption(currentBlock);
    }

    private void handlePreviousResults(SolutionPattern solution){
        ArrayList<SolutionPattern> solutions = FileRW.readPreviousResults(solution.getFilePath());
        if (solutions.size() == 0){
            System.out.println("Пока что результатов нет .-.");
        }
        else {
            for (SolutionPattern solutionPattern : solutions) {
                System.out.println(solutionPattern);
            }
        }
    }

    private void requestResultsOption(String chosenOption) throws Exception {
        String currentBlock = "results";

        switch (chosenOption) {
            case "1" -> handlePreviousResults(solutionA);
            case "2" -> handlePreviousResults(solutionB);
            case "3" -> handlePreviousResults(solutionC);
            case "4" -> handlePreviousResults(solutionD);
            case "5" -> {
                currentBlock = "main";
                printDescription("main");
            }
            case "help" -> printDescription("results");
            default -> System.out.println("Не найдено. Для повторного вывода списка команд введите \"help\"");
        }
        chooseOption(currentBlock);
    }

    private void pickIndex(SolutionPattern solution){
        System.out.print("Введите номер записи для удаления: ");

        try{
            Scanner scan = new Scanner(System.in);
            int index = scan.nextInt();

            FileRW.deleteObjectFromFile(solution, index);
        }
        catch (Exception e){
            System.out.println("Позиция не найдена");
        }
    }

    private void requestRemoveOption(String chosenOption) throws Exception {
        String currentBlock = "remove";

        switch (chosenOption) {
            case "1" -> pickIndex(solutionA);
            case "2" -> pickIndex(solutionB);
            case "3" -> pickIndex(solutionC);
            case "4" -> pickIndex(solutionD);
            case "5" -> {
                currentBlock = "main";
                printDescription("main");
            }
            case "help" -> printDescription("results");
            default -> System.out.println("Не найдено. Для повторного вывода списка команд введите \"help\"");
        }
        chooseOption(currentBlock);
    }

}
