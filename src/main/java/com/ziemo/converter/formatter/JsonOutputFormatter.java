package com.ziemo.converter.formatter;

import java.util.List;

public class JsonOutputFormatter extends AbstractOutputFormatter implements OutputFormatter {

	@Override
	public void printToConsole(List<String> data) {
		extractData(data);
		parseData();
		display();
	}

	private void parseData() {
		String newLine = System.lineSeparator();

		outcome = new StringBuilder("[");

		for (String[] row : values) {
			outcome.append("{").append(newLine);
			for (int i = 0; i < row.length; i++) {
				outcome.append(keys[i]).append(" : '").append(row[i]).append("',").append(newLine);
			}
			outcome.append("},");
		}

		outcome.append("]");
	}

}
