package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequirementThreeWithBuilderTest {
    private static final int EXPECTED_INVALID_VALUE = -8;
    private RequirementThree requirementThree;

    @Test
    public void testAreaOfValidRightTriangle() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setBase(3)
                .setHeight(4)
                .setHypotenuse(5)
                .build();
        assertEquals(6, requirementThree.areaOfRightTriangle());
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfInvalidRightTriangle() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setBase(3)
                .setHeight(5)
                .setHypotenuse(15)
                .build();
        assertEquals(EXPECTED_INVALID_VALUE, requirementThree.areaOfRightTriangle());
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfRightTriangleWithNegativeEdges() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setBase(-3)
                .setHeight(5)
                .setHypotenuse(9)
                .build();
        assertEquals(EXPECTED_INVALID_VALUE, requirementThree.areaOfRightTriangle());
    }

    @Test(expected = ArithmeticException.class)
    public void testAreaOfRightTriangleWithIntegerOverflow() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setBase(Integer.MAX_VALUE)
                .setHeight(5)
                .setHypotenuse(59)
                .build();
        assertEquals(EXPECTED_INVALID_VALUE, requirementThree.areaOfRightTriangle());
    }
}
