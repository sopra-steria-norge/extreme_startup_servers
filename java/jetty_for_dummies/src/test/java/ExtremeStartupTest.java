import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup();

    @Test
    public void should_accept_missing_input() {
        assertEquals(server.answer(null), "team name");
    }

    @Test
    public void should_add_numbers() {
        assertEquals(server.answer("what is the sum of 14 and 4"), "18");
    }
}
