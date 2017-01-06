package com.todun.utils.requirement.four;

import com.todun.exceptions.InvalidInputException;
import org.apache.commons.collections.bag.HashBag;

import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes an array of integers, and returns an array of integers.
 * The return value should contain those integers which are most common in the input array.
 */
class RequirementFour {

    /**
     * Array of most common integers. Empty array input gives empty array output.
     *
     * @param elements array of integers
     * @return array of most common integers
     * @throws InvalidInputException if array is null
     */
    static Integer[] mostCommonElements(Integer[] elements) throws InvalidInputException {
        if (elements == null) throw new InvalidInputException();
        if (elements.length == 0) return new Integer[]{};

        HashBag bagOfElements = bagElements(elements);
        int maxNumberOccurrence = getMaxNumberOccurrenceOfAnyElement(bagOfElements);
        return listElementsWithMaximumOccurrence(bagOfElements, maxNumberOccurrence);
    }

    /**
     * Convert an array of elements into a {@link HashBag} of its elements as keys to frequency of occurrence as values
     *
     * @param elements array element
     * @return {@link HashBag} of array element to frequency of occurrence
     */
    private static HashBag bagElements(Integer[] elements) {
        HashBag bagOfElements = new HashBag();
        List<Integer> elementCollection = Arrays.asList(elements);
        bagOfElements.addAll(elementCollection);
        return bagOfElements;
    }

    /**
     * Generates a distinct list of elements that are repeated the most
     *
     * @param bagOfElements       {@link HashBag} of element to the number of times it repeats
     * @param maxNumberOccurrence maximum number of times an element is repeated
     * @return list of most common elements
     */
    private static Integer[] listElementsWithMaximumOccurrence(HashBag bagOfElements, int maxNumberOccurrence) {
        Object[] result = bagOfElements
                .uniqueSet()
                .stream()
                .filter(element -> bagOfElements.getCount(element) == maxNumberOccurrence) // filter out elements that don't occur maximum number of times
                .toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    /**
     * Determines the maximum number of occurrence
     *
     * @param bagOfElements {@link HashBag} of element to the number of times it repeats
     * @return maximum number of occurrence of an element
     */
    private static int getMaxNumberOccurrenceOfAnyElement(HashBag bagOfElements) {
        return bagOfElements
                .stream()
                .mapToInt(s -> bagOfElements.getCount(s))
                .max()
                .getAsInt();
    }
}
