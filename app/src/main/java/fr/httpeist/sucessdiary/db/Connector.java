package fr.httpeist.sucessdiary.db;

import java.util.ArrayList;

import fr.httpeist.sucessdiary.model.Day;
import fr.httpeist.sucessdiary.model.Goal;

/**
 * Created by eisti on 07/11/17.
 */

public interface Connector {
    public ArrayList<Day> getUserDays ();

    public ArrayList<Goal> getDailyGoals ();

    public boolean insertDay (String number, String name, String date);

    public boolean updateDay (String number, String name, String date);

    public int deleteDay(String dayNumber);
}
