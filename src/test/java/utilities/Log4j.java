package utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

    private static Logger log = LogManager.getLogger(Log4j.class.getName());

    public static void info(String mesaage) {
        log.info(mesaage);

    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void trace(String message) {
        log.trace(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }

}
