package com.sparta.udonunit.logging;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultHandler {
    private static final Logger PRINTER = Logger.getLogger("Results Printer");
    private static final Logger FILE = Logger.getLogger("Search Saver");

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void init() throws IOException {
        PRINTER.setUseParentHandlers(false);
        PRINTER.addHandler(getConsoleHandler());
        PRINTER.setLevel(Level.CONFIG);

        FILE.setUseParentHandlers(false);
        FILE.addHandler(getFileHandler());
        FILE.setLevel(Level.ALL);
    }


    private static ConsoleHandler getConsoleHandler(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.CONFIG);
        consoleHandler.setFormatter(new SearchFormatter());

        return consoleHandler;
    }

    private static FileHandler getFileHandler() throws IOException {
        String currentDay = LocalDate.now().toString();
        String currentHour = String.valueOf(LocalTime.now().getHour());
        String currentMin = String.valueOf(LocalTime.now().getMinute());
        String currentSec = String.valueOf(LocalTime.now().getSecond());
        String currentTime = currentHour + "h" + currentMin + "m" + currentSec;
        FileHandler fileHandler = new FileHandler("src/main/resources/results-"+ currentDay + " - " + currentTime + ".txt");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new SearchFormatter());

        return fileHandler;
    }

    public static void endOfSearch()
    {
        PRINTER.info("-------------------------------------");
        saveToFile("-------------------------------------");
    }

    public static void printSearchValue(String searchTerm,String value){
        PRINTER.info(ANSI_BLUE + searchTerm + ANSI_YELLOW + value + ANSI_RESET);

        saveToFile(searchTerm  + value);
    }

    public static void printCorrectResult(String result) {
        PRINTER.info(ANSI_GREEN + result + ANSI_RESET);

        saveToFile(result);
    }

    public static void printInvalidResult(String result) {
        PRINTER.info(ANSI_RED + result + ANSI_RESET);

        saveToFile(result);
    }

    public static void saveToFile(String result) {
        FILE.config(result);
    }
}
