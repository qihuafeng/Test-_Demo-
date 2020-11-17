package com.example.test.suanfa;

/**
 * @Author ShineQi
 * @Date 2020/11/2 15:28
 */
public class Demo {
    public void keys(){
        int index = 1;
        for(int i = 0;i<10;i++){
            String s =   String.valueOf(index++);
            System.out.println(s);
        }

    }
    public static void main(String[] args) {
       /* Demo demo = new Demo();
        demo.keys();*/
        String s = "";
        System.out.println(s.length());
//        System.out.println(s.hashCode());
        String s1 = null;
        System.out.println(s.equals(s1));
        System.out.println(s==s1);

    }
}
