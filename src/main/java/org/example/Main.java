package org.example;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите стоку: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Разворот строки через StringBuilder");
        reversString(str, Main::revStringBuilder);
        System.out.println();
        System.out.println("Разворот строки через toCharArray");
        reversString(str, Main::revCharArray);
        System.out.println();
        System.out.println("Разворот строки через charAt");
        reversString(str, Main::revCharAt);
        System.out.println();
    }

    public static void reversString(String str, UnaryOperator<String> unaryOperator) {
        Long timeEnd[] = new Long[3];

        String strRev = "";
        long timeStart = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            strRev = unaryOperator.apply(str);
            if (i == 1000)
                timeEnd[0] = System.currentTimeMillis();
            else if (i == 10000)
                timeEnd[1] = System.currentTimeMillis();
            else if (i == 100000)
                timeEnd[2] = System.currentTimeMillis();
        }
        System.out.println("Начальная строка: " + str);
        System.out.println("Развернутая строка: " + strRev);
        System.out.print("Время:");
        for (Long t: timeEnd) {
            System.out.print(" " + (t - timeStart) + "мс");
        }
        System.out.println();
    }

    public static String revStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String revCharArray(String str) {
        char [] charArray = str.toCharArray();
        char c;

        for(int i = 0; i < charArray.length / 2; i++) {
            c = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = c;
        }
        return String.valueOf(charArray);
    }

    public static String revCharAt(String str) {
        int n = str.length();
        char [] charArray = new char[n];

        for(int i = 0; i < n; i++) {
            charArray[i] = str.charAt(n - 1 -i);
        }
        return String.valueOf(charArray);
    }
}