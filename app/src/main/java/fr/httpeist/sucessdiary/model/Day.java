package fr.httpeist.sucessdiary.model;

import java.util.Date;

/**
 * Created by eisti on 01/11/17.
 */

public class Day {
    private String number;
    private String name;
    private String date;

    public Day(String number, String name, String date) {
        this.number = number;
        this.name = name;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Day{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
