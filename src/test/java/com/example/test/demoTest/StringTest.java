package com.example.test.demoTest;

import org.junit.jupiter.api.Test;

public class StringTest {

    public static void main(String[] args) {
        String item = "materials,services,things ";
        System.out.println(item.equals(item.trim()));
        String[] items=item.split(",");

        System.out.println(item);

    }
}
