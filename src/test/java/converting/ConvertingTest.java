package converting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertingTest {

    @Test
    void testConvertFromStringToInt() {
        String s = "100";
        int expected = 100;
        assertEquals(expected,Converting.convertFromStringToInt(s),"ConvertFromStringToInt is incorrect");
    }

    @Test
    void testConvertFromStringToDouble() {
        String s = "100.5";
        double expected = 100.5;
        assertEquals(expected,Converting.convertFromStringToDouble(s),"ConvertFromStringToInt is incorrect");
    }
}