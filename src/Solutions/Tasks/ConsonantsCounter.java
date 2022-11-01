package Solutions.Tasks;

import Solutions.SolutionPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsonantsCounter extends SolutionPattern {

    private String filePath = "src/Solutions/Tasks/Results/consonantsCounterResults";
    public ConsonantsCounter(){}
    public ConsonantsCounter(String line){
        this.line = line;
    }
    public ConsonantsCounter(ConsonantsCounter consonantsCounter){
        this.line = consonantsCounter.line;
    }

    protected String computeResult(){
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
        return result;

    }
}
