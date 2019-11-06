package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {
    public static void main(String[] args) {
        print16lines();
        if(1 == 1) {
            System.out.println("kolme sisäkkäistä iffiä");
        }
        for(int i = 0; i < 1; i++) {
            System.out.println("kaksi sisäkkäistä foria");
        }
    }

    public static void print16lines() {
        System.out.println("one line");
    }
}
