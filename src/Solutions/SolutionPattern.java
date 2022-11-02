package Solutions;

import java.io.Serial;
import java.io.Serializable;

public abstract class SolutionPattern implements Serializable {
    protected String filePath = "path_should_be_here";
    protected String line;
    protected String result;


    public void setLine(String line) {
        this.line = line;
    }
    public String getResult(){
        return this.result;
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
    public void handleResult() {
        computeResult();
        showResult();
    }

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
