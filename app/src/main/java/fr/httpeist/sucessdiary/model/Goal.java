package fr.httpeist.sucessdiary.model;

import fr.httpeist.sucessdiary.Status;

/**
 * Created by eisti on 01/11/17.
 */

public class Goal {
    private String description;
    private Status status;
    private String dayNumber;

    public Goal(String description, Status status, String dayNumber) {
        this.description = description;
        this.status = status;
        this.dayNumber = dayNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(String dayNumber) {
        this.dayNumber = dayNumber;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "description='" + description + '\'' +
                ", status=" + status +
                ", dayNumber=" + dayNumber +
                '}';
    }
}
