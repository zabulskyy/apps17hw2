enum SkiPassMode {
    ONE_DAY(1),
    TWO_DAYS(2),
    FIVE_DAYS(5),
    SEVEN_DAYS(7),

    ONE_LIFT(1),
    TEN_LIFTS(10),
    TWENTY_LIFTS(20),
    FIFTY_LIFTS(50),
    HUNDRED_LIFTS(100);

    int credits;

    SkiPassMode(int credits) {
        this.credits = credits;
    }
}
