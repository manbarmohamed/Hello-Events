package com.hello.event.exception;

public class UsernameAlreadyTaken extends RuntimeException{
    public UsernameAlreadyTaken(String alreadyTaken){
        super("username alreadyTaken !");
    }


}


