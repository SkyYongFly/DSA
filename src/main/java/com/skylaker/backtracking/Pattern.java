package com.skylaker.backtracking;

/**
 * 回溯算法： 正则表达式匹配
 * @author skylaker
 * @version V1.0 2020/5/23 10:07
 */
public class Pattern {
     /**
      * 是否已经匹配标志
      */
    private boolean isMatched = false;


    /**
     * 正则匹配 （假设正则只有两个特殊匹配字符： * 0个或度多个 ； ？ 0个或1个）
     * @param str 目标字符串
     * @param pattern 正则表达式
     * @return {boolean} 匹配：true ; 不匹配 ： false
     */
    public boolean matchPattern(String str, String pattern) {
        if(null == str || "".equals(str) || null == pattern || "".equals(pattern)) {
            return false;
        }

        isMatched = false;

        // 从字符串和正则表达式的第一个字符开始匹配
        match(str.toCharArray(), 0, pattern.toCharArray(), 0);
        return isMatched;
    }

    /**
     * 正则匹配
     * @param str 目标字符串
     * @param strIndex 目标字符串字符数组下标索引
     * @param pattern 正则表达式
     * @param patternIndex 正则表达式字符数组下标索引
     */
    private void match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 如果已经匹配，结束
        if(isMatched) {
            return;
        }

        // 判断终止条件: 正则表达式已经到末尾
        if(patternIndex == pattern.length) {
            // 如果字符串也遍历到末尾，说明是匹配的
            if(strIndex == str.length) {
                isMatched = true;
            }
            return;
        }

        char patternChar = pattern[patternIndex];

        // 开始挨个字符匹配
        if('*' == patternChar ) {
            // 匹配任意个，即 0 个或正整数个
            // 那就先从0个开始匹配，即直接拿*的下个正则字符去匹配，匹配到就结束，匹配不上那么就返回，匹配 1 个的情况
            for(int k = 0; k <= str.length - strIndex; k++) {
                match(str, strIndex + k, pattern, patternIndex + 1);
            }
        }
        else if('?'== patternChar) {
            // 匹配0个或1个
            // 先匹配0个，即当前目标字符串指针位置不变，正则表达式字符往后移动一位
            match(str, strIndex, pattern, patternIndex + 1);
            // 前面匹配不上，再匹配1个，即目标字符串指针位置往后移动一位，正则表达式字符往后移动一位
            match(str, strIndex + 1, pattern, patternIndex + 1);
        }
        else {
            // 匹配正常字符
            if(strIndex < str.length && patternChar == str[strIndex]) {
                // 当前字符匹配那么开始下一个字符的匹配
                match(str, strIndex + 1, pattern, patternIndex + 1);
            }
        }
    }

}
