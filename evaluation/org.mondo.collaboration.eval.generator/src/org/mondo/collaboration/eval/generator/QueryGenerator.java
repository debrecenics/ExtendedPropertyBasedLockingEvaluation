package org.mondo.collaboration.eval.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QueryGenerator {

	public static final String QUERY_PATH = "D:\\Work\\Eclipse\\Acta\\git\\lock-and-merge-evaluation\\evaluation\\org.mondo.collaboration.eval.behaviors\\src-gen\\org\\mondo\\collaboration\\queries\\queries.eiq";

	public static void main(String[] args) throws IOException {
		generate();
	}
	
	public static void generate() throws IOException {

		File file = new File(QUERY_PATH);
		try (FileWriter fr = new FileWriter(file); BufferedWriter br = new BufferedWriter(fr)) {
			br.write(generateDefault());

			br.write(generateMaintainanceQuery(""));
			br.write(generateTestingQuery(""));
			br.write(generateReplacementQuery(""));

			for (int i = 0; i < Configuration.USER_SIZE; i++) {
				br.write(generateMaintainanceQuery(String.valueOf(i)));
				br.write(generateTestingQuery(String.valueOf(i)));
				br.write(generateReplacementQuery(String.valueOf(i)));
			}
		}
	}

	private static String generateDefault() {
		return Templates.defaultTemplate().toString();
	}

	private static String generateReplacementQuery(String i) {
		return Templates.replacingTemplate(i).toString();
	}

	private static String generateTestingQuery(String i) {
		return Templates.testingTemplate(i).toString();
	}

	private static String generateMaintainanceQuery(String i) {
		return Templates.maintananceTemplate(i).toString();
	}

}
