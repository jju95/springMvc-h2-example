package pagingExam.demo.common.exception;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException(){
        super("No Data Found");
    }
}
