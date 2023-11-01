package com.example.banking.quiz;

// Solution: b h hn x
public class Q4 {
    static class Building extends Object {
        Building() {
            // super(); // implicit
            System.out.print("b ");
        }
        Building(String name) {
            this();
            System.out.print("bn " + name);
        }
    }
    static class House extends Building {
        House() {
            // super(); // implicit
            System.out.print("h ");
        }
        House(String name) {
            this();
            System.out.print("hn " + name);
        }
    }
    public static void main(String[] args) {
        new House("x ");
    }
}
