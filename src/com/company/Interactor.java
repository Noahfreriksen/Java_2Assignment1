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
        //TODO add character recognition
        System.out.println("Please give the path of the file you want to correct:");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        File file = new File(path);
        Scanner input = new Scanner(file).useDelimiter(" ");

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
            String[] duo = split(word);

            String corrected = dict.check(duo[0]);
            writer.append(corrected);

            if (duo[1].equals(""))
            {
                writer.append(" ");
            }

            else
            {
                writer.append(duo[1]);
            }
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

    /**
     *
     * @param word to split into word and character
     * @return String array with on location 0 the word and
     * location 1 the character that is not a letter
     */
    String[] split(String word)
    {
        char last = word.charAt(word.length()-1);
        char[] splitted = new char[65];
        String[] duo = new String[2];

        if((last >= 65 && last <= 90) || (last >= 96 && last <= 122))
        {
            duo[0] = word;
            duo[1] = "";
            return duo;
        }

        else
        {
            word.getChars(0, word.length()-1, splitted, 0);
            duo[0] = new String(splitted);
            duo[1] = String.valueOf(last);
            return duo;
        }
    }
}
