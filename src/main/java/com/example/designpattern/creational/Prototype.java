package com.example.designpattern.creational;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * costly creation of object + a similar object already existing
 */
@Data
public class Prototype implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        // assume prototype is created costly (like from a database)
        Prototype prototype = new Prototype();
        prototype.loadData();
        // copy and then modify it according to our needs
        Prototype anotherPrototype = (Prototype) prototype.clone();
        anotherPrototype.getEmpList().set(0, "100");
        System.out.println(prototype.getEmpList());
        System.out.println(anotherPrototype.getEmpList());
    }

    private List<String> empList;

    public Prototype() {
        empList = new ArrayList<>();
    }

    public Prototype(List<String> list) {
        this.empList = list;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Prototype(temp);
    }

    public void loadData() {
        empList.add("1");
        empList.add("2");
        empList.add("3");
        empList.add("4");
    }
}
