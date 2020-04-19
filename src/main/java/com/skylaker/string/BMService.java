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

    /**
     * 预处理好后缀规则下 模式串的所有后缀在模式串的匹配情况
     * @param m 模式串
     * @param suffix  记录后缀子串在模式串的重复位置（下标代表后缀子串长度，值代表重复字符内容在模式串位置）
     * @param prefix  记录后缀子串是否匹配模式串前缀子串（下标代表后缀子串长度，值：true 匹配； false 不匹配）
     */
    public void generateGsSuffix(char[] m, int[] suffix, boolean[] prefix){
        int length = m.length;

        // 先初始化两个数组
        for(int i = 0; i < suffix.length; i++){
            suffix[i] = -1;
            prefix[i] = false;
        }

        // 遍历所有可能前半部分字符子串，即范围在 0 到 length-2, 即 m[0,i] 的可取值范围 m[0,0] 到 m[0, length-2]
        for(int i = 0; i < length - 1; i++){
            // 记录当前子串的末尾位置
            int j = i;

            // 记录公共后缀子串长度
            int k = 0;

            // 将当前子串依次和 b[0, length-1] 匹配公共后缀子串, 即当前子串末尾依次往前
            while (j >= 0 && m[j] == m[length-1-k]){
                // 上一个字符匹配情况下再往前比较
                j--;
                k++;

                // 记录公共后缀子串在模式串中匹配的位置
                // 如果有多个匹配，后面外层子串循环的时候这里会覆盖，即保存最靠后的匹配位置
                suffix[k]=j+1;
            }

            // 如果匹配的位置是第一个字符，说明公共后缀也是模式串的前缀子串
            if(-1 == j){
                prefix[k] = true;
            }
        }
    }

    /**
     * bm 算法实现（总和考虑坏字符及好后缀规则）
     * @param z 主串
     * @param m 模式串
     * @return 匹配情况：模式串开头字母在主串对齐位置；不匹配：-1
     */
    public int bm(char[] z, char[] m){
        if(null == z || null == m || z.length < m.length){
            return -1;
        }

        // 根据模式串构建哈希表
        int[] hashTable = generateHashTable(m);

        // 构建好后缀的后缀子串匹配数组
        int[] suffix = new int[m.length];
        boolean[] prefix = new boolean[m.length];
        generateGsSuffix(m, suffix, prefix);

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
                /// 计算按照坏字符规则移动位置
                int bcrLength = j - hashTable[z[i+j] - 'a'];

                /// 计算按照好后缀规则移动距离
                int gcLength = 0;
                if(j != m.length - 1){
                    // 如果模式串末尾子串就不匹配的话那么也就谈不上好后缀了
                    gcLength = getGsLength(j, m.length, suffix, prefix);
                }

                /// 模式串移动两个规则计算出来的最大距离
                i = i + Math.max(bcrLength, gcLength);
            }
        }

        // 如果循环结束还没中间返回说明模式串在主串没有匹配的
        return -1;
    }

    /**
     * 计算按照好后缀规则模式串需要移动的距离
     * @param j 坏字符位置
     * @param length  模式串长度
     * @param suffix  记录后缀子串在模式串的重复位置（下标代表后缀子串长度，值代表重复字符内容在模式串位置）
     * @param prefix  记录后缀子串是否匹配模式串前缀子串（下标代表后缀子串长度，值：true 匹配； false 不匹配）
     */
    private int getGsLength(int j, int length, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = length - 1 - j;

        if(suffix[k] != -1){
            // 说明好后缀在模式串有匹配
            return j - suffix[k] + 1;
        } else {
            // 好后缀不存在匹配的，那么就查找好后缀的后缀子串是否跟模式串前缀子串匹配
            for(int r = j + 2; r <= length - 1; r++){
                if(prefix[length-r] == true){
                    return r;
                }
            }
        }
        return length;
    }

}
