package com.rvj;

public class InputCheck {


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
