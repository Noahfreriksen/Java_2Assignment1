package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * Noah Freriksen
 * 402535
 *
 * Interactor class
 * Interacts with the user.
 * Correctfile corrects a file with given path and writes the corrected version to a new file named Correctedtext.txt
 */

public class Interactor{

    public void correctFile() throws IOException
    {
        System.out.println("Please give the path of the file you want to correct:");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        File file = new File(path);
        Scanner input = new Scanner(file);

        BufferedWriter writer = new BufferedWriter(new FileWriter("Correctedtext.txt"));

        Dictionary dict = new Dictionary("/home/noah/IdeaProjects/Java_2/Assignment1/Dictionary.txt");
        dict.readDictionary();

        while(input.hasNext())
        {
            String word = input.next();
            String corrected = dict.check(word);
            writer.append(corrected);
            writer.append(" ");
        }
        writer.close();
    }

    void correctFile(String path) throws IOException
    {
        File file = new File(path);
        Scanner input = new Scanner(file);

        Dictionary dict = new Dictionary("/home/noah/IdeaProjects/Java_2/Assignment1/Dictionary.txt");
        dict.readDictionary();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Correctedtext.txt"));

        while(input.hasNext())
        {
            String word = input.next();
            String corrected = dict.check(word);
            writer.append(corrected);
            writer.append(" ");
        }
        writer.close();
    }

    public void correctSentence()
    {
        System.out.println("Please give the sentence you want to correct: ");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        String[] words = sentence.split("\\s+");

        Dictionary dict = new Dictionary("/home/noah/IdeaProjects/Java_2/Assignment1/Dictionary.txt");
        dict.readDictionary();

        for (String word : words)
        {
            System.out.print(dict.check(word) + " ");
        }
    }
}
