package com.sparta.udonunit.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    private final String classname;

    public CustomFormatter(String className) {
        this.classname = className;
    }

    @Override
    public String format(LogRecord record) {
        return classname
                + " [" + record.getLevel()
                + "] -> " + record.getMessage()
                + "\n";
    }
}