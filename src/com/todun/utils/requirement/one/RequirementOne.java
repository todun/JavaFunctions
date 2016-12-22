package com.todun.utils.requirement.one;

/**
 * Write an  extension method  on string called IsNullOrEmpty.
 */
public class RequirementOne {

    /**
     * Determines if a string is null or empty
     *
     * @param input string
     * @return true if input is null string or empty string
     */
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
