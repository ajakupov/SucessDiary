package fr.httpeist.sucessdiary;

import org.junit.Test;

import java.util.Date;

import fr.httpeist.sucessdiary.DAO.DayDAO;
import fr.httpeist.sucessdiary.db.LocalConnector;
import fr.httpeist.sucessdiary.model.Day;

import static org.junit.Assert.assertEquals;

/**
 * Created by eisti on 07/11/17.
 */

public class ConnectorUnitTest {
    @Test
    public void dataDaysLengthLocal_isCorrect() throws Exception {
        DayDAO dayDAO = new DayDAO();
        dayDAO.setConnector(LocalConnector.getSingleInstance());
        assertEquals(dayDAO.getDaysList().size(), 6);
    }

    @Test
    public void addDay_isCorrect() throws Exception {
        DayDAO dayDAO = new DayDAO();
        dayDAO.setConnector(LocalConnector.getSingleInstance());
        Day day = new Day(78, "Sample Description", new Date());
        dayDAO.addDay(day);

        assertEquals(dayDAO.getDaysList().size(), 6);
    }

    @Test
    public void addDayValue_isCorrect() throws Exception {
        DayDAO dayDAO = new DayDAO();
        dayDAO.setConnector(LocalConnector.getSingleInstance());
        Day day = new Day(81, "Sample Description", new Date());
        dayDAO.addDay(day);

        assertEquals(dayDAO.getDayByNumber(81).toString(),
                "Day{number=81, name='Sample Description'}");
    }
}