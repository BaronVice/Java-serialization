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
    protected void showResult(){
        System.out.printf("Результат выполнения: %s\n", result);
    }
    @Override
    public void getResult() {
        computeResult();
        showResult();
    }

    @Override
    public String toString(){
        return String.format("%s : %s", this.line, this.result);
    }

    protected boolean isEmptyLine(){
        if(this.line.trim().isEmpty()){
            return true;
        }
        return false;
    }

    protected void computeResult(){
        // algorithm here
    }
}
