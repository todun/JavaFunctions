package com.todun.utils.requirement.two;

import com.todun.exceptions.InvalidPositiveIntegerException;

import java.util.ArrayList;

/**
 * Write a function that takes a single positive integer, and returns a collection / sequence of integers.
 * The return value should contain those integers that are  positive divisors  of the input integer.
 */
public class RequirementTwo {

    /**
     * Helper method for {@link #positiveDivisorsArray(int)}
     *
     * @param input positive integer value
     * @return value should contain those integers that are  positive divisors  of the input integer.
     * @throws InvalidPositiveIntegerException if input to {@link #positiveDivisors(int)} is negative
     */
    private static ArrayList<Integer> positiveDivisors(int input) throws InvalidPositiveIntegerException {

        if (input < 0) throw new InvalidPositiveIntegerException();

        int acc = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (acc != input) {
            acc++;
            if (input % acc == 0) {
                result.add(acc);
            }
        }
        return result;
    }

    /**
     * Takes a single positive integer, and returns a collection / sequence of integers.
     *
     * @param input positive integer value
     * @return value should contain those integers that are  positive divisors  of the input integer.
     */
    public static Integer[] positiveDivisorsArray(int input) {
        ArrayList<Integer> result = positiveDivisors(input);
        return result.toArray(new Integer[result.size()]);
    }
}
