import java.util.UUID;

public class SkiPassFactory {
    public SkiPass newSkiPass(SkiPassMode skiPassMode, WeekMode weekMode) throws Exception {
        String id = UUID.randomUUID().toString();

        SkiPassStrategy skiPassStrategy;

        switch (skiPassMode) {
            case ONE_DAY:
            case TWO_DAYS:
            case FIVE_DAYS:
            case SEVEN_DAYS:
                skiPassStrategy = new DailyStrategy(skiPassMode, weekMode);
                break;
            case ONE_LIFT:
            case TEN_LIFTS:
            case TWENTY_LIFTS:
            case FIFTY_LIFTS:
            case HUNDRED_LIFTS:
                skiPassStrategy = new CountingStrategy(skiPassMode, weekMode);
                break;
            default:
                throw new Exception("No valid mode was chosen");
        }

        return new SkiPass(id, skiPassStrategy);
    }
}