import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class SkiPassStrategy implements SkiPassInterface {

    private Date dateOfPurchase;
    private Date dueTo;
    private WeekMode weekMode;

    void setDate() {
        this.dateOfPurchase = new Date();
        this.dueTo = new Date(2999, 12, 31);
    }

    private boolean blocked;

    boolean isValidWeekday() {
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (weekMode) {
            case ALL_WEEK:
                return true;
            case WEEKEND:
                return day >= 6;
            case WEEKDAY:
                return day <= 5;
            default:
                return false;
        }
    }


    public boolean isValid() {
        if (isBlocked()) {
            System.out.println("SkiPass is blocked");
            return false;
        }

        if (isOutdated()) {
            System.out.println("SkiPass is outdated");
            return false;
        }

        if (!isValidWeekday()) {
            System.out.println("SkiPass is available in another weekday");
            return false;
        }

        if (credits() <= 0) {
            System.out.println("No credits left");
            return false;
        }
        return true;
    }


    boolean isBlocked() {
        return this.blocked;
    }

    boolean isOutdated() {
        return this.dueTo.before(new Date());
    }

    public void setDueTo(Date date) {
        this.dueTo = date;
    }

    public Date getDueTo() {
        return dueTo;
    }

    public void block() {
        this.blocked = true;
    }

    public void open() {
        this.blocked = false;
    }

}
