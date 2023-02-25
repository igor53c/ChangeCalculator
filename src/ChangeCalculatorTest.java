import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ChangeCalculatorTest {

    @Test
    public void testComputeMostEfficientChange_Simple() {
        ChangeCalculator calculator = new ChangeCalculator(Arrays.asList(1, 5, 10, 25, 100));

        assertEquals(Collections.singletonList(25), calculator.computeMostEfficientChange(25));
        assertEquals(Arrays.asList(5, 10), calculator.computeMostEfficientChange(15));
        assertEquals(Collections.emptyList(), calculator.computeMostEfficientChange(0));
    }

    @Test
    public void testComputeMostEfficientChange_InvalidInput1() {
        ChangeCalculator calculator = new ChangeCalculator(Arrays.asList(1, 5, 10, 25, 100));

        assertThrows(IllegalArgumentException.class, () -> calculator.computeMostEfficientChange(-5));
    }

    @Test
    public void testComputeMostEfficientChange_InvalidInput2() {
        ChangeCalculator calculator = new ChangeCalculator(Arrays.asList(5, 10));

        assertThrows(IllegalArgumentException.class, () -> calculator.computeMostEfficientChange(3));
    }

    @Test
    public void testComputeMostEfficientChange_Complex1() {
        ChangeCalculator calculator1 = new ChangeCalculator(Arrays.asList(1, 2, 5, 10, 20, 50));
        assertEquals(Arrays.asList(1, 2, 10, 50), calculator1.computeMostEfficientChange(63));
    }

    @Test
    public void testComputeMostEfficientChange_Complex2() {
        ChangeCalculator calculator2 = new ChangeCalculator(Arrays.asList(1, 4, 15, 20, 50));
        assertEquals(Arrays.asList(4, 4, 15), calculator2.computeMostEfficientChange(23));
    }

    @Test
    public void testComputeMostEfficientChange_Complex3() {
        ChangeCalculator calculator3 = new ChangeCalculator(Arrays.asList(1, 5, 10, 21, 25));
        assertEquals(Arrays.asList(21, 21, 21), calculator3.computeMostEfficientChange(63));
    }

    @Test
    public void testComputeMostEfficientChange_Complex4() {
        ChangeCalculator calculator4 = new ChangeCalculator(Arrays.asList(2, 5, 10, 20, 50));
        assertEquals(Arrays.asList(2, 2, 2, 5, 10), calculator4.computeMostEfficientChange(21));
    }

    @Test
    public void testComputeMostEfficientChange_Complex5() {
        ChangeCalculator calculator5 = new ChangeCalculator(Arrays.asList(4, 5));
        assertEquals(Arrays.asList(4, 4, 4, 5, 5, 5), calculator5.computeMostEfficientChange(27));
    }

    @Test
    public void testComputeMostEfficientChange_Complex6() {
        ChangeCalculator calculator6 = new ChangeCalculator(Arrays.asList(5, 10));
        assertThrows(IllegalArgumentException.class, () -> calculator6.computeMostEfficientChange(94));
    }
}