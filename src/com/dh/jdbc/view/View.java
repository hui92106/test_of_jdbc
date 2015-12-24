package com.dh.jdbc.view;
/**
 * 由于暂时做网页开发，控制台视图层用不到，固暂时不写了 = =！
 */
import java.util.Scanner;

public class View {
    private static final String CONTEXT= "12342234"; 
    public static void main(String[] args) {
       System.out.println(CONTEXT);
       Scanner scan = new Scanner(System.in);
       while(true){
           System.out.println("aaa: " + scan.next().toString());
       }
    }
}
