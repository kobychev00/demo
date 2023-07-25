package com.example.demoblyat.example;

public class RunTimeExceptionExample {
    public static void main(String[] args) {
        int number = 2;
        if (number != 2) {
            throw new RuntimeException("Number is not 2");
        }
    }
}
