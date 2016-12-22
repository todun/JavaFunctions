package com.todun.tests.requirement.four;

import com.todun.exceptions.InvalidInputException;
import com.todun.utils.requirement.four.RequirementFour;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class RequirementFourTest {

    @Test
    public void testMostCommonElements() throws InvalidInputException {

        Integer[] actual = RequirementFour.mostCommonElements(new Integer[]{5, 4, 3, 2, 4, 5, 1, 6, 1, 2, 5, 4});
        Arrays.sort(actual);
        assertArrayEquals(new Integer[]{4, 5}, actual);

        actual = RequirementFour.mostCommonElements(new Integer[]{1, 2, 3, 4, 5, 1, 6, 7});
        Arrays.sort(actual);
        assertArrayEquals(new Integer[]{1}, actual);

        actual = RequirementFour.mostCommonElements(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Arrays.sort(actual);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7}, actual);
    }

    @Test
    public void testMostCommonElementsWithEmptyArray() throws InvalidInputException {

        assertArrayEquals(new Integer[]{}, RequirementFour.mostCommonElements(new Integer[]{}));
    }

    @Test
    public void testMostCommonElementsWithSameElementArray() throws InvalidInputException {

        assertArrayEquals(new Integer[]{1}, RequirementFour.mostCommonElements(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void testMostCommonElementsWithZeroElementsArray() throws InvalidInputException {

        assertArrayEquals(new Integer[]{0}, RequirementFour.mostCommonElements(new Integer[]{0, 0, 0, 0, 0, 0, 0}));
    }


    @Test(expected = InvalidInputException.class)
    public void testMostCommonElementsWithNullInput() throws InvalidInputException {
        RequirementFour.mostCommonElements(null);
    }
}
