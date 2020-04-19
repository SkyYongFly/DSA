package com.skylaker.string;

import org.junit.jupiter.api.Test;

/**
 * BM 算法测试
 * @author skylaker
 * @version V1.0 2020/4/19 13:03
 */
public class BMServiceTest {
    private BMService bmService = new BMService();

    @Test
    public void testBmBcr(){
        char[] z = "abgqacmqhwadva".toCharArray();
        char[] m = "mqhwas".toCharArray();;

        System.out.printf(bmService.bmBcr(z, m) + "");
    }

    @Test
    public void testStr(){
        System.out.printf(String.valueOf('b' - 'a'));
    }
}
