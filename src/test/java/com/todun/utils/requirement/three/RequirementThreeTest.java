package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequirementThreeTest {
    @Test
    public void testAreaOfValidRightTriangle() throws InvalidTriangleException {

        assertEquals(6, RequirementThree.areaOfRightTriangle(3, 4, 5));
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfInvalidRightTriangle() throws InvalidTriangleException {

        assertEquals(6, RequirementThree.areaOfRightTriangle(3, 5, 5));
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfRightTriangleWithNegativeEdges() throws InvalidTriangleException {

        assertEquals(-6, RequirementThree.areaOfRightTriangle(-3, 5, 5));
    }
}
