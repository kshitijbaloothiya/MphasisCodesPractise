package com.mphasis.components;

public class EmailService implements MessageService{
    public EmailService() {
        System.out.println("EmailService instantiated");
    }

    @Override
    public boolean sendMessage(String message, String receiver) {
        System.out.println("Email send to"+receiver+" with message "+message);
        return true;
    }
    public void destroy(){
        System.out.println("EmailService destroyed");
    }
    public void init(){
        System.out.println("EmailService initialized");
    }
}
