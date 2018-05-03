package com.googlecodejam.practice.year2017.round1C.task1;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {


        System.out.println(new Test().hasUniqueCharacters("asda"));
        System.out.println(new Test().hasUniqueCharacters1("asda"));

    }

    public boolean hasUniqueCharacters(String word) {
        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            boolean isUnique = characters.add(word.charAt(i));
            if (!isUnique) {
                return false;
            }
        }
        return true;
    }


    public boolean hasUniqueCharacters1(String word) {
        boolean characters[] = new boolean[Character.MAX_VALUE];

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (characters[character]) {
                return false;
            } else {
                characters[character] = true;
            }
        }
        return true;
    }
}
