package com.example.test_task.service;

public class Math2 {
    public int add (int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}

class Provider {
    public static void get(int a, int b, Math2 m) {
        m.add(a, a);
        m.add(b, b);
    }
}
