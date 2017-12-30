class CountingStrategy extends SkiPassStrategy {

    private int liftsLeft;
    private WeekMode weekMode;

    CountingStrategy(SkiPassMode lifts, WeekMode weekMode) {
        super(weekMode);
        this.liftsLeft = lifts.credits;
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
