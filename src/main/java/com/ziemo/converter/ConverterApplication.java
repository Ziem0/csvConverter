package com.ziemo.converter;

import com.ziemo.converter.converter.SimpleCsvConverter;
import com.ziemo.converter.exceptions.CsvFormatException;
import com.ziemo.converter.formatter.OutputFormat;
import com.ziemo.converter.formatter.OutputFormatterFactory;
import com.ziemo.converter.reader.FileReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SimpleCsvConverter converter = context.getBean(SimpleCsvConverter.class);

		OutputFormat format;
		File file;

//		SimpleCsvConverter converter = new SimpleCsvConverter(new FileReader(), new OutputFormatterFactory());

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		if (args.length == 1) {
			URL resource = cl.getResource(args[0]);
			assert resource != null;
			file = new File(resource.getFile());
			converter.convert(file);
		} else if (args.length == 2) {
			URL resource = cl.getResource(args[1]);
			format = OutputFormat.fromString(args[0]);
			assert resource != null;
			file = new File(resource.getFile());
			converter.convert(format, file);
		}

	}
}
