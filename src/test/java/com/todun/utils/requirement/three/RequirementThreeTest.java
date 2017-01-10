package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class RequirementThreeTest {
    private static final BigDecimal EXPECTED_INVALID_VALUE = BigDecimal.ZERO;
    private RequirementThree requirementThree;
    private BigDecimal three = BigDecimal.valueOf(3);
    private BigDecimal four = BigDecimal.valueOf(4);
    private BigDecimal five = BigDecimal.valueOf(5);
    private BigDecimal six = BigDecimal.valueOf(6);
    private BigDecimal negativeOne = BigDecimal.ONE.negate();
    private double precision = 0.01d;

    @Test
    public void testAreaOfValidRightTriangle() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setSideA(three)
                .setSideB(four)
                .setSideC(five)
                .build();
        assertEquals(six.doubleValue(), requirementThree.areaOfRightTriangle(), precision);
    }

    @Test
    public void testAreaOfValidEquilateralTriangle() throws Exception {
        BigDecimal anySideLength = new BigDecimal(100.4);
        requirementThree = new RequirementThreeBuilder()
                .setSideA(anySideLength)
                .setSideB(anySideLength)
                .setSideC(anySideLength)
                .build();
        assertEquals(BigDecimal.valueOf(4364.837).doubleValue(), requirementThree.areaOfRightTriangle(), precision);
    }

    @Test
    public void testAreaOfValidIsoscelesTriangle() throws Exception {
        BigDecimal equalSideLength = new BigDecimal(100.4);
        BigDecimal unEqualSideLength = new BigDecimal(10.4);
        requirementThree = new RequirementThreeBuilder()
                .setSideA(equalSideLength)
                .setSideB(equalSideLength)
                .setSideC(unEqualSideLength)
                .build();
        assertEquals(BigDecimal.valueOf(521.379).doubleValue(), requirementThree.areaOfRightTriangle(), precision);
    }

    @Test
    public void testAreaOfValidObtusedAngledScaleneTriangle() throws Exception {
        BigDecimal sideA = new BigDecimal(21.4);
        BigDecimal sideB = new BigDecimal(80.4);
        BigDecimal sideC = new BigDecimal(101.1);
        requirementThree = new RequirementThreeBuilder()
                .setSideA(sideA)
                .setSideB(sideB)
                .setSideC(sideC)
                .build();
        assertEquals(BigDecimal.valueOf(244.6058).doubleValue(), requirementThree.areaOfRightTriangle(), precision);
    }

    @Test
    public void testAreaOfValidAcuteAngledScaleneTriangle() throws Exception {
        BigDecimal sideA = new BigDecimal(21.9);
        BigDecimal sideB = new BigDecimal(23.1);
        BigDecimal sideC = new BigDecimal(19.4);
        requirementThree = new RequirementThreeBuilder()
                .setSideA(sideA)
                .setSideB(sideB)
                .setSideC(sideC)
                .build();
        assertEquals(BigDecimal.valueOf(196.5496).doubleValue(), requirementThree.areaOfRightTriangle(), precision);
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfInvalidRightTriangle() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setSideA(negativeOne)
                .setSideB(five)
                .setSideC(six)
                .build();
        assertEquals(EXPECTED_INVALID_VALUE, requirementThree.areaOfRightTriangle());
    }

    @Test(expected = InvalidTriangleException.class)
    public void testAreaOfRightTriangleWithNegativeEdges() throws Exception {
        requirementThree = new RequirementThreeBuilder()
                .setSideA(negativeOne)
                .setSideB(five)
                .setSideC(six)
                .build();
        assertEquals(EXPECTED_INVALID_VALUE, requirementThree.areaOfRightTriangle());
    }
}
