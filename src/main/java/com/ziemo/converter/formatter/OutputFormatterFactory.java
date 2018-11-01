package com.ziemo.converter.formatter;

import org.springframework.stereotype.Component;

@Component
public class OutputFormatterFactory {

	public OutputFormatter createByFormat(OutputFormat outputFormat) {

		OutputFormatter format = null;


		switch (outputFormat) {
			case XML:
				format = new XmlOutputFormatter();
				break;
			case JSON:
				format = new JsonOutputFormatter();
				break;
			case TABLE:
				format = new TableOutputFormatter();
				break;
		}

		return format;
	}
}
