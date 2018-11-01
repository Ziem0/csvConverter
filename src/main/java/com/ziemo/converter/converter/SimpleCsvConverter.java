package com.ziemo.converter.converter;

import com.ziemo.converter.formatter.OutputFormat;

import java.io.File;

public class SimpleCsvConverter {

	public void convert(OutputFormat format, File file) {
		System.out.println("I convert csv to output format");
	}

	public void convert(File file) {
		System.out.println("I convert csv to output format");
	}


}
