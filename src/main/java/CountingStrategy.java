import java.util.Calendar;
import java.util.GregorianCalendar;

public class CountingStrategy extends SkiPassStrategy {

    private int liftsLeft;
    private WeekMode weekMode;

    public CountingStrategy(SkiPassMode lifts, WeekMode weekMode) {
        switch (lifts) {
            case ONE_LIFT:
                this.liftsLeft = 1;
                break;
            case TEN_LIFTS:
                this.liftsLeft = 10;
                break;
            case TWENTY_LIFTS:
                this.liftsLeft = 20;
                break;
            case FIFTY_LIFTS:
                this.liftsLeft = 50;
                break;
            case HUNDRED_LIFTS:
                this.liftsLeft = 100;
                break;

        }
        this.weekMode = weekMode;
        this.setDate();

    }

    public boolean isValidWeekday() {
        return this.isValidDay(this.weekMode);
    }


    void check() {
        System.out.println(liftsLeft + " lifts left");
        System.out.println("Have a nice trip!");
    }


    public boolean isValid() {
        return this.liftsLeft > 0 && !this.isBlocked() && !this.isOutdated();
    }

    void count() {
        this.liftsLeft--;
    }

    void add(int amount) {

    }
}
