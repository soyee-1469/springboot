package com.example.tobi.springtobi.ch03.ex_3_5.calc.template_v5;

public interface LineCallback<T> {
    T doSomethingWithLine(String line,T value);
}
