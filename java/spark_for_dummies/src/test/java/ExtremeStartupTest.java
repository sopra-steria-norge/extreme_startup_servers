import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExtremeStartupTest {

    private final ExtremeStartup server = new ExtremeStartup("spark team");

    @Test
    public void should_accept_missing_input() {
        assertEquals(server.answer(null), "spark team");
    }

    @Test
    public void should_answer_name() {
        assertEquals(server.answer("what is your name"), "spark team");
    }

    @Test
    public void should_add_numbers() {
        assertEquals(server.answer("what is the sum of 4 and 12"), "16");
    }

}
