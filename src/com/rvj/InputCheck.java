package com.rvj;

public class InputCheck {

    /***
     * InputCheck is an object with several methods to check specific
     * string conditions based on observed requirements. Please read
     * the README.md file for more information.
     */
    public InputCheck() {
    }

    /***
     * isInt is a method to check is a character in the string is a numerical digit.
     * @param toTest is an argument to check if the char is an int.
     * @return boolean
     */
    public boolean isInt(char toTest){
        try{
            Long.parseLong(Character.toString(toTest));
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /***
     * digitCount takes an int argument and counts the number of digits
     * in the number. For example: 100 returns a value of 3.
     * @param number is the integer to be tested
     * @return the count of digits in the number
     */
    public int digitCount(int number){
        int count = 0;
        while(number !=0){
            number/=10;
            count++;
        }
        return count;
    }

    /***
     * commentFlag checks for two conditions. If the character equals '#',
     * end the loop and return character location. Otherwise, print 'Unrecognized
     * operator or operand for the character. Note that SRPN will have other conditions
     * for operators and integers to implement additional filters.
     * @param string derived from user Input
     * @param index index location in the string
     * @return int value representing the char location to skip
     */
    public int commentFlag(String string, int index){
        int commentSkip=0;
        int i;
        for(i = index; i<string.length(); i++){
            if(string.charAt(i)=='#'){
                commentSkip = string.length();
                break;
            } else if(i==string.length()-1){
                System.out.printf("Unrecognized operator or operand %c\n", '#');
                commentSkip=0;
            }
        }
        return commentSkip;
    }

}
