package Solutions.Tasks;

import Solutions.SolutionPattern;

public class ThreeWordsCombinations extends SolutionPattern {
    public ThreeWordsCombinations(){
        this.filePath = "src/Solutions/Tasks/Results/threeWordsCombinationsResults";
    }
    public ThreeWordsCombinations(String line){
        this.line = line;
        this.filePath = "src/Solutions/Tasks/Results/threeWordsCombinationsResults";
    }
    public ThreeWordsCombinations(ThreeWordsCombinations threeWordsCombinations){
        this.line = threeWordsCombinations.line;
        this.filePath = "src/Solutions/Tasks/Results/threeWordsCombinationsResults";
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private int countCombs(int num){
        return (int)(factorial(num) / ((factorial(3)*factorial(num-3))));
    }

    protected void computeResult() {
        if(isEmptyLine()){
            this.result = "задана пустая строка";
            return;
        }

        result = "";

        String[] allWords = line.split("[,.\\s+]");
        int counter = 0;
        int combinations = 0;
        for (String word : allWords) {
            if (word.length() != 0) {
                counter++;
            }
        }
        combinations = countCombs(counter);

        result = String.valueOf(combinations);
        // Запись
    }
}
