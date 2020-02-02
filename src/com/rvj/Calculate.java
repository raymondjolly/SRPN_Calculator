package com.rvj;

import java.util.EmptyStackException;
import java.util.Stack;

/***
 * Calculate is an object that will add valid numbers to a native stack in the Java
 * library and provides methods to conduct mathematical operations.
 */
public class Calculate {
    private long firstNumber;
    private long secondNumber;
    private long result;
    private String errUnderFlow = "Stack Underflow";
    private String errDivideByZero = "Divide By 0";
    private Stack<Long> items = new Stack<>();
    private RandomNum randomNum = new RandomNum();

    /***
     * Calculate constructor
     */
    public Calculate() {
    }

    /***
     * Add pops the top 2 integers from the stack, validates if the result
     * is within the Integer.MIN_VALUE and Integer.MAX_VALUE and produces the sum
     * and pused it to the stack.
     * If the result is less than -2147483648L, -2147483648L will be returned.
     * If the result exceeds 2147483647, then the value of 2147483647 is returned.
     */
    public void add(){
        try{
            firstNumber = pop();
            secondNumber = pop();
            result = Math.addExact(firstNumber, secondNumber);
            rangeCheck(result);
        } catch (EmptyStackException e){
            System.err.println(errUnderFlow);
            resetStack();
        }
    }

    /***
     * Subtract pops the top 2 integers from the stack, validates if the result
     * is within the Integer.MIN_VALUE and Integer.MAX_VALUE and produces the difference
     * and pushes it to the stack.
     * If the result is less than -2147483648L, -2147483648L will be returned.
     * If the result exceeds 2147483647, then the value of 2147483647 is returned.
     */
    public void subtract(){
        try{
            firstNumber = pop();
            secondNumber = pop();
            result = Math.subtractExact(secondNumber, firstNumber);
            rangeCheck(result);
        } catch (EmptyStackException e){
            System.err.println(errUnderFlow);
            resetStack();
        }
    }

    /***
     * Multiply pops the top 2 integers from the stack, validates if the result
     * is within the Integer.MIN_VALUE and Integer.MAX_VALUE and produces the product
     * and pushes it to the stack.
     * If the result is less than -2147483648L, -2147483648L will be returned.
     * If the result exceeds 2147483647, then the value of 2147483647 is returned.
     */
    public void multiply(){
        try {
            firstNumber = pop();
            secondNumber = pop();
            result = Math.multiplyExact(firstNumber, secondNumber);
            rangeCheck(result);
        } catch (EmptyStackException e){
            System.err.println(errUnderFlow);
            resetStack();
            push(firstNumber);
        }
    }

    /***
     * Divide pops the top 2 integers from the stack, validates if the result
     * is within the Integer.MIN_VALUE and Integer.MAX_VALUE and produces the product and
     * pushes it to the stack.
     * If the result is less than -2147483648L, -2147483648L will be returned.
     * If the result exceeds 2147483647, then the value of 2147483647 is returned.
     */
    public void divide(){
        try{
            firstNumber = pop();
            secondNumber = pop();
            result = secondNumber / firstNumber;
            push(result);
        } catch (ArithmeticException e){
            push(secondNumber);
            push(firstNumber);
            System.out.println(errDivideByZero);
        } catch (EmptyStackException e){
            System.err.println(errUnderFlow);
            resetStack();
            push(firstNumber);
        }
    }

    /***
     * Remainder pops the top 2 numbers off of the stack. The secondNumber value
     * is the left value of the modulus operation and firstNumber is the right. The
     * result of the calculation is pushed to the top of the stack.
     */
    public void remainder(){
        try{
            firstNumber = pop();
            secondNumber = pop();
            if(firstNumber ==0){
                //Note that this is in the use case and not my intention
                //the exception would be able to handle this
                System.err.println("31 Floating point exception(core dumped");
                System.exit(0);
            } else {
                result = secondNumber % firstNumber;
                push(result);
            }
        } catch (ArithmeticException e){
            System.err.println(errDivideByZero);
        } catch (EmptyStackException e){
            System.err.println(errUnderFlow);
            resetStack();
            push(firstNumber);
        }
    }

    /***
     * Power is a method that pops the two values from the stack. The
     * firstNumber raises the power of secondNumber. If the firstNumber
     * is negative, the two numbers are pushed to the top of the stack and
     * 'Negative' number is printed.  If the result is greater than 2147483647,
     * the value of 2147483647 is pushed to the top of the stack.
     */
    public void power(){
        try{
            firstNumber = pop();
            secondNumber = pop();
            if(firstNumber<0){
                System.out.println("Negative Number");
                push(firstNumber);
                push(secondNumber);
            } else {
                result = (long)Math.pow(secondNumber, firstNumber);
                rangeCheck(result);
            }
        } catch (EmptyStackException e){
            System.out.println(errUnderFlow);
        }
    }

    /***
     * legalRange is a helper method which returns a boolean value by checking if a result is within
     * Integer.MIN_VALUE and Integer.MAX_VALUE.
     * @param result is an argument to check mathematical arguments
     * @return boolean
     */
    public boolean legalRange (long result){
        if(result>2147483647L) {
            return false;
        } else return result >= -2147483648L;
    }

    /***
     * rand generates a random integer between -4B and 4B, if the
     * legalRange check fails 'Stack overflow' is printed. If the check passes,
     * the random value is pushed to the top of the stack.
     */
    public void rand(){
        long num = randomNum.rand();
        if(!legalRange(num)){
            System.out.println("Stack overflow");
        } else{
            items.push(num);
        }
    }

    /***
     * push method pushes the argument variable to the top of the stack.
     * @param number element pushed to the stack
     */
    public void push(long number){
        items.push(number);
    }

    /***
     * pop is used to pop an element from the stack.
     * The element is popped from the top of the stack and is removed from the same.
     * @return a long int from top of the stack.
     */
    public long pop(){
        return items.pop();
    }

    /***
     * peek retrieves the top element of the stack but does not get deleted.
     * @return long int
     */
    public long peek(){
       return items.peek();
    }

    /***
     * resetStack is a helper function that clears the stack
     */
    private void resetStack(){
        items.clear();
    }

    /***
     * equals is a method that peeks from the stack. If the stack is empty,
     * 'Stack is Empty' is printed.
     */
    public void equals(){
        try{
            System.out.println(peek());
        }catch (EmptyStackException e){
            System.out.println("Stack is Empty");
        }
    }

    /***
     * rangeCheck is a helper function that checks if a value is between
     * Integer.MIN_VALUE and Integer.MAX_VALUE. If the value is under -2147483648,
     * -2147483648 is pushed to the top of the stack.  If the value exceeds 2147483647,
     * the value of 2147483647 is pushed to the top of the stack. Otherwise the result is valid,
     * and is pushed to the top of the stack.
     * @param result long int
     */
    private void rangeCheck(long result){
        if(result>2147483647L) {
            push(2147483647L);
        } else push(Math.max(result, -2147483648L));
    }

    /***
     * isEmpty is a helper function to determine if the stack is empty.
     * @return boolean
     */
    private boolean isEmpty(){
        return items.isEmpty();
    }

    /***
     * display prints the values of the stack. If the stack is empty,
     * the Integer.MIN_VALUE is pushed to the stack and printed back to the user.
     */
    public void display(){

        if(isEmpty()){
            items.push((long)Integer.MIN_VALUE);
        }
        for(Long item: items){
            System.out.println(item);
        }
    }


}


