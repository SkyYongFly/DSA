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
        char[] z = "aaaaaaaaaaaaaaa".toCharArray();
        char[] m = "baaaa".toCharArray();

//        System.out.println(bmService.bmBcr(z, m) + "");
        System.out.println(bmService.bm(z, m) + "");
    }

    @Test
    public void testStr(){
        System.out.printf(String.valueOf('b' - 'a'));
    }

    @Test
    public void testGenerateGsSuffix(){
        char[] m = "abcabc".toCharArray();
        int[] suffix = new int[m.length];
        boolean[] prefix = new boolean[m.length];

        bmService.generateGsSuffix(m, suffix, prefix);

        for(int i = 0; i < suffix.length; i++){
            System.out.printf(suffix[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < prefix.length; i++){
            System.out.printf(prefix[i] + " ");
        }
    }
}
