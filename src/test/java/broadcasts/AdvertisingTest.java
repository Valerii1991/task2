package broadcasts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvertisingTest {
    Content content;

    @BeforeEach
    void setUp() {
         content = Advertising.builder().setTime(5).setPrice(300).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProfit() {
        double expected = 1500;
        assertEquals(expected,content.getProfit(),"profit advertising is incorrect");
    }
}