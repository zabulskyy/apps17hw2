import Strategies.CountingStrategy;
import Strategies.SkiPassStrategy;

public class SkiPass {

    private SkiPassStrategy strategy;
    private String identificator;

    SkiPass(String identificator, SkiPassStrategy skiPassStrategy) {
        this.identificator = identificator;
        this.strategy = skiPassStrategy;

    }

    public void setStrategy(SkiPassStrategy skiPassStrategy) {
        this.strategy = skiPassStrategy;
    }

    public SkiPassStrategy getStrategy() {
        return strategy;
    }

    public SkiPassStrategy options(){
        return strategy;
    }

    public String getIdentificator(){
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }
}
