
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DailyStrategy extends SkiPassStrategy {

    private int daysLeft;
    private Day checkDay;
    private WeekMode weekMode;

    public DailyStrategy(SkiPassMode days, WeekMode weekMode) {
        switch (days) {
            case ONE_DAY:
                this.daysLeft = 1;
                break;
            case TWO_DAYS:
                this.daysLeft = 2;
                break;
            case FIVE_DAYS:
                this.daysLeft = 5;
                break;
            default:
                this.daysLeft = 0;
        }

        this.weekMode = weekMode;
        this.setDate();

    }


    public void check() {
        System.out.println(daysLeft + " days left");
        System.out.println("Have a nice trip!");
    }

    public void count() {
        Calendar calendar = new GregorianCalendar();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        if (!checkDay.equals(day, month, year)) {
            this.daysLeft--;
            this.checkDay = new Day(day, month, year);
        }
    }

    public int credits() {
        return this.daysLeft;
    }

    public void add(int amount) {
        this.daysLeft += amount;
    }

    public void add() {
        this.daysLeft++;
    }


}

final class Day {
    private int d;
    private int m;
    private int y;

    Day(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public boolean equals(int d, int m, int y) {
        return d == this.d && m == this.m && y == this.y;
    }
}

