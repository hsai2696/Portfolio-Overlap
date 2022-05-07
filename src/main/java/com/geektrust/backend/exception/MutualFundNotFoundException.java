package com.geektrust.backend.exception;

public class MutualFundNotFoundException  extends  RuntimeException{

    public MutualFundNotFoundException(){
        super();
    }
    public MutualFundNotFoundException(String message){
        super(message);
    }
}
