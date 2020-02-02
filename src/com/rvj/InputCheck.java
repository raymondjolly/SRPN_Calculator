package com.rvj;

public class InputCheck {

    int commentSkip;

    public InputCheck() {
    }

    public boolean isInt(char toTest){
        try{
            Long.parseLong(Character.toString(toTest));
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public int digitCount(int number){
        int count = 0;
        while(number !=0){
            number/=10;
            count++;
        }
        return count;
    }

    public int commmentFlag(String string, int index){
        int i;
        for(i = index; i<string.length(); i++){
            if(string.charAt(i)=='#'){
                commentSkip+=1;
            } else if(i==string.length()-1){
                System.out.printf("Unrecognized operator or operand %c\n", '#');
            }
        }
        return commentSkip;
    }
}
