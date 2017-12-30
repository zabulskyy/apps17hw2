public class Turnstile {
    public static void turn(SkiPass skiPass) {
        if (skiPass.options().isValid()) {
            skiPass.options().count();
            skiPass.options().check();
        }
    }

    public static void block(SkiPass skiPass) {
        skiPass.options().block();
    }

    public static void open(SkiPass skiPass) {
        skiPass.options().open();
    }

    public static void check(SkiPass skiPass) {
        if (skiPass.options().isValid()) {
            skiPass.options().check();
        }
    }
}
