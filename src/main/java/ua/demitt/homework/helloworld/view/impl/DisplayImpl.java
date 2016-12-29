package ua.demitt.homework.helloworld.view.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.demitt.homework.helloworld.view.Display;

public class DisplayImpl implements Display {

    private static final Logger LOG = LoggerFactory.getLogger("Display");

    public DisplayImpl() {
        LOG.info("Вызван конструктор");
    }

    @Override
    public void display(String message) {
        LOG.info("Отображаем сообщение \"" + message + "\"");
        System.out.println(message);
    }
}
