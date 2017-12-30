package Strategies;

import Enums.Lifts;

public class CountingStrategy extends Strategies.SkiPassStrategy {

    private int liftsLeft;

    public CountingStrategy(Lifts lifts) {
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
