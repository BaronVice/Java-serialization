package CustomExceptions;

public class notExistentTask extends Exception{
    public notExistentTask(){
        super();
    }
    public notExistentTask(String description){
        super(description);
    }
}
