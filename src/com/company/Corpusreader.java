package com.company;

/**
 * Noah Freriksen
 * 402535
 * Corpusreader class
 *
 * Class that reads words from corpus1.txt. Saves them in a hashmap
 * with a count of how many times this word is in the text file
 */

import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Corpusreader {

    public static void main(String[] args) throws IOException {

        File file = new File("/home/noah/IdeaProjects/Java_2/Assignment1/lib/corpus1.txt");
        Scanner input = new Scanner(file);
        int count = 0;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (input.hasNext()){

            //Read word from text file
            String word = input.next();
            System.out.println("Words readed: " + count);
            count++;

            //if key does not exists, put 1 as value, otherwise sum 1
            //to the value linked to the word
            map.merge(word, 1, Integer::sum);


        }
    }
}
