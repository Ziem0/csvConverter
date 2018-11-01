package com.ziemo.converter.formatter;

public enum OutputFormat {

	JSON("Json"), XML("XML"), TABLE("Table");

	String argName;

	OutputFormat(String argName) {
		this.argName = argName;
	}

	@Override
	public String toString() {
		return this.argName;
	}

	public static OutputFormat fromString(String argName) throws IllegalArgumentException{
		for (OutputFormat outputFormat : OutputFormat.values()) {
			if (argName.equalsIgnoreCase(outputFormat.toString())) {
				return outputFormat;
			}
		}
		throw new IllegalArgumentException("Unsupported output format");
	}

}
