package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Implement ISymptomWriter
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final List<String> SYMPTOMS;
    private final String FILENAME;

    /**
     *
     * @param symptoms is a list of symptoms
     * @param filename is a filename that will be created.
     */
    WriteSymptomDataToFile(List<String> symptoms, String filename) {
        this.SYMPTOMS = new ArrayList<>(symptoms);
        this.FILENAME = filename;
    }

    @Override
    public void createFile() {
        TreeMap<String, Integer> map = sortSymptom(); // Get TreeMap from sortSymptom
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry<String, Integer> entry = it.next();
                writer.write(String.format("%s=%d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return TreeMap<String, Integer> (key = symptom, value = count occurrences of a word)
     */
    private TreeMap<String, Integer> sortSymptom() {
        TreeMap<String, Integer> map = new TreeMap<>(); // String is symptom, Integer is count occurrences of a symptom

        for (String symptom : SYMPTOMS) {
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
