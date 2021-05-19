package com.example.test.tiNet.yewu;

import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @Author ShineQi
 * @Date 2021/1/4 10:46
 */
public class Test1 {
    static String getImageBinary(String file) {
        File f = new File(file);
        try {
//            ByteArrayOutputStream
            BufferedImage bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return new String(Base64Utils.encode(bytes));
        } catch (IOException e) {

        }
        return null;
    }

    public static void main(String[] args) {
//        String i = "C:/Users/Lenovo/Desktop/1.jpg";
//        String j = "C:/Users/Lenovo/Desktop/2.jpg";
//        String res_1 = getImageBinary(i);
//        String res_2 = getImageBinary(j);
//        System.out.println(res_1);
//        System.out.println("-------------------------------------------------");
//        System.out.println(res_2);
        String s1 = "statistic_agent_workload_day_______";
        String s2 = "cdr_ob_customer_6000001_202012";
        String s3 = "cdr_ob_customer_______________";
        System.out.println(s1.length());
        System.out.println(s2.length());
        System.out.println(s3.length());
    }
}
