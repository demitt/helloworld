package ua.demitt.homework.helloworld.controller.impl;

import org.junit.Test;
import ua.demitt.homework.helloworld.controller.MainController;
import ua.demitt.homework.helloworld.view.Display;
import ua.demitt.homework.helloworld.view.impl.DisplayImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainControllerImplTest {

    @Test
    public void testStart_Fields() throws Exception {
        //Given
        Display display = new DisplayImpl();
        MainControllerImpl controller = new MainControllerImpl(display);

        //When
        controller.start();

        //Then
        assertNotNull("ResourceBundle не был присвоен", controller.resourceBundle);
        assertNotNull("Время не было присвоено", controller.time);
    }

    @Test
    public void testStart_DisplayMethodInvoking() throws Exception {
        //Given
        Display display = mock(DisplayImpl.class);
        MainController controller = new MainControllerImpl(display);

        //When
        controller.start();

        //Then
        verify(display, times(1)).display(anyString());
    }
}