package com.sparta.udonunit.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    public CustomFormatter() {
    }

    @Override
    public String format(LogRecord record) {
        return  " [" + record.getLevel()
                + "] -> " + record.getMessage()
                + "\n";
    }
}