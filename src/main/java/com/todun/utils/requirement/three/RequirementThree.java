package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;

/**
 * Write a function that takes three integer inputs and returns a single output.
 * The inputs are the lengths of the sides of a triangle.
 * The output is the area of that triangle.
 */
public class RequirementThree {
    /**
     * base length of right triangle
     */
    private int base;

    /**
     * height length of right triangle
     */
    private int height;

    /**
     * hypotenuse length of right triangle
     */
    private int hypotenuse;

    /**
     * Create instance of {@link RequirementThree}.
     * <p>
     * Instances of {@link RequirementThree} can only be created by classes in
     * this package {@link com.todun.utils.requirement.three} with package level visibility.
     * <p>
     * This ensures that only a builder like {@link RequirementThreeBuilder}
     * can create instances of {@link RequirementThree}
     *
     * @param base       {@link #base}
     * @param height     {@link #height}
     * @param hypotenuse {@link #hypotenuse}
     */
    RequirementThree(int base, int height, int hypotenuse) {
        this.base = base;
        this.height = height;
        this.hypotenuse = hypotenuse;
    }

    /**
     * Input order assumes that the input is base, height, hypotenuse
     *
     * @return area of triangle
     * @throws InvalidTriangleException if not a valid right triangle
     */
    public int areaOfRightTriangle() throws InvalidTriangleException {
        validateRightTriangle(this.base, this.height, this.hypotenuse);

        return calculateAreaOfRightTriangle(base, height);
    }

    /**
     * Input order assumes that the input is base, height, hypotenuse
     *
     * @param base       base length of right triangle
     * @param height     height of right triangle
     * @param hypotenuse hypotenuse of right traingle
     * @return area of triangle
     * @throws InvalidTriangleException if not a valid right triangle
     */
    public static int areaOfRightTriangle(int base, int height, int hypotenuse) throws InvalidTriangleException {
        validateRightTriangle(base, height, hypotenuse);

        return calculateAreaOfRightTriangle(base, height);
    }

    /**
     * A right triangle cannot have negative length
     * A valid right triangle hypotenuse squared must equal the sum of the base squared plus height squared
     *
     * @param base       {@link #base}
     * @param height     {@link #height}
     * @param hypotenuse {@link #hypotenuse}
     * @throws InvalidTriangleException if not a valid right triangle
     */
    private static void validateRightTriangle(int base, int height, int hypotenuse) throws InvalidTriangleException {
        // a right triangle cannot have negative length
        if (base < 0 || height < 0 || hypotenuse < 0) throw new InvalidTriangleException();
        // a valid right triangle hypotenuse squared must equal the sum of the base squared plus height squared
        if (square(hypotenuse) != square(base) + square(height)) throw new InvalidTriangleException();
    }

    /**
     * Calculate the area of right triangle
     *
     * @param base   {@link #base}
     * @param height {@link #height}
     * @return area of right triangle
     */
    private static int calculateAreaOfRightTriangle(int base, int height) {
        return Math.floorDiv(base * height, 2);
    }

    /**
     * Compute the square of number
     *
     * @param num number to be squared
     * @return square of number
     * @throws ArithmeticException if the result overflows an int
     * @since 1.8
     */
    private static int square(int num) throws ArithmeticException {
        return Math.multiplyExact(num, num);
    }
}
