package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerLogging {
    private static final Logger logger = LogManager.getLogger(ControllerLogging.class.getName());

    @RequestMapping(value = "/in", method = RequestMethod.GET)
    public @ResponseBody  String getIn() {
        logger.info("This is info message");
        logger.debug("This is debug message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.fatal("This is fatal message");
        return "Проверка";
    }
}
