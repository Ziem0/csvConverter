package com.ziemo.converter.formatter;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractOutputFormatter {

	String[] keys;
	List<String[]> values;
	StringBuilder outcome;

	void extractData(List<String> data) {

		keys = data.get(0).split(",");

		values = new ArrayList<>();

		for (int i = 1; i < data.size(); i++) {
			values.add(data.get(i).split(","));
		}
	}

	void display() {
		System.out.println(outcome);
	}
}
