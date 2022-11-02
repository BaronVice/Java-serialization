package Solutions.Tasks;

import Solutions.SolutionPattern;

import java.util.ArrayList;

public class TwoNumbersCombinations extends SolutionPattern {
    public TwoNumbersCombinations(){
        this.filePath = "src/Solutions/Tasks/Results/twoNumbersCombinationsResults";
    }
    public TwoNumbersCombinations(String line){
        this.line = line;
        this.filePath = "src/Solutions/Tasks/Results/twoNumbersCombinationsResults";
    }
    public TwoNumbersCombinations(TwoNumbersCombinations twoNumbersCombinations){
        this.line = twoNumbersCombinations.line;
        this.filePath = "src/Solutions/Tasks/Results/twoNumbersCombinationsResults";
    }

    protected void computeResult() {
        if(isEmptyLine()){
            this.result = "задана пустая строка";
            return;
        }

        result = "";
        String[] splitLine = line.split("[\\s+]");
        ArrayList<Float> numbers = new ArrayList<>();

        for (String el : splitLine){
            try{
                numbers.add(Float.parseFloat(el));
            }
            catch (NumberFormatException e){
                result = "в массиве чисел встречен посторонний символ (для дроби используйте точку)";
                return;
            }
        }

        for (float first : numbers) {
            for (float second : numbers) {
                if (first * 2 < second) {
                    result += String.format("%f %f; ", first, second);
                }
            }
        }
        result = result.substring(0, result.length() - 2);
        // Запись
    }
}
