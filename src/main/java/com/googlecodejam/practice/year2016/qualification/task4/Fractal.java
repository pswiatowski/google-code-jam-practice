package com.googlecodejam.practice.year2016.qualification.task4;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Fractal {

    public static void main(String[] args) {
        int size = 3;


        int K = 9;
        // create all input
        List<String> strings = generateCombinations(K, Lists.newArrayList("G", "L"));


        int C = 2;
        // generate fractal
        List<String> strings3 = Lists.newArrayList();
        for (int m = 0; m < strings.size(); m++) {

            String s = strings.get(m);
            char[] chars = s.toCharArray();

            String s2 = "";
            for (int j = 0; j < K; j++) {

                char newChar = chars[j];
                if (newChar == 'L') {
                    s2 += s;
//                    System.out.print(s);
                } else {

                    for (int l = 0; l < K; l++) {
                        s2 += "G";
//                        System.out.print("G");
                    }
                }
            }
            strings3.add(s2);
//            System.out.println("");
        }

        for(String s : strings3) {
            long count = s.chars().filter(ch -> ch == 'G').count();
//            System.out.println("" + count);
//            if (count == ((K * 2)  - 1)) {
                System.out.println(s);
//            }
        }

        List<String> strings4 = Lists.newArrayList();
        for (int m = 0; m < strings3.size(); m++) {

            String s = strings3.get(m);
            char[] chars = s.toCharArray();

            String s2 = "";
            for (int j = 0; j < chars.length; j++) {

                char newChar = chars[j];
                if (newChar == 'L') {
                    s2 += strings.get(m);
//                    System.out.print(strings.get(m));
                } else {

                    for (int l = 0; l < K; l++) {
                        s2 += "G";
//                        System.out.print("G");
                    }
                }
            }
            strings4.add(s2);
//            System.out.println("");
        }

        for(String s : strings4) {
            long count = s.chars().filter(ch -> ch == 'G').count();
//            System.out.println("" + count);
//            if (count == 37) {
                System.out.println(s);
//            }
        }
    }

    private static List<String> generateCombinations(int arraySize, ArrayList<String> possibleValues) {
        List<String> strings = Lists.newArrayList();
        int carry;
        int[] indices = new int[arraySize];
        do {
            StringBuilder s = new StringBuilder();
            for (int index : indices) {
                s.append(possibleValues.get(index));
                System.out.print(possibleValues.get(index) + "");
            }

            strings.add(s.toString());
            System.out.println("");

            carry = 1;
            for (int i = indices.length - 1; i >= 0; i--) {
                if (carry == 0)
                    break;

                indices[i] += carry;
                carry = 0;

                if (indices[i] == possibleValues.size()) {
                    carry = 1;
                    indices[i] = 0;
                }
            }
        }
        while (carry != 1); // Call this method iteratively until a carry is left over

        return strings;
    }
}
