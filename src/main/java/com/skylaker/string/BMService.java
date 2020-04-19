package com.skylaker.string;

/**
 * BM 算法实现
 * @author skylaker
 * @version V1.0 2020/4/19 12:33
 */
public class BMService {
    /**
     * 根据坏字符规则查找模式串在主串中的匹配位置（忽略计算移动距离负数情况）
     * @param z 主串
     * @param m 模式串
     * @return 匹配情况：模式串开头字母在主串对齐位置；不匹配：-1
     */
    public int bmBcr(char[] z, char[] m){
        if(null == z || null == m || z.length < m.length){
            return -1;
        }

        // 根据模式串构建哈希表
        int[] hashTable = generateHashTable(m);

        // 匹配模式串和主串
        // 模式串可移动范围在主串 0 到 z.length - m.length 位置
        for(int i = 0; i < z.length - m.length;){
            int j ;
            // 模式串从后往前匹配
            for(j = m.length - 1; j >= 0; j--){
                if(m[j] != z[i + j]){
                    // 遇到坏字符
                    break;
                }
            }

            if(j < 0){
                // j 小于0，说明模式串整个和主串对应位置匹配，因为最后匹配技术，j 还往前移动一位为 -1
                return i;
            } else {
                // 说明没有匹配成功，那么坏字符在主串位置就是 i+j
                /// 移动位置
                int length = j - hashTable[z[i+j] - 'a'];
                i = i + length;
            }
        }

        // 如果循环结束还没中间返回说明模式串在主串没有匹配的
        return -1;
    }

    /**
     * 根据模式串构建字符集哈希表 （这里假设只有a-z 26个字母，以0到25排序）
     * @param m 模式串
     * @return 字符集哈希表
     */
    private int[] generateHashTable(char[] m) {
        int[] hashTable = new int[26];

        // 先初始化, 即默认字符不存在位置值记做 -1
        for(int i = 0; i < 26; i++){
            hashTable[i] = -1;
        }

        // 再将模式串中的字符最大索引位置填充到哈希表
        for(int i = 0; i < m.length; i++){
            hashTable[m[i] - 'a'] = i;
        }

        return hashTable;
    }

}
