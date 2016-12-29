package ua.demitt.homework.helloworld;

import ua.demitt.homework.helloworld.controller.MainController;
import ua.demitt.homework.helloworld.controller.impl.MainControllerImpl;
import ua.demitt.homework.helloworld.view.Display;
import ua.demitt.homework.helloworld.view.impl.DisplayImpl;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Display display = new DisplayImpl();
        MainController controller = new MainControllerImpl(display);
        controller.start();
    }
}
