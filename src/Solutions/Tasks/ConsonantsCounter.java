package Solutions.Tasks;

import Solutions.SolutionPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsonantsCounter extends SolutionPattern {
    public ConsonantsCounter(){
        this.filePath = "src/Solutions/Tasks/Results/consonantsCounterResults";
    }
    public ConsonantsCounter(String line){
        this.line = line;
        this.filePath = "src/Solutions/Tasks/Results/consonantsCounterResults";
    }
    public ConsonantsCounter(ConsonantsCounter consonantsCounter){
        this.line = consonantsCounter.line;
        this.filePath = "src/Solutions/Tasks/Results/consonantsCounterResults";
    }

    protected void computeResult(){
        if(isEmptyLine()){
            this.result = "задана пустая строка";
            return;
        }

        result = "";
        String consonants = "";
        int total = 0;

        List<Character> lettersArray = line.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> consonantsArr = new ArrayList<>(Arrays.asList('B', 'b', 'C', 'c', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h',
                'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'P', 'p',
                'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'V', 'v', 'W', 'w',
                'X', 'x', 'Y', 'y', 'Z', 'z'));
        for (char letter : lettersArray) {
            if (consonantsArr.contains(letter)){
                consonants += letter + " ";
                total++;
            }
        }
        result = String.valueOf(total);
        // Запись
    }
}
