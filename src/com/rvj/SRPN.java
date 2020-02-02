package com.rvj;

import java.util.Scanner;

/***
 * SRPN is an object with one method to parse through user input.
 */
public class SRPN {
    Calculate calculate = new Calculate();
    InputCheck inputCheck = new InputCheck();

    /***
     * SRPN constructor
     */
    public SRPN() {
    }

    /***
     * parseInput parses through the string, will check the property of the character and will take action
     * based on specific conditions. If a character is detects a '-', the function then needs to check if the next index
     * detects an integer. If the next char is an integer, then it is determined to be a negative number which will be pushed
     * to the top of the stack. Otherwise the '-' sign will be interpreted as a subtraction operation. The method will
     * then check if the character is a '0' or if the next location is a digit as there is a valid use case of '01'. Entering
     * '01' is a valid entry where 1 is pushed to the top of the stack. The method will then go through the string to check other
     * conditions such as math operators, a '#' where following comments can be ignored, 'r' to push random integers to the
     * stack, 'd' to detect a display stack command, and if the other characters cannot be recognized.
     *
     * @param entry User input string
     */
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
