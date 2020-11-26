package com.example.test.LeetCode.String;

/**
 * @Author ShineQi
 * @Date 2020/11/25 11:43
 */
public class 最长回文子串_5 {

//    输入: "babad"
//    输出: "bab"
//    注意: "aba" 也是一个有效答案。
public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
        return s;
    }

    int maxLen = 1;
    int begin = 0;
    // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
    char[] charArray = s.toCharArray();

    // 枚举所有长度大于 1 的子串 charArray[i..j]
    for (int i = 0; i < len - 1; i++) {
        for (int j = i + 1; j < len; j++) {
            if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                maxLen = j - i + 1;
                begin = i;
            }
        }
    }
    return s.substring(begin, begin + maxLen);
}

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isHuiWen(char[] chars){
        int left = 0;
        int right = chars.length;
        while(left<right){
            if(chars[left] != chars[right]){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    public static void test1(Integer i){
        i = i+1;
        System.out.println(i);
    }

    public static void main(String[] args) {
        String ss = "Hello World";
        Integer ls = 2;
        test1(ls);
        System.out.println(ls);
    }




}
