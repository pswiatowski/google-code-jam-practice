package com.googlecodejam.practice.year2016.qualification.task1;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingSheepVersion2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextInt();

        Set<Character> collect = Sets.newHashSet();

        collect.addAll(String.valueOf(t).chars().mapToObj(e -> (char) e).collect(Collectors.toSet()));


        System.out.println(collect);
    }
}
