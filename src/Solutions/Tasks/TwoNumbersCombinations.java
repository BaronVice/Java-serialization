package Solutions.Tasks;

import Solutions.SolutionPattern;

import java.util.ArrayList;

public class TwoNumbersCombinations extends SolutionPattern {

    private String filePath = "src/Solutions/Tasks/Results/twoNumbersCombinationsResults";
    public TwoNumbersCombinations(){}
    public TwoNumbersCombinations(String line){
        this.line = line;
    }
    public TwoNumbersCombinations(TwoNumbersCombinations twoNumbersCombinations){
        this.line = twoNumbersCombinations.line;
    }
    // TODO: возможно при исключениях следует приписывать их в result
    protected String computeResult() {
        result = "";
        String[] splitLine = line.split("[\\s+]");
        ArrayList<Float> numbers = new ArrayList<>();

        for (String el : splitLine){
            try{
                numbers.add(Float.parseFloat(el));
            }
            catch (NumberFormatException e){
                return result;
            }
        }

//        if (numbers.size() < 2){
//            output += "Can't work with zero or one element\n";
//            return output;
//        }

        for (float first : numbers) {
            for (float second : numbers) {
                if (first * 2 < second) {
                    result += String.format("%f %f, ", first, second);
                }
            }
        }

        return result;
    }
}
