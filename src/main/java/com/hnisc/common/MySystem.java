package com.hnisc.common;

import java.util.Scanner;

public class MySystem {
    public static void pause(){
        Scanner sc=new Scanner(System.in);
        System.out.println("任意输入一个字符，按回车继续...");
        sc.nextByte();
    }
}
