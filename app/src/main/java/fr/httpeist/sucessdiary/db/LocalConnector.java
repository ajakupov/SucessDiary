package fr.httpeist.sucessdiary.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.httpeist.sucessdiary.Status;
import fr.httpeist.sucessdiary.model.Day;
import fr.httpeist.sucessdiary.model.Goal;

/**
 * Created by eisti on 01/11/17.
 *
 * Class initializing List of days and associated goals
 * From DAO it is possible to get all the 'local db' data in the form of array lists
 */

public class LocalConnector implements Connector{
    //eager instantiation
    private static LocalConnector singleInstance = new LocalConnector();
    //array containing list of user's days
    private static ArrayList<Day> userDays;
    //array of daily goals
    private static ArrayList<Goal> dailyGoals;

    //get singleton instance
    public static LocalConnector getSingleInstance () {
        return singleInstance;
    }

    private LocalConnector () {
        //instantiating arrays
        userDays = new ArrayList<Day>();
        dailyGoals  = new ArrayList<Goal>();


        //creating sample data
        //list of user days
        for (int i =0; i< 5; i++) {
            //Date needed to initialize Day object
            //Current date
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, i);
            date = c.getTime();
            Day day = new Day("" + i, "Day " + i, date.toString());
            userDays.add(day);
        }

        //list of dayli goals
        int dayNumber = 0;
        for (int i = 0; i < 10; i++) {
            Goal goal= new Goal("Sample description for day " + dayNumber, Status.DONE,
                    "" + dayNumber);
            if (i%2 != 0) {
                dayNumber += 1;
            }
            dailyGoals.add(goal);
        }
    }

    public ArrayList<Day> getUserDays () {
        return this.userDays;
    }

    public ArrayList<Goal> getDailyGoals () {
        return this.dailyGoals;
    }

    @Override
    public boolean insertDay(String number, String name, String date) {
        Day day = new Day(number, name, date);
        userDays.add(day);
        return true;
    }

    @Override
    public boolean updateDay(String number, String name, String date) {

        for (Day temp: userDays) {
            if (temp.getNumber().equals(number)) {
                temp.setDate(date);
                temp.setName(name);
            }
        }

        return true;
    }

    @Override
    public int deleteDay(String dayNumber) {
        Day day = null;

        for (Day temp : userDays) {
            if (temp.getNumber().equals(dayNumber)) {
                day = temp;
            }
        }

        userDays.remove(day);

        return 0;
    }
}
