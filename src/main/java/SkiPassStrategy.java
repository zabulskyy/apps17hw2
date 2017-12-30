import java.util.Date;

public abstract class SkiPassStrategy {

    SkiPassStrategy(){
        this.dateOfPurchase = new Date();
        this.dueTo = new Date(2999, 12, 31);
    }

    private Date dateOfPurchase;
    private Date dueTo;

    private boolean blocked;

    abstract boolean isValid();

    abstract void check();

    abstract void count();

    abstract void add(int amount);

    public boolean isBlocked() {
        return this.blocked;
    }

    public boolean isOutdated(){
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
