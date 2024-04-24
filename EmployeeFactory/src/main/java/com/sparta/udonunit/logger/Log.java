package com.sparta.udonunit.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static final Logger CONSOLE_LOGGER = Logger.getLogger("ConsoleLogger");
    private static final Logger FILE_LOGGER = Logger.getLogger("FileLogger");

    // ANSI escape code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void init(String className) throws IOException {
        CONSOLE_LOGGER.setUseParentHandlers(false);
        CONSOLE_LOGGER.addHandler(getConsoleHandler(className));
        CONSOLE_LOGGER.setLevel(Level.CONFIG);

        FILE_LOGGER.setUseParentHandlers(false);
        FILE_LOGGER.addHandler(getFileHandler(className));
        FILE_LOGGER.setLevel(Level.ALL);
    }

    private static ConsoleHandler getConsoleHandler(String className){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.CONFIG);
        consoleHandler.setFormatter(new CustomFormatter(className));

        return consoleHandler;
    }

    private static FileHandler getFileHandler(String className) throws IOException {
        FileHandler fileHandler = new FileHandler("src/main/resources/logfile.log");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new CustomFormatter(className));

        return fileHandler;
    }


    public static void severe(String logging) {
        CONSOLE_LOGGER.severe(ANSI_RED + logging + ANSI_RESET);
        FILE_LOGGER.severe(logging);
    }

    public static void warning(String logging) {
        CONSOLE_LOGGER.warning(ANSI_YELLOW + logging + ANSI_RESET);
        FILE_LOGGER.warning(logging);
    }

    public static void info(String logging) {
        CONSOLE_LOGGER.info(ANSI_GREEN + logging + ANSI_RESET);
        FILE_LOGGER.info(logging);
    }

    public static void config(String logging) {
        CONSOLE_LOGGER.config(ANSI_BLUE + logging + ANSI_RESET);
        FILE_LOGGER.config(logging);
    }

    public static void fine(String logging) {
        FILE_LOGGER.config(logging);
    }



}
