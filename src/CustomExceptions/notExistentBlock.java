package CustomExceptions;

public class notExistentBlock extends Exception{
    public notExistentBlock(){
        super();
    }
    public notExistentBlock(String description){
        super(description);
    }
}
