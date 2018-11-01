package com.ziemo.converter.formatter;

import java.util.List;

public class XmlOutputFormatter extends AbstractOutputFormatter implements OutputFormatter {

	@Override
	public void printToConsole(List<String> data) {
		extractData(data);
		parseData();
		display();
	}

	private void parseData() {
		String newline = System.lineSeparator();

		outcome = new StringBuilder("<entries>");

		for (int i = 0; i < values.size(); i++) {
			outcome.append(newline).append("<entry").append(i+1).append(">").append(newline);
			for (int j = 0; j < keys.length; j++) {
				outcome.append("<").append(keys[j]).append(">").append(values.get(i)[j])
						.append("</").append(keys[j]).append(">").append(newline);
			}
			outcome.append("</entry").append(i+1).append(">");
		}
		outcome.append(newline).append("</entries>");
	}


}
