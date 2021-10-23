package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Implement ISymptomWriter
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final List<String> symptoms;
    private final String filename;

    /**
     *
     * @param symptoms is a list of symptoms
     * @param filename is a filename that will be created.
     */
    WriteSymptomDataToFile(List<String> symptoms, String filename) {
        this.symptoms = new ArrayList<>(symptoms);
        this.filename = filename;
    }

    @Override
    public void createFile() {
        TreeMap<String, Integer> map = sortSymptom(); // Get TreeMap from sortSymptom

        try(PrintWriter pw = new PrintWriter(filename, "utf-8")) {
            map.forEach((k,v) -> { // k -> key(Symptom), v -> value(count occurrences)
                pw.println(String.format("%s=%d",k,v));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return TreeMap<String, Integer> (key = symptom, value = count occurrences of a word)
     */
    private TreeMap<String, Integer> sortSymptom() {
        TreeMap<String, Integer> map = new TreeMap<>(); // String is symptom, Integer is count occurrences of a symptom

        for (String symptom : symptoms) {
            if (map.containsKey(symptom)) {
                Integer cnt = map.get(symptom); // Get symptom's value(count occurrences)
                map.put(symptom, cnt + 1); // old value + 1
            } else { // If this symptom isn't in TreeMap
                map.put(symptom, 1); // add symptom in TreeMap
            }
        }
        return map;
    }

}
