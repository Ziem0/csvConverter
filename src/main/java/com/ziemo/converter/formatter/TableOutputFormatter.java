package com.ziemo.converter.formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TableOutputFormatter implements OutputFormatter {

	private List<List<String>> data;
	private StringBuilder outcome;

	@Override
	public void printToConsole(List<String> data) {
		extractData(data);
		prepareTable();
		display();
	}

	private void extractData(List<String> data) {

		this.data = new ArrayList<>();

		for (String entry: data) {
			List<String> listData = Arrays.asList(entry.split(","));
			this.data.add(listData);
		}
	}

	private void prepareTable() {

		String newline = System.lineSeparator();
		List<String> labels = data.get(0);
		List<Integer> widths = calculateWidths(); // last element is a total table width

		outcome = new StringBuilder();

		String horizontalLine = String.join("", Collections.nCopies(widths.get(widths.size()-1), "-"));

		for (int i = 0; i < data.size(); i++) {

			List<String> entry = data.get(i);
			String index = i==0 ? "#" : String.valueOf(i);

			if (i == 1) {
				outcome.append(horizontalLine).append(newline);
			}
			outcome.append(String.format("| %2s |", index));

			for(int column = 0; column < labels.size(); column++) {
				int width = widths.get(column);
				outcome.append(String.format(" %" + width + "s |", entry.get(column)));
			} outcome.append(newline);
		}
	}

	private void display() {

		System.out.println(outcome.toString());
	}

	private List<Integer> calculateWidths() {

		List<Integer> widths = new ArrayList<>();
		Integer totalWidth = 0;
		int columnsNumber = data.get(0).size();
		int totalOffset = 6 + columnsNumber * 3; // Total padding of all columns + width of index column

		for (int i=0; i < columnsNumber; i++) {

			Integer longest = data.get(0).get(i).length();

			for (List<String> row : data) {

				Integer currentWidth;
				String current = row.get(i);
				if (current != null) {      // This is to account for any entry being literally "null"
					currentWidth = current.length();
				} else {
					currentWidth = 4; // "Length" of null
				}

				if (currentWidth > longest) {
					longest = currentWidth;
				}
			}
			widths.add(longest);
			totalWidth += longest;
		}
		widths.add(totalWidth + totalOffset);
		return widths;
	}

}
