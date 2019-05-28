package com.company;

public class Main {

    public static void main(String[] args) {

        Dictionary dict = new Dictionary("/home/noah/IdeaProjects/Java_2/Assignment1/Dictionary.txt");
        dict.readDictionary();
        System.out.print(dict.check("talbe"));

    }
}
