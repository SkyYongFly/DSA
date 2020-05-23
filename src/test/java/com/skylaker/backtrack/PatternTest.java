package com.skylaker.backtrack;

import com.skylaker.backtracking.Pattern;
import org.junit.jupiter.api.Test;

/**
 * @author skylaker
 * @version V1.0 2020/5/23 10:42
 */
public class PatternTest {
    @Test
    public void testPattern(){
        Pattern pattern = new Pattern();
        System.out.println(pattern.matchPattern("helloworld", "he*o?orl*"));
        System.out.println(pattern.matchPattern("helloworld", "he*o?orl"));
        System.out.println(pattern.matchPattern("helloworld", "he*o?orl*d"));
        System.out.println(pattern.matchPattern("helloworld", "he*o?*orl*"));
        System.out.println(pattern.matchPattern("helloworld", "he**o?orl*"));
        System.out.println(pattern.matchPattern("helloworld", "e*o?orl*"));
        System.out.println(pattern.matchPattern("helloworld", "he*o"));
        System.out.println(pattern.matchPattern("he", "he*o"));
    }
}
