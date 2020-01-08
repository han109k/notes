package com.example.notes.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String getCurrentTimeStamp() {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yyyy"); // must be lowercase for api 23-
            String currentDateTime = dateFormat.format(new Date());

            return currentDateTime;
        } catch (Exception e){
            return null;
        }
    }
}
