package com.rvj;

import java.util.Stack;

/*
    The RpnClass uses the Stack class in Java and the reason why I have decided to use this is
    because Java implements best defensive tactics for cases such as concurrency based on the documentation.
    This information is available in java.util. Additionally I am trying of existing features in the language
    and avoid code bloat.

    Stack uses the principles of LIFO - First in Last Out for managing data elements
 */
public class RpnStack {
    private Stack<Integer> stack = new Stack<>();

    public void push(int n){
        stack.push(n);
    }

    //Pop removes the top entry at the top of the stack
    public int pop(){
        if (!isEmpty()) {
            int n = stack.pop();
            return n;
        }
        return 0;
    }

    /*Peek returns the top of the stack without removing it. According to the use case
    if the stack is empty the MIN_VALUE is returned.
    */
    public int peek(){
        if(!isEmpty()){
            int n =stack.peek();
            return n;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    /*displayStock will display all items currently on the stack. According to the use case,
    if the stack is empty, the MIN_VALUE is returned.
    */
    public void displayStack(){
        if(isEmpty()){
            System.out.println(Integer.MIN_VALUE);
        } else {
            for(int item : stack){
                System.out.println(item);
            }
        }
    }
}
