
import java.util.Calendar;
import java.util.GregorianCalendar;

class DailyStrategy extends SkiPassStrategy {

    private int daysLeft;
    private Day checkDay;

    DailyStrategy(SkiPassMode days, WeekMode weekMode) {
        super(weekMode);
        this.daysLeft = days.credits;
        this.setDay();

    }

    private void setDay() {
        this.checkDay = getCurrentDay();
    }

    private Day getCurrentDay() {
        Calendar calendar = new GregorianCalendar();

        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int m = calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.YEAR);

        return new Day(d, m, y);

    }

    public void check() {
        System.out.println(daysLeft + " days left");
        System.out.println("Have a nice trip!");
    }

    public void count() {
        if (!checkDay.equals(getCurrentDay())) {
            this.daysLeft--;
            this.checkDay = getCurrentDay();
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

    public boolean equals(Day day) {
        return day.d == this.d && day.m == this.m && day.y == this.y;
    }
}

