package com.example.test.tinet.stringTest;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author ShineQi
 * @Date 2020/11/19 15:34
 */
public class StringAPI {

//    String类里面常用的20个方法
//            和长度有关的方法
//    返回类型      方法名               作用
//    int        length()        得到一个字符串的字符个数（一个中文是一个字符，一个英文是一个字符，一个转义字符是一个字符）
//
//    和数组有关的方法
//    返回类型        方法名             作用
//    byte[]        getBytes()       将一个字符串转换成字节数组
//    char[]        toCharArray()    将一个字符串转换成字符数组
//    String[]      split(String)    将一个字符串按照指定内容劈开
//
//    和判断有关的方法
//    返回类型        方法名                         作用
//    boolean       equals(String)                判断两个字符串的内容是否一模一样
//    boolean       equalsIgnoreCase(String)      忽略大小写的比较两个字符串的内容是否一模一样
//    boolean       contains(String)              判断一个字符串里面是否包含指定的内容
//    boolean       startsWith(String)            判断一个字符串是否以指定的内容开头
//    boolean       endsWith(String)              判断一个字符串是否以指定的内容结尾
//
//    和改变内容有关的方法
//    和改变内容有关的方法，都不会直接操作原本的字符串
//    而是将符合条件的字符串返回给我们，所以注意接收
//    返回类型        方法名                         作用
//    String        toUpperCase()                 将一个字符串全部转换成大写
//    String        toLowerCase()                 将一个字符串全部转换成小写
//    String        replace(String,String)        将某个内容全部替换成指定内容
//    String        replaceAll(String,String)     将某个内容全部替换成指定内容，支持正则
//    String        repalceFirst(String,String)   将第一次出现的某个内容替换成指定的内容
//    String        substring(int)                从指定下标开始一直截取到字符串的最后
//    String        substring(int,int)            从下标x截取到下标y-1对应的元素
//    String        trim()                        去除一个字符串的前后空格
//
//    和位置有关的方法
//    返回类型        方法名                     作用
//    char          charAt(int)               得到指定下标位置对应的字符
//    int           indexOf(String)           得到指定内容第一次出现的下标
//    int           lastIndexOf(String)       得到指定内容最后一次出现的下标
    public static void main(String[] args) {
        String name = "Hello World";
        System.out.println(name.length());
        char[] chars = name.toCharArray();
        System.out.println("============toCharArray方法==============");
        for(char c:chars){
            System.out.println(c);
        }
        boolean contains = name.contains("Hello");
        System.out.println(contains);

        String zimu="abcdefghigkz";
        String replace = zimu.replace("fgh", "FGH");
        System.out.println(replace);

        String substring = zimu.substring(1);
        System.out.println(substring);
        String substring1 = zimu.substring(1, 3);
        System.out.println(substring1);

        String kongge = " nihao       ";
        System.out.println(kongge.length());
        System.out.println(kongge.trim() + kongge.trim().length());

        System.out.println("=================和位置有关的方法===============");
        char charAt = zimu.charAt(2);
        System.out.println(charAt);

        int indexof = zimu.indexOf("e");
        System.out.println(indexof);

//        CollectionUtils.isEmpty();
//        CollectionUtils.isEmpty();
//        page分页demo
//        StringUtils
        String s = null;
        String s1  ="";
        System.out.println(StringUtils.isNotBlank(s));
        System.out.println(StringUtils.isNotBlank(s1));
    }
}
