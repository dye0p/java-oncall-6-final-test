package oncall.model;

public class WorkSchedule {

    private final int month;
    private final int date;
    private final String dayOfWeek;
    private Worker worker;

    public WorkSchedule(int month, int date, String dayOfWeek, Worker worker) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.worker = worker;
    }

    public boolean isSameWorker(WorkSchedule beforeWorker) {
        return this.worker.getName().equals(beforeWorker.worker.getName());
    }

    public boolean isHoliday() {
        return DayOfTheWeek.isDayOff(dayOfWeek) || Holidays.isHoliday(month, date);
    }

    public void changeWorkerName(String workerName) {
        this.worker.changeName(workerName);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Worker getWorker() {
        return worker;
    }
}
