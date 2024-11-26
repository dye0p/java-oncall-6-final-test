package oncall.model;

@FunctionalInterface
public interface HolidayMatchers {

    boolean matchHoliday(int month, int date);
}
