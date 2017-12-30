import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class SkiPassStrategy {

    private Date dateOfPurchase;
    private Date dueTo;

    void setDate(){
        this.dateOfPurchase = new Date();
        this.dueTo = new Date(2999, 12, 31);
    }

    private boolean blocked;

    abstract boolean isValid();

    boolean isValidDay(WeekMode weekMode){
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

    abstract void check();

    abstract void count();

    abstract void add(int amount);

    boolean isBlocked() {
        return this.blocked;
    }

    boolean isOutdated(){
        return this.dueTo.before(new Date());
    }

    public void setDueTo(Date date){
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
