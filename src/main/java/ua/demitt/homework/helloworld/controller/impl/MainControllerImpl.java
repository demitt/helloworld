package ua.demitt.homework.helloworld.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.demitt.homework.helloworld.controller.MainController;
import ua.demitt.homework.helloworld.model.Const;
import ua.demitt.homework.helloworld.model.Period;
import ua.demitt.homework.helloworld.util.UTF8Control;
import ua.demitt.homework.helloworld.view.Display;

import java.time.LocalTime;
import java.util.ResourceBundle;

public class MainControllerImpl implements MainController {

    private static final Logger LOG = LoggerFactory.getLogger("MainController");

    private Display display;
    private LocalTime time;

    public MainControllerImpl(Display display) {
        LOG.debug("Constructor");
        this.display = display;
    }

    @Override
    public void start() {
        LOG.debug("start()");

        ResourceBundle resourceBundle = ResourceBundle.getBundle(Const.RESOURCE_BUNDLE_NAME, new UTF8Control());

        this.time = getTime();
        Period period = Period.getPeriod(this.time);

        LOG.debug("Текущее время = " + this.time.toString() + ", был определен период = " + period.toString());

        String greetingMessage = resourceBundle.getString( period.getGreetingPropName() );
        this.display.display(greetingMessage);
    }

    private LocalTime getTime() {
        return LocalTime.now();
    }

}
