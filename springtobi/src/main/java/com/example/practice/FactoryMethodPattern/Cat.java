package com.example.practice.FactoryMethodPattern;

public class Cat extends Animal {
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
