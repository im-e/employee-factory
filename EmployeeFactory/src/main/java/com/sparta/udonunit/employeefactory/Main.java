package com.sparta.udonunit.employeefactory;

import com.sparta.udonunit.logger.Log;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Log.init(Main.class.getSimpleName());
        Log.fine("This is a fine log");
        Log.info("This is some info");
        Log.config("This is a config log");
        Log.warning("This is a warning log");
        Log.severe("This is a severe warning log");


        //System.out.println(Arrays.asList(EmployeeFactory.getEmployees(20)));


    }
}
