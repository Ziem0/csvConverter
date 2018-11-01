package com.ziemo.converter;

import com.ziemo.converter.converter.SimpleCsvConverter;
import com.ziemo.converter.exceptions.CsvFormatException;
import com.ziemo.converter.formatter.OutputFormat;

import java.io.File;
import java.io.IOException;

public class ConverterApplication {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No input file defined!\nEnter requested file format and file name to convert!");
		} else {
			try {
				handleNumberOfArgs(args);
			} catch (IOException | CsvFormatException e) {
				e.printStackTrace();
			}
		}
	}

	private static void handleNumberOfArgs(String[] args) throws IOException, CsvFormatException {
		OutputFormat format;
		File file;

		SimpleCsvConverter converter = new SimpleCsvConverter();

		if (args.length == 1) {
			file = new File(args[0]);
			converter.convert(file);
		} else if (args.length == 2) {
			format = OutputFormat.fromString(args[0]);
			file = new File(args[1]);
			converter.convert(format, file);
		}


	}
}
