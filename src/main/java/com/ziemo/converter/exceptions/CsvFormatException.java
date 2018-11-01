package com.ziemo.converter.exceptions;

public class CsvFormatException extends Exception {

	public CsvFormatException() {
		super();
	}

	public CsvFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public CsvFormatException(Throwable cause) {
		super(cause);
	}

	protected CsvFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
