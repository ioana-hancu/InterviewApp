package com.example.demo.InterviewTest;

public class TestNotFoundException extends RuntimeException{
    TestNotFoundException(Long id){
        super("Could not find test " + id);
    }
}
