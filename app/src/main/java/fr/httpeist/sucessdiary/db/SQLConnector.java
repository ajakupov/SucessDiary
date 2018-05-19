package fr.httpeist.sucessdiary.db;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

import fr.httpeist.sucessdiary.model.Day;
import fr.httpeist.sucessdiary.model.Goal;

/**
 * Created by eisti on 14/11/17.
 */

public class SQLConnector implements Connector {
    //array containing list of user's days
    private static ArrayList<Day> userDays;
    //array of daily goals
    private static ArrayList<Goal> dailyGoals;
    private DayHelper dayHelper;

    public SQLConnector (Context context) {
        userDays = new ArrayList<Day>();
        dailyGoals = new ArrayList<Goal>();
        this.dayHelper = new DayHelper(context);
    }

    @Override
    public ArrayList<Day> getUserDays() {
        userDays = this.dayHelper.getAllDays();
        return userDays;
    }

    @Override
    public ArrayList<Goal> getDailyGoals() {
        return null;
    }


    @Override
    public boolean insertDay (String number, String name, String date) {
        return this.dayHelper.insertDay(number, name, date);
    }

    @Override
    public boolean updateDay (String number, String name, String date) {
        return this.dayHelper.updateDay(number,name, date);
    }

    @Override
    public int deleteDay(String dayNumber) {
        return this.dayHelper.deleteDay(dayNumber);
    }
}
