package com.mphasis.gradle;

import java.util.ArrayList;
import java.util.List;

public class Poetry {
    public List<String> ceaser(){
        List<String> lines = new ArrayList<>();
        lines.add("O, pardon me, thou bleeding piece of earth,");
        lines.add("That I am meek and gentle with these butchers!");
        lines.add("Thou art the ruins of the noblest man");
        lines.add("That ever lived in the tide of times.");
        lines.add("Woe to the hand that shed this costly blood!");
        lines.add("Over thy wounds now do I prophesy,");
        return lines;
    }
    public void emit(List<String> lines){
        for(String line:lines){
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        Poetry poetry = new Poetry();
        poetry.emit(poetry.ceaser());

    }
}
