package com.todun.utils.requirement.four;

import com.todun.exceptions.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a function that takes an array of integers, and returns an array of integers.
 * The return value should contain those integers which are most common in the input array.
 */
class RequirementFour {

    /**
     * Array of most common integers
     *
     * @param elements array of integers
     * @return array of most common integers
     * @throws InvalidInputException if array is null
     */
    static Integer[] mostCommonElements(Integer[] elements) throws InvalidInputException {
        if (elements == null) throw new InvalidInputException();

        if (elements.length == 0) return new Integer[]{};


        Map<Integer, Long> occurrences = arrayToMapOfArrayElementOccurrenceFrequency(elements);

        Long maxOccurrence = getMaxOccurrence(occurrences);

        List listOfMax = listMostCommonElements(occurrences, maxOccurrence);

        return (Integer[]) listOfMax.toArray(new Integer[listOfMax.size()]);
    }

    /**
     * Generates a distinct list of elements that are repeated the most
     *
     * @param occurrences   map of element to the number of times it repeats
     * @param maxOccurrence maximum number of times an element is repeated
     * @return list of most common elements
     */
    private static List listMostCommonElements(Map<Integer, Long> occurrences, Long maxOccurrence) {
        return occurrences
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxOccurrence))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Determines the maximum number of occurrence
     *
     * @param occurrences map of element to the number of times it repeats
     * @return maximum number of occurrence of an element
     */
    private static Long getMaxOccurrence(Map<Integer, Long> occurrences) {
        return occurrences.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();
    }

    /**
     * Convert an array of elements into a map of its elements as keys to frequency of occurrence as values
     *
     * @param elements array of elements
     * @return map of array element to frequency of occurrence
     */
    private static Map<Integer, Long> arrayToMapOfArrayElementOccurrenceFrequency(Integer[] elements) {
        return Arrays.stream(elements).collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }
}
