package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;

import java.math.BigDecimal;

/**
 * Write a function that takes three integer inputs and returns a single output.
 * The inputs are the lengths of the sides of a triangle.
 * The output is the area of that triangle.
 */
public class RequirementThree {
    /**
     * sideA length of right triangle
     */
    private BigDecimal sideA;

    /**
     * sideB length of right triangle
     */
    private BigDecimal sideB;

    /**
     * sideC length of right triangle
     */
    private BigDecimal sideC;

    /**
     * Create instance of {@link RequirementThree}.
     * <p>
     * Instances of {@link RequirementThree} can only be created by classes in
     * this package {@link com.todun.utils.requirement.three} with package level visibility.
     * <p>
     * This ensures that only a builder like {@link RequirementThreeBuilder}
     * can create instances of {@link RequirementThree}
     *
     * @param sideA {@link #sideA}
     * @param sideB {@link #sideB}
     * @param sideC {@link #sideC}
     */
    RequirementThree(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Input order assumes that the input is sideA, sideB, sideC
     *
     * @return area of triangle
     * @throws InvalidTriangleException if not a valid right triangle
     */
    public Double areaOfRightTriangle() throws InvalidTriangleException {
        validateTriangle();

        return calculateAreaAnyTriangle();
    }

    /**
     * A right triangle cannot have negative length
     * A valid right triangle sideC squared must equal the sum of the sideA squared plus sideB squared
     *
     * @throws InvalidTriangleException if not a valid right triangle
     */
    private void validateTriangle() throws InvalidTriangleException {
        // a right triangle cannot have negative length
        if (sideA.doubleValue() < 0 || sideB.doubleValue() < 0 || sideC.doubleValue() < 0)
            throw new InvalidTriangleException();

        // length of a side of a valid triangle cannot be greater than half of the triangle's perimeter
        BigDecimal htp = perimeterOfHalfTriangle();
        if (htp.subtract(sideA).doubleValue() < 0
                || htp.subtract(sideB).doubleValue() < 0
                || htp.subtract(sideC).doubleValue() < 0)
            throw new InvalidTriangleException();
    }

    /**
     * Calculate the area of right triangle
     *
     * @return area of right triangle
     */
    private Double calculateAreaAnyTriangle() {
        return triangleArea(perimeterOfHalfTriangle());
    }

    /**
     * {@link #perimeterOfHalfTriangle()}
     *
     * @param halfTrianglePerimeter {@link #perimeterOfHalfTriangle()}
     * @return area of triangle
     */
    private Double triangleArea(BigDecimal halfTrianglePerimeter) {
        return Math.sqrt(halfTrianglePerimeter
                .subtract(sideA)
                .multiply(halfTrianglePerimeter
                        .subtract(sideB))
                .multiply(halfTrianglePerimeter
                        .subtract(sideC))
                .multiply(halfTrianglePerimeter).doubleValue());
    }

    /**
     * Helper method to calculate half of the triangle's perimeter
     *
     * @return half of the triangle's perimeter
     */
    private BigDecimal perimeterOfHalfTriangle() {
        return sideA
                .add(sideB)
                .add(sideC)
                .divide(BigDecimal.valueOf(2));
    }
}
