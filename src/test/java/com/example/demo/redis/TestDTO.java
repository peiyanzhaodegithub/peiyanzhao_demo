package com.example.demo.redis;

public class TestDTO {



    private String test;

    private String test1;

    private String test2;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public TestDTO(String test, String test1, String test2) {
        this.test = test;
        this.test1 = test1;
        this.test2 = test2;
    }

    public TestDTO() {
    }
}
