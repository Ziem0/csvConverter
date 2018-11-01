package com.ziemo.converter.converter;

import com.ziemo.converter.formatter.OutputFormat;
import com.ziemo.converter.formatter.OutputFormatterFactory;
import com.ziemo.converter.reader.FileReader;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.File;

@Getter
@Setter
@Component
public class SimpleCsvConverter {

	private FileReader reader;
	private OutputFormatterFactory factory;

	public SimpleCsvConverter(FileReader reader, OutputFormatterFactory factory) {
		this.reader = reader;
		this.factory = factory;
	}

	public void convert(OutputFormat format, File file) {
		factory.createByFormat(format).printToConsole(reader.readData(file));
	}

	public void convert(File file) {
		this.convert(OutputFormat.TABLE, file);
	}

}
