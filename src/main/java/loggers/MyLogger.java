package loggers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    private static String LOGGER_NAME = "MyLogger";
    public static Logger logger = Logger.getLogger(LOGGER_NAME);
    public static FileHandler fileHandler;
    SimpleFormatter simpleFormatter = new SimpleFormatter();
    public MyLogger()
    {
        try {
            fileHandler = new FileHandler("C:\\Users\\lukasz.machnik\\work\\git_repo\\test\\paragon\\logs\\"+LOGGER_NAME+".txt");
//            logger.setLevel(Level.WARNING);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(simpleFormatter);
//            logger.info("Test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
