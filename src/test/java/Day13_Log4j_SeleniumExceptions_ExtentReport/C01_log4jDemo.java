package Day13_Log4j_SeleniumExceptions_ExtentReport;


import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C01_log4jDemo {
    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = LogManager.getLogger(C01_log4jDemo.class.getName());

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("Warn");
        logger.error("error");
        logger.fatal("fatal");




    }
}
