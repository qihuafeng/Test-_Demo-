package com.example.test.tiNet.suanfa;

import java.util.Stack;

/**
 * @Author ShineQi
 * @Date 2020/11/13 17:59
 */
public class NodeSort {

    public void sortArray(int[] array){
        for(int i = 0;i <array.length;i++){
            boolean isSort = true;
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    isSort = false;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(isSort){
                break;
            }
        }

    }


    public static void main(String[] args) {
        String[]  strings = new String[100];
        strings = new String[]{"1.1", "1.3.5","1.2", "1.2222","5.1", "3.1", "3.5", "3.3","1.2.8.1"};
        for(int i = 0;i<strings.length;i++){
            Integer.valueOf(strings[i].split(".")[i]);
        }

       /* for(int i = 0;i<strings[0].length();i++){
            char charAt = strings[0].charAt(i);
        }*/
        String[] strings1 = strings[0].split(",");
        Stack<String>  stack = new Stack<>();
        for(String s1 :strings1){
            stack.push(s1);
        }
        String[] strings2 = strings[1].split(",");
        Stack<String>  stack2 = new Stack<>();
        for(String s2 :strings2){
            stack.push(s2);
        }












    }
}
