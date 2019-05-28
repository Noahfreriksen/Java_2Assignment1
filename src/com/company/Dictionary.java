package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Noah Freriksen
 * 402535
 * Readdictionary class
 *
 * Class that reads a txt file dictionary in format: "word" "count"
 */

public class Dictionary {

    private String path;
    private HashMap<String, Integer> map = new HashMap<>();
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', };
    private HashMap<String, Integer> possibilities = new HashMap<>();



    public Dictionary(String path){
        this.path = path;
    }

    public void readDictionary() {

        try {
            File file = new File(path);
            Scanner input = new Scanner(file);
            int i = 0;

            while (input.hasNextLine()) {
                String word = input.next();
                int count = Integer.parseInt(input.next());
                map.put(word, count);
            }
        }

        catch(IOException e){
            System.out.println(e);
        }
    }

    private void deletion(String word)
    {
        String newWord;

        //Add letter at the beginning of the word
        for(char c : alphabet)
        {
            newWord = c + word;
            if (map.containsKey(newWord))
            {
                possibilities.put(newWord, map.get(newWord));
            }
        }

        //add letter inside a word
        for(int i = 1; i < word.length(); i++)
        {
            for(char c : alphabet)
            {
                newWord = word.substring(0,i) + c + word.substring(i,word.length()-1);
                if (map.containsKey(newWord))
                {
                    possibilities.put(newWord, map.get(newWord));
                }
            }
        }

        //add letter at the end
        for(char c : alphabet)
        {
            newWord = word + c;
            if (map.containsKey(newWord))
            {
                possibilities.put(newWord, map.get(newWord));
            }
        }
    }

    private void insertion(String word)
    {
        String newWord;

        for (int i = 0; i < word.length(); i++)
        {
            newWord = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(newWord))
            {
                possibilities.put(newWord, map.get(newWord));
            }
        }
    }

    private void transposition(String word)
    {
        char c1, c2;
        String end, newWord, begin;

        for (int i = 0; i < word.length()-1; i++)
        {
            begin = word.substring(0,i);
            c1 = word.charAt(i);
            c2 = word.charAt(i+1);
            end = word.substring(i+2);

            newWord = begin + c2 + c1 + end;

            if (map.containsKey(newWord))
            {
                possibilities.put(newWord, map.get(newWord));
            }
        }
    }

    private void replacement(String word)
    {
        String newWord;

        for(int i = 0; i < word.length(); i++)
        {
            for (char c : alphabet)
            {
               newWord = word.substring(0,i) + c + word.substring(i+1);
                if (map.containsKey(newWord))
                {
                    possibilities.put(newWord, map.get(newWord));
                }
            }
        }
    }

    public String check(String word)
    {

        if (map.containsKey(word))
        {
            return word;
        }

        possibilities.clear();

        deletion(word);
        insertion(word);
        transposition(word);
        replacement(word);

        int highvalue = 0;
        String highkey = "";

        //find word with highest value
        Iterator it = possibilities.entrySet().iterator();
        while (it.hasNext())
        {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            if ((Integer)pair.getValue() > highvalue)
            {
                highkey = pair.getKey().toString();
            }
            it.remove();
        }

        if (highkey.equals(""))
        {
            return word;
        }

        else
        {
            return highkey;
        }
    }
}
