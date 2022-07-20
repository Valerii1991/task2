package broadcasts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTest {
    Content content;

    @BeforeEach
    void setUp() {
        content = Interview.builder().setTime(10).setPrice(30).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProfit() {
        double expected = 300;
        assertEquals(expected,content.getProfit(),"profit interview is incorrect");
    }
}