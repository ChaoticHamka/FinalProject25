package by.itacademy.radzetskaya.ria.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseLog {
    private static final Logger logger = LogManager.getLogger();

    protected static void info(String message) {
        logger.info(message);
    }

    protected static void debug(String message) {
        logger.debug(message);
    }

    protected static void error(String message) {
        logger.error(message);
    }

    protected static void warn(String message) {
        logger.warn(message);
    }

    protected static void trace(String message) {
        logger.trace(message);
    }

}
