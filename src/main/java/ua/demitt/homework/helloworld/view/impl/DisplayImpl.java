package ua.demitt.homework.helloworld.view.impl;

import ua.demitt.homework.helloworld.view.Display;

public class DisplayImpl implements Display {

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
