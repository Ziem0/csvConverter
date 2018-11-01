package com.ziemo.converter.reader;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
public class FileReader {

	public List<String> readData(File file) {

		List<String> data = new LinkedList<>();

		try (Scanner sc = new Scanner(new BufferedReader(new java.io.FileReader(file)))) {

			sc.useDelimiter(System.lineSeparator());

			while (sc.hasNext()) {
				data.add(sc.next());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}
}
