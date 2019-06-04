package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Interactor inte = new Interactor();
        inte.correctFile("/home/noah/IdeaProjects/Java_2/Assignment1/text.txt");

        inte.correctSentence();

    }
}
