package com.rvj;


/***
 * RandomNum Class object to generate long integers between 3B and -3B. The range is to
 * purposely generate integers that will fall outside of the range of Integer.MAX_VALUE (2147483647L) and
 * Integer.MAX_VALUE (-2147483648L) to throw a 'Stack overflow' message.
 */
public class RandomNum {

    //This is a good source to help understand random number generation between a
    //specific range https://www.baeldung.com/java-generate-random-long-float-integer-double
    public long rand() {
        long minLimit = -3000000000L;
        long maxLimit = 3000000000L;
        return minLimit + (long) (Math.random() * (maxLimit - minLimit));

    }
}
