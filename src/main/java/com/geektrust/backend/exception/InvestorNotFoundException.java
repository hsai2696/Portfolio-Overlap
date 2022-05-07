package com.geektrust.backend.exception;

public class InvestorNotFoundException extends  RuntimeException{

    public InvestorNotFoundException(){
        super();
    }
    public InvestorNotFoundException(String message){
        super(message);
    }
}
