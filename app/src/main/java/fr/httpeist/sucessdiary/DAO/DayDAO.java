package fr.httpeist.sucessdiary.DAO;

import android.util.Log;

import java.util.ArrayList;

import fr.httpeist.sucessdiary.db.Connector;
import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 01/11/17.
 *
 * Class realizing CRUD operations over Database
 */

public class DayDAO {
    private Connector connector;

    public ArrayList <Day> getDaysList () {
        return this.connector.getUserDays();
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public boolean addDay(Day day) {
        return this.connector.insertDay(day.getNumber(), day.getName(), day.getDate());
    }

    public int deleteDay(String dayNumber) {
        return this.connector.deleteDay(dayNumber);
    }

    public Day getDayByNumber(String dayNumber) {
        Day output = null;

        for (Day day: this.connector.getUserDays()) {
            if (day.getNumber() == dayNumber) {
                output = day;
            }
        }

        return output;
    }

    public Day getDayByName (String name) {
        Day output = null;
        for (Day day: this.connector.getUserDays()) {
            if (day.getName().equals(name)) {
                output = day;
            }
        }

        return output;
    }

    public int removeDay(Day day) {
        return connector.deleteDay(day.getNumber());
    }

}
