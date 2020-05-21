package com.codecool;

import java.util.Scanner;

public class IO {
    Scanner scan = new Scanner(System.in);

    public IO() {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
    }


    public String gatherInput(String title) {
        System.out.println(title);
        String userInput;
        userInput = scan.next();
            
        return userInput;
    }

}