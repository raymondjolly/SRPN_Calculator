package com.rvj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RpnStack numbers = new RpnStack();
//        numbers.push(76);
//        numbers.push(89);
//        numbers.push(76);


        System.out.println(numbers.peek());
        System.out.println("========");
        numbers.displayStack();

    }
}
