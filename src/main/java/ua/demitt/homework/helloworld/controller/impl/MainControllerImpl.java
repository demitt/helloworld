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
    protected ResourceBundle resourceBundle; //protected - для упрощения тестирования
    protected LocalTime time; //аналогично

    public MainControllerImpl(Display display) {
        LOG.info("Вызван конструктор");
        this.display = display;
    }

    @Override
    public void start() {
        LOG.info("Основной алгоритм запущен");

        this.resourceBundle = ResourceBundle.getBundle(Const.RESOURCE_BUNDLE_NAME, new UTF8Control());
        LOG.info("Получен ResourceBundle");

        this.time = getTime();
        LOG.info("Получено текущее время: " + time);

        Period period = Period.getPeriod(this.time);
        LOG.info("Текущее время = " + this.time.toString() + ", определен промежуток = " + period.toString());

        String greetingMessage = this.resourceBundle.getString( period.getGreetingPropName() );
        LOG.info("Получено сообщение \"" + greetingMessage + "\"");

        this.display.display(greetingMessage);
        LOG.info("Основной алгоритм завершен\n");
    }

    private LocalTime getTime() {
        return LocalTime.now();
    }

}
