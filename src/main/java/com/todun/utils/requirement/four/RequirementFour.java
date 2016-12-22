package com.todun.utils.requirement.four;

import com.todun.exceptions.InvalidInputException;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Write a function that takes an array of integers, and returns an array of integers.
 * The return value should contain those integers which are most common in the input array.
 */
public class RequirementFour {

    /**
     * Array of most common integers
     *
     * @param elements array of integers
     * @return array of most common integers
     * @throws InvalidInputException if array is null
     */
    public static Integer[] mostCommonElements(Integer[] elements) throws InvalidInputException {
        if (elements == null) throw new InvalidInputException();

        HashMap<Integer, Integer> elementToFrequency = getElementToFrequency(elements);

        HashMap<Integer, HashSet<Integer>> frequencyToElements = getElementsWithSameFrequencyValues(elements, elementToFrequency);

        return getMostCommonElements(frequencyToElements);
    }

    /**
     * Helper method for {@link #mostCommonElements(Integer[])}.
     * Gets the most common elements in a given map.
     * <p>
     * if map is not empty, return value of maximum key
     * else return empty array
     *
     * @param frequencyToElements number of occurences of element in input
     * @return array of most common integers
     */
    private static Integer[] getMostCommonElements(HashMap<Integer, HashSet<Integer>> frequencyToElements) {
        int mapSize = frequencyToElements.size();
        if (mapSize > 0) {
            int maxKey = Collections.max(frequencyToElements.keySet());

            HashSet<Integer> mostCommonUniqueElements = frequencyToElements.get(maxKey);
            Integer[] mostCommonElementsArray = mostCommonUniqueElements.toArray(new Integer[mostCommonUniqueElements.size()]);
            return mostCommonElementsArray;
        } else {
            return new Integer[]{};
        }
    }

    /**
     * Helper method for {@link #mostCommonElements(Integer[])}. Build frequency's to elements map
     *
     * @param elements           input array
     * @param elementToFrequency map of element to its frequency
     * @return map of frequency to elements that have the same frequency
     */
    private static HashMap<Integer, HashSet<Integer>> getElementsWithSameFrequencyValues(Integer[] elements, HashMap<Integer, Integer> elementToFrequency) {
        HashMap<Integer, HashSet<Integer>> frequencyToElements = new HashMap();
        HashSet<Integer> elementsWithSameFrequencyValues = new HashSet();
        for (Integer element : elements) {
            Integer frequencyKey = elementToFrequency.get(element); // frequency value of the input element

            // reset the values collection of most common elements
            if (frequencyToElements.get(frequencyKey) == null) {
                elementsWithSameFrequencyValues = new HashSet();
                frequencyToElements.put(frequencyKey, elementsWithSameFrequencyValues);
            }

            // update the values collection of most common elements
            if (frequencyToElements.get(frequencyKey) != null) {
                elementsWithSameFrequencyValues = frequencyToElements.get(frequencyKey);
                // update value list
                elementsWithSameFrequencyValues.add(element);
                // update map with kye,value pair
                frequencyToElements.put(frequencyKey, elementsWithSameFrequencyValues);
            }
        }
        return frequencyToElements;
    }

    /**
     * Helper method to {@link #mostCommonElements(Integer[])}.
     * Map of each element to its frequency of occurence in the integer array
     *
     * @param elements integer array
     * @return frequency of occurence of each element in integer input array
     */
    private static HashMap<Integer, Integer> getElementToFrequency(Integer[] elements) {
        // build element's to frequency map
        HashMap<Integer, Integer> elementToFrequency = new HashMap<Integer, Integer>();
        int numberOfRepetitions;
        for (Integer key : elements) {
            if (elementToFrequency.get(key) == null) {
                numberOfRepetitions = 0;
                elementToFrequency.put(key, numberOfRepetitions);
            }
            numberOfRepetitions = elementToFrequency.get(key);
            numberOfRepetitions++;
            elementToFrequency.put(key, new Integer(numberOfRepetitions));
        }
        return elementToFrequency;
    }
}
