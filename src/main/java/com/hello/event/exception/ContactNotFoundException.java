package com.hello.event.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String contactNotFound){
        super("contact not found !");
    }


}


