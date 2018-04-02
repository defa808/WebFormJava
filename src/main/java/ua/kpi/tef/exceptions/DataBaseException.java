package main.java.ua.kpi.tef.exceptions;

public class DataBaseException extends Exception {
    private String message;

    public DataBaseException(){
        message = null;
    }
    public DataBaseException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "DataBaseException{" +
                "message='" + message + '\'' +
                '}';
    }
}
