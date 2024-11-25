package oncall.model;

public class WorkSchedule {

    private final int month;
    private final int date;
    private final String dayOfweek;
    private final String worker;

    public WorkSchedule(int month, int date, String dayOfWeek, String worker) {
        this.month = month;
        this.date = date;
        this.dayOfweek = dayOfWeek;
        this.worker = worker;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfweek() {
        return dayOfweek;
    }

    public String getWorker() {
        return worker;
    }
}
