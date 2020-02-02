package com.rvj;

import java.util.Scanner;

public class SRPN {
    Calculate calculate = new Calculate();
    InputCheck inputCheck = new InputCheck();

    public SRPN() {
    }

    public void parseInput(String entry){
        int counter = 0;
        long nextNumber;

        //D+ is a parameter to a regular expression to delimit where a digit (0-9) is detected in the string
        Scanner scanner = new Scanner(entry).useDelimiter("\\D+");

        while (counter<entry.length()){
            //check to see if this is a minus operator or a negative designation
             if (entry.charAt(counter)=='-'){
                 try{
                     if(inputCheck.isInt(entry.charAt(counter+1))){
                         nextNumber = scanner.nextLong();
                         nextNumber *= -1;
                         calculate.push(nextNumber);
                         counter+=inputCheck.digitCount((int) nextNumber);
                     }
                     //with RPN the operator comes last to compensate
                 }catch (StringIndexOutOfBoundsException e){
                     calculate.subtract();
                 }
                 //Check for 0s
             }  else if(entry.charAt(counter)=='0'){
                 try {
                     //if characters are not a number, move on and increment the counter
                     if(!(inputCheck.isInt(entry.charAt(counter)))){
                         calculate.push(counter);
                     }else {
                         //otherwise add 0 to the stack
                         calculate.push(0);
                     }
                 }   catch (StringIndexOutOfBoundsException e){
                     calculate.push(0);
                 }
             }  else if (inputCheck.isInt(entry.charAt(counter))) {
                 nextNumber = scanner.nextInt();
                 calculate.push(nextNumber);
                 counter += inputCheck.digitCount((int) nextNumber) - 1;
             } else {
                 if(entry.charAt(counter)== Operators.add){
                     calculate.add();
                 } else if(entry.charAt(counter)==Operators.subtract){
                     calculate.subtract();
                 } else if(entry.charAt(counter)==Operators.multiply){
                     calculate.multiply();
                 } else if(entry.charAt(counter)==Operators.divide) {
                     calculate.divide();
                 } else if(entry.charAt(counter)==Operators.power) {
                     calculate.power();
                 } else if (entry.charAt(counter)==Operators.remainder){
                     calculate.remainder();
                 } else if (entry.charAt(counter)==Operators.random){
                     calculate.rand();
                 } else if (entry.charAt(counter)==Operators.equals){
                     calculate.equals();
                 } else if (entry.charAt(counter)==Operators.displayStack){
                     calculate.display();
                 } else if (entry.charAt(counter)== Operators.commenter){
                     counter+=inputCheck.commentFlag(entry,counter);
                 } else if (entry.charAt(counter)!= Operators.spacer){
                     System.out.printf("Unrecognized operator or operand %c\n", entry.charAt(counter));
                 }
             }
             counter+=1;
        }
    }
}
