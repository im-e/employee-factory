package com.sparta.udonunit.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static final Logger CONSOLE_LOGGER = Logger.getLogger("ConsoleLogger");
    private static final Logger FILE_LOGGER = Logger.getLogger("FileLogger");

    // ANSI escape code
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void init() throws IOException {
        CONSOLE_LOGGER.setUseParentHandlers(false);
        CONSOLE_LOGGER.addHandler(getConsoleHandler());
        CONSOLE_LOGGER.setLevel(Level.INFO);

        FILE_LOGGER.setUseParentHandlers(false);
        FILE_LOGGER.addHandler(getFileHandler());
        FILE_LOGGER.setLevel(Level.ALL);
    }

    private static ConsoleHandler getConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.CONFIG);
        consoleHandler.setFormatter(new LogFormatter());

        return consoleHandler;
    }

    private static FileHandler getFileHandler() throws IOException {
        FileHandler fileHandler = new FileHandler("src/main/resources/logfile.log");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new LogFormatter());

        return fileHandler;
    }

    public static void warning(String logging, String currentClassName) {
        CONSOLE_LOGGER.warning(ANSI_YELLOW + "(" + currentClassName + ") " + logging + ANSI_RESET);
        FILE_LOGGER.warning(logging);
    }

    public static void info(String logging, String currentClassName) {
        CONSOLE_LOGGER.info(ANSI_GREEN + "(" + currentClassName + ") " + logging + ANSI_RESET);
        FILE_LOGGER.info(logging);
    }

    public static void config(String logging, String currentClassName) {
        CONSOLE_LOGGER.config(ANSI_BLUE + "(" + currentClassName + ") " + logging + ANSI_RESET);
        FILE_LOGGER.config(logging);
    }


}
