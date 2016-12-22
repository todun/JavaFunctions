package com.todun.utils.requirement.two;

import com.todun.exceptions.InvalidPositiveIntegerException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RequirementTwoTest {
    @Test
    public void testPositiveDivisorOf6() {
        Integer[] expected = new Integer[]{1, 2, 3, 6};

        Integer[] actual = RequirementTwo.positiveDivisorsArray(6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPositiveDivisorOf60() {
        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60};

        Integer[] actual = RequirementTwo.positiveDivisorsArray(60);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPositiveDivisorOf42() {
        Integer[] expected = new Integer[]{1, 2, 3, 6, 7, 14, 21, 42};

        Integer[] actual = RequirementTwo.positiveDivisorsArray(42);
        assertArrayEquals(expected, actual);
    }

    @Test(expected = InvalidPositiveIntegerException.class)
    public void testPositiveDivisorOfNegativeInteger() {

        RequirementTwo.positiveDivisorsArray(-42);
    }
}
