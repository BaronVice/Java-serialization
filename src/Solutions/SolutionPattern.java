package Solutions;

import java.io.Serial;
import java.io.Serializable;

public abstract class SolutionPattern implements SolutionAnswer, Serializable {
    protected String filePath;
    protected String line;
    protected String result;


    @Override
    public void setLine(String line) {
        this.line = line;
    }
    public String getLine(){
        return this.line;
    }
    public String getFilePath(){
        return this.filePath;
    }
    @Override
    public String getResult() {
        return computeResult();
    }

    @Override
    public String toString(){
        return String.format("%s : %s", this.line, this.result);
    }

    // TODO: сделать нормальную проверку на пустую линию (это уже не то, с чем хочется работать)
    protected boolean checkIfEmpty(String line){
        if(this.line == "EmptyLineGiven"){
            return true;
        }
        return false;
    }

    protected String computeResult(){
        return "PatternResult";
    }
}
