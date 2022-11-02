package Solutions.Tasks;

import Solutions.SolutionPattern;

public class TwoWordsCombinations extends SolutionPattern {
    public TwoWordsCombinations(){
        this.filePath = "src/Solutions/Tasks/Results/twoWordsCombinationsResults";
    }
    public TwoWordsCombinations(String line){
        this.line = line;
        this.filePath = "src/Solutions/Tasks/Results/twoWordsCombinationsResults";
    }
    public TwoWordsCombinations(TwoWordsCombinations twoWordsCombinations){
        this.line = twoWordsCombinations.line;
        this.filePath = "src/Solutions/Tasks/Results/twoWordsCombinationsResults";
    }

    protected void computeResult(){
        if(isEmptyLine()){
            this.result = "задана пустая строка";
            return;
        }

        result = "";

        String[] allWords = line.split("[,.\\s+]");

        for (String firstWord : allWords) {
            if(firstWord.length() != 0){
                for(String secondWord : allWords){
                    if(secondWord.length() != 0){
                        if (firstWord != secondWord){
                            result += String.format("%s %s, ", firstWord, secondWord);
                        }
                    }
                }
            }
        }
        result = result.substring(0, result.length() - 2);
        // Запись

    }
}
