package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThat;

public class AddNumbersTest {

    @Test
    void emptyString(){
        assertEquals(0, StringCalculator.add(""));
        assertThat(StringCalculator.add(""), is(0));
    }

    @Test
    void oneNumber() {
        assertThat(StringCalculator.add("1"), is(1));
    }

    @Test
    void twoNumbers() {
        assertThat(StringCalculator.add("1,2"), is(3));
    }

    @Test
    void fiveNumbers() {
        assertThat(StringCalculator.add("1,2,3,4,5"), is(15));
    }

    @Test
    void newLineSeparator() {
        assertThat(StringCalculator.add("1,2\n3"), is(6));
    }

    @Test
    void changeDelimiter() {
        assertThat(StringCalculator.add("//;\n1;2;3"), is(6));
    }

    @Test
    void checkNegatives() {
        assertThat(StringCalculator.add("1,2,-3"), is(0));
    }

    @Test
    void overThousandValues() {
        assertThat(StringCalculator.add("1,2,1001"), is(3));
    }
}
