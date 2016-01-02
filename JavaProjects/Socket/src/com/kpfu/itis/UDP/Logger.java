package com.kpfu.itis.UDP;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public void logEvent(String event) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        try {
            FileWriter sw = new FileWriter("./log.txt", true);
            sw.write(sdf.format(date) + " " + event + "\n");
            sw.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}