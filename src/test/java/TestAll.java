import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestAll {

    private SkiPass aw_50_L;
    private SkiPass we_2_D;
    private Turnstile turnstile;
    private SkiPassFactory skiPassFactory;

    @Before
    public void setUp() throws Exception {
        skiPassFactory = new SkiPassFactory();
        turnstile = new Turnstile();
        aw_50_L = skiPassFactory.newSkiPass(SkiPassMode.FIFTY_LIFTS, WeekMode.ALL_WEEK);
        we_2_D = skiPassFactory.newSkiPass(SkiPassMode.TWO_DAYS, WeekMode.WEEKEND);
    }

    @Test
    public void test() {
        Turnstile.check(aw_50_L);
        assertEquals(50, aw_50_L.options().credits());
        Turnstile.turn(aw_50_L);
        assertEquals(49, aw_50_L.options().credits());

        assertEquals(2, we_2_D.options().credits());
        Turnstile.block(we_2_D);
        assertEquals(true, we_2_D.options().isBlocked());
        assertEquals(false, we_2_D.options().isValid());
        Turnstile.open(we_2_D);
        assertEquals(false, we_2_D.options().isBlocked());
        assertEquals(true, we_2_D.options().isValid());

        assertEquals(2, we_2_D.options().credits());
        Turnstile.turn(we_2_D);
        assertEquals(2, we_2_D.options().credits());

        Turnstile.check(aw_50_L);
        Turnstile.check(we_2_D);

    }

}