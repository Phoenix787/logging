package logging;

import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerLoggingTest {

    @Test
    public void getIn() {
        ControllerLogging controllerLogging = new ControllerLogging();
        controllerLogging.getIn();
    }
}