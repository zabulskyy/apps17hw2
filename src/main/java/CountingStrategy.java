public class CountingStrategy extends SkiPassStrategy {

    private int liftsLeft;
    private WeekMode weekMode;

    CountingStrategy(SkiPassMode lifts, WeekMode weekMode) {
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


    public void check() {
        System.out.println(liftsLeft + " lifts left");
        System.out.println("Have a nice trip!");
    }


    public boolean isValid() {
        if (isBlocked()){
            System.out.println("SkiPass is blocked");
            return false;
        }

        if (isOutdated()){
            System.out.println("SkiPass is outdated");
            return false;
        }

        if (!isValidWeekday()){
            System.out.println("SkiPass is available in another weekday");
            return false;
        }

        if (liftsLeft <= 0){
            System.out.println("No lifts left");
            return false;
        }

        return true;
    }

    public void count() {
        this.liftsLeft--;
    }

    public int credits() {
        return this.liftsLeft;
    }

    public void add(int amount) {
        this.liftsLeft += amount;
    }

    public void add() {
        this.liftsLeft++;
    }
}
