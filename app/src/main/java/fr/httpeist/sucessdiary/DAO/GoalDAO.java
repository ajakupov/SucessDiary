package fr.httpeist.sucessdiary.DAO;

import java.util.ArrayList;

import fr.httpeist.sucessdiary.db.Connector;
import fr.httpeist.sucessdiary.model.Day;
import fr.httpeist.sucessdiary.model.Goal;

/**
 * Created by eisti on 07/11/17.
 */

public class GoalDAO {
    private Connector connector;

    //get list of daily goals by providing only day number
    public ArrayList<Goal> getDailyGoals(String dayNumber) {

        ArrayList<Goal> output = new ArrayList<Goal>();

        for (Goal goal: this.connector.getDailyGoals()) {
            if (goal.getDayNumber() == dayNumber) {
                output.add(goal);
            }
        }
        return  output;
    }

    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }
}
