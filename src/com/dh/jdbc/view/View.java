package com.dh.jdbc.view;
/**
 * ������ʱ����ҳ����������̨��ͼ���ò���������ʱ��д�� = =��
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
