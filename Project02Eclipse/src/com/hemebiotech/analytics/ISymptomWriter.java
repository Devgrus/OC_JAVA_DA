package com.hemebiotech.analytics;

/**
 * Write data of symptoms from a list of string (List<string>)
 * With this data, it needs to create a file (ex: result.out)
 * This file has :
 *     - every symptom in a list of string
 *     - count occurrences of a word in this list.
 * (ex: headache=3)
 * The implementation need to order the list (alphabetically, ascending order)
 *
 */
public interface ISymptomWriter {
    /**
     * Create file
     */
    void createFile();
}
