import java.util.UUID;

public class SkiPassFactory {
    public static SkiPass newSkiPass(SkiPassMode skiPassMode, WeekMode weekMode) throws Exception {
        String id = UUID.randomUUID().toString();

        SkiPassStrategy skiPassStrategy;

        switch (skiPassMode) {
            case ONE_DAY:
                skiPassStrategy = new DailyStrategy(skiPassMode, weekMode);
                break;
            case TWO_DAYS:
                skiPassStrategy = new DailyStrategy(skiPassMode, weekMode);
                break;
            case FIVE_DAYS:
                skiPassStrategy = new DailyStrategy(skiPassMode, weekMode);
                break;
            case ONE_LIFT:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            case TEN_LIFTS:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            case TWENTY_LIFTS:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            case FIFTY_LIFTS:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            case HUNDRED_LIFTS:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            default:
                throw new Exception("No valid mode was chosen");
        }

        return new SkiPass(id, skiPassStrategy);
    }
}