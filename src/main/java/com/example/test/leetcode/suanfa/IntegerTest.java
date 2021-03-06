package com.example.test.leetcode.suanfa;

/**
 * @Author ShineQi
 * @Date 2020/8/24 10:00
 */
public class IntegerTest {

    //快速排序
    public static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                {
                    j--;
                }
                if(i < j) {
                    s[i++] = s[j];
                }

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                {
                    i++;
                }
                if(i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }



    }
    public static  void  main(String args[]){
        System.out.println((3+4)/2);
        System.out.println((4+4)/2);
        System.out.println((int)3.6);
        int[] ints ={5,6,1,4,3,8,9,10};
        quick_sort(ints,0,ints.length-1);
        for(int i:ints){
            System.out.println(i);
        }




    }
}
