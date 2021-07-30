package com.mphasis.main;

import com.mphasis.components.EmailService;
import com.mphasis.components.MessageService;
import com.mphasis.components.TextEditor;
import com.mphasis.components.TwitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        MessageService messageService = new EmailService();
//        messageService.sendMessage("This is email","raj@gmail.com");
//
//        messageService = new TwitterService();
//        messageService.sendMessage("This is tweet","raj");

        AbstractApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/mphasis/main/Beans.xml");

         context.registerShutdownHook();
//
//        MessageService messageService = (MessageService) context.getBean("emailService");
//        messageService.sendMessage("an email"," raj@gmail.com");
//
//        messageService = (MessageService) context.getBean("twitterService");
//        messageService.sendMessage("a tweet", " raj");
//
//        messageService = (MessageService) context.getBean("twitterService");
//        messageService.sendMessage("a tweet", " raj");
//
//        messageService = (MessageService) context.getBean("emailService");
//        messageService.sendMessage("an email", " raj");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();
        System.out.println(textEditor.getSpellchecker().getName());


    }
}
