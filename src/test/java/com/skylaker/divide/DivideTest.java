package com.skylaker.divide;

import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/5/20 20:55
 */
public class DivideTest {
    @Test
    public void testDivide(){
        int[] arr = {15, 5, 3, 20, 25, 8, 30, 1, 5, 40};

        Divide divide = new Divide();
        System.out.println(divide.count(arr));
    }
}
