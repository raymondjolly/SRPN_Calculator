package com.rvj;


/***
 * RandomNum Class object to generate long integers between 4B and -4B. The range is to
 * purposely generate integers that will fall outside of the range of 2147483647L and
 * -2147483648L to throw a 'Stack overflow' message.
 */
public class RandomNum {

    //this helped me: https://www.baeldung.com/java-generate-random-long-float-integer-double
    public long rand() {
        long leftLimit = 2500000000L;
        long rightLimit = -2500000001L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

    }
}
