package com.verge.entity;

/**
 * Created by john on 31/10/2017.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int n = test.factorial(4);
        System.out.println(n);
    }

    public int factorial(int n) {
        if (n >= 1) {
            return factorial(n - 1);
        } else {
            return 1;
        }
    }
}
