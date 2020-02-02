package com.rvj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        String entry;
        SRPN srpn = new SRPN();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You are free to start using the calculator");

        try{
            while (true){
                entry = reader.readLine();
                if(entry==null){
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
