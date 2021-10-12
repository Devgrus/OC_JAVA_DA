package com.hemebiotech.analytics;

import java.io.File;
import java.util.List;

/**
 * This class should create a result file.
 */
public class AnalyticsCounter {
	/**
	 *
	 * @param args is a string array of files' paths. This is not mandatory but if you use this parameter,
	 * args[0] should be an input file path and args[1] should be an output file path.
	 *
	 */
	public static void main(String args[]) {
		// If there is no main's parameter, use these paths for input and output path
		String symptomsPath = "Project02Eclipse" + File.separator + "symptoms.txt";
		String resultPath = "result.out";

		boolean argsExist = args.length != 0; // Verify existence of main's parameter
		ReadSymptomDataFromFile readSymptom = argsExist ?
				new ReadSymptomDataFromFile(args[0]) :
				new ReadSymptomDataFromFile(symptomsPath);
		List<String> symptomsList = readSymptom.getSymptoms(); // Get a list of symptoms from the instance

		WriteSymptomDataToFile writeSymptom = argsExist ?
				new WriteSymptomDataToFile(symptomsList, args[1]) :
				new WriteSymptomDataToFile(symptomsList, resultPath);
		writeSymptom.createFile(); // Create a file from the instance
	}
}
