package com.rvj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) {

        /***
         * Main is the entry of the program where a buffered reader is created to read
         * user input to be processed by SRPN. This function will continue to accept
         * user input until user decides to stop with a CTRL-D operation.
         */
        String entry;
        SRPN srpn = new SRPN();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You are free to start using the calculator");
        System.out.println("To stop the program, press Ctrl-D");

        try{
            while (true){
                entry = reader.readLine();
                if(entry==null){
                    System.out.println("Exiting SRPN");
                    System.exit(0);
                }
                srpn.parseInput(entry);
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }


    }
}
