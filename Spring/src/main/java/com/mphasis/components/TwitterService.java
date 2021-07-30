package com.mphasis.components;

public class TwitterService implements MessageService{
    public TwitterService() {
        System.out.println("TwitterService instantiated");
    }

    @Override
    public boolean sendMessage(String message, String receiver) {
        System.out.println("Email send to"+receiver+" with message "+message);
        return true;
    }
    public void destroy(){
        System.out.println("twitterService destroyed");
    }
    public void init(){
        System.out.println("twitterService initialized");
    }
}
