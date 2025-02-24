package org.example;

import org.junit.Test;  // JUnit 4 Test annotation
import static org.junit.Assert.assertEquals;  // JUnit 4 Assertions

public class LargestNumberTest {

    // Helper method to find the largest number (same logic as the main program)
    public int findLargest(int num1, int num2, int num3) {
        int largest = num1;
        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }
        return largest;
    }

    @Test
    public void testFirstNumberIsLargest() {
        assertEquals(5, findLargest(5, 3, 2));
    }

    @Test
    public void testSecondNumberIsLargest() {
        assertEquals(8, findLargest(4, 8, 3));
    }

    @Test
    public void testThirdNumberIsLargest() {
        assertEquals(6, findLargest(1, 2, 6));
    }

    @Test
    public void testAllNumbersAreEqual() {
        assertEquals(7, findLargest(7, 7, 7));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-1, findLargest(-2, -5, -1));
    }

    @Test
    public void testWithZero() {
        assertEquals(5, findLargest(0, 0, 5));
    }
}

