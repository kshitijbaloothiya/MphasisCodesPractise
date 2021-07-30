package com.mphasis.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
    private Spellchecker spellchecker;
    private String name;

    public TextEditor(Spellchecker spellchecker, String name) {
        this.spellchecker = spellchecker;
        this.name = name;
    }

    public TextEditor(Spellchecker spellchecker) {
        this.spellchecker = spellchecker;
    }

    @Autowired
    public void setSpellchecker(Spellchecker spellchecker) {
        this.spellchecker = spellchecker;
    }


//    public TextEditor(Spellchecker spellchecker) {
//        System.out.println("Inside TextEditor");
//        this.spellchecker = spellchecker;
//    }


    public String getName() {
        return name;
    }

    public Spellchecker getSpellchecker() {
        return spellchecker;
    }




    public void spellCheck(){
        spellchecker.checkSpelling();
    }

}
