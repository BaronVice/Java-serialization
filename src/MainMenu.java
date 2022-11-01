import CustomExceptions.*;
import Solutions.Tasks.*;

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
        switch (block){
            case "main":
                System.out.println("\nВыбор команды:\n" +
                        "1) Выполнить задание a.\n" +
                        "2) Выполнить задание b.\n" +
                        "3) Выполнить задание c.\n" +
                        "4) Выполнить задание d.\n" +
                        "5) Вывести предыдущие результаты\n" +
                        "6) Выход\n");
                break;
            case "results":
                System.out.println("\nВыбор команды:\n" +
                        "1) Получить результаты a.\n" +
                        "2) Получить результаты b.\n" +
                        "3) Получить результаты c.\n" +
                        "4) Получить результаты d.\n" +
                        "5) Назад\n");
                break;
            default:
                throw new notExistentBlock("Chosen block does not exists");
        }
    }

    private void chooseOption(String block) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выбор команды (ее номер): ");
        String chosenOption = scan.nextLine();

        switch (block){
            case "main":
                requestMainOption(chosenOption);
                break;
            case "results":
                requestResultsOption(chosenOption);
                break;
            default:
                throw new notExistentBlock("Chosen block does not exists");
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

    private void requestMainOption(String chosenOption) throws Exception {
        String currentBlock = "main";
        String inputLine;

        // TODO: после создания solution прикрутить вызов методов вычисления
        //  подумать над созданием отдельных объектов (вспомогательные методы
        //  при uppercaste'e теряются (вроде бы))
        switch (chosenOption){
            case "1":
                solutionA.setLine(sendRequest(chosenOption));
                solutionA.getResult();

                System.out.println("Выполнение a.");
                break;
            case "2":
                solutionB.setLine(sendRequest(chosenOption));
                System.out.println("Выполнение b.");
                break;
            case "3":
                solutionC.setLine(sendRequest(chosenOption));
                System.out.println("Выполнение c.");
                break;
            case "4":
                solutionD.setLine(sendRequest(chosenOption));
                System.out.println("Выполнение d.");
                break;
            case "5":
                currentBlock = "results";
                printDescription("results");
                break;
            case "6":
                System.exit(0);
                break;
            case "help":
                printDescription("main");
                break;
            default:
                System.out.println("Не найдено. Для повторного вывода списка команд введите \"help\"");
                break;
        };
        chooseOption(currentBlock);
    }

    private void requestResultsOption(String chosenOption) throws Exception {
        String currentBlock = "results";

        // TODO: к каждому случаю приписать чтение файла
        switch (chosenOption){
            case "1":
                System.out.println("Вывод результатов a.");
                break;
            case "2":
                System.out.println("Вывод результатов b.");
                break;
            case "3":
                System.out.println("Вывод результатов c.");
                break;
            case "4":
                System.out.println("Вывод результатов d.");
                break;
            case "5":
                currentBlock = "main";
                printDescription("main");
                break;
            case "help":
                printDescription("results");
                break;
            default:
                System.out.println("Не найдено. Для повторного вывода списка команд введите \"help\"");
                break;
        };
        chooseOption(currentBlock);
    }

}
