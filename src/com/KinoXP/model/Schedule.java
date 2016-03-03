package com.KinoXP.model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hartyandi on 3/2/16.
 */
public class Schedule {

    private String title;
    private int id;
    private Map<String, Map<ArrayList<String>,String>>schedule;
    private String theater;

    public Schedule(String title, int id, Map<String, Map<ArrayList<String>, String>> schedule, String theater) {
        this.title = title;
        this.id = id;
        this.schedule = schedule;
        this.theater = theater;
    }
}
