SRPN Calculator

Use case documentation:
(Used to reverse engineer the program based on observed use cases)

1. Data is entered as a string
2. Numbers need to be detected in the string which includes negative numbers even when there a zero is needed in front of
the digit.
3. Pushes to the stack appear to include the results of a valid math operation. The input parameters are to get popped 
a valid operation.  The input parameters are to get popped after a valid operation. Random numbers are also added to the stack
If there is an operation error such as an out of range or divide by zero, the input numbers remain on the stack. If there
is an operation error such as an out of range or division by zero, the input numbers remain on the stack.
4. If the stack is empty:
a) if you press 'd' to display the stack, the Integer.MIN_VALUE is printed.
b) if you press '=' to calculate the result of an empty stack, "Stack is Empty" is printed.
