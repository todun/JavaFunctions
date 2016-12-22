package com.todun.utils.requirement.three;

import com.todun.exceptions.InvalidTriangleException;

/**
 * Write a function that takes three integer inputs and returns a single output.
 * The inputs are the lengths of the sides of a triangle.
 * The output is the area of that triangle.
 */
public class RequirementThree {

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
        if (base < 0 || height < 0 || hypotenuse < 0) throw new InvalidTriangleException();

        if (hypotenuse * hypotenuse != base * base + height * height) throw new InvalidTriangleException();

        return (base * height) / 2;
    }
}
