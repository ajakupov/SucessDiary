package fr.httpeist.sucessdiary;

import org.junit.Test;

import fr.httpeist.sucessdiary.db.LocalConnector;

import static org.junit.Assert.*;

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatabaseUnitTest {
    @Test
    public void dataDaysLengthLocal_isCorrect() throws Exception {
        LocalConnector testConnector = LocalConnector.getSingleInstance();
        assertEquals(testConnector.getUserDays().size(), 5);
    }
    @Test
    public void dataGoalsLengthLocal_isCorrect() throws Exception {
        LocalConnector testConnector = LocalConnector.getSingleInstance();
        assertEquals(testConnector.getDailyGoals().size(), 10);
    }
    @Test
    public void dataDayOneLocal_isCorrect() throws Exception {
        LocalConnector testConnector = LocalConnector.getSingleInstance();
        String testFirstDay = "Day{" +
                "number=" + 0 +
                ", name='" + "Day 0" + '\''+
                '}';
        assertEquals(testConnector.getUserDays().get(0).toString(), testFirstDay);
    }
    @Test
    public void dataGoalOneLocal_isCorrect() throws Exception {
        LocalConnector testConnector = LocalConnector.getSingleInstance();
        String testFirstGoal = "Goal{" +
                "description='" + "Sample description for day 0"+ '\'' +
                ", status=" + "DONE" +
                ", dayNumber=" + 0 +
                '}';
        assertEquals(testConnector.getDailyGoals().get(0).toString(), testFirstGoal);
    }
    @Test
    public void dataGoalThreeLocal_isCorrect() throws Exception {
        LocalConnector testConnector = LocalConnector.getSingleInstance();
        String testFirstGoal = "Goal{" +
                "description='" + "Sample description for day 1"+ '\'' +
                ", status=" + "DONE" +
                ", dayNumber=" + 1 +
                '}';
        assertEquals(testConnector.getDailyGoals().get(2).toString(), testFirstGoal);
    }
}