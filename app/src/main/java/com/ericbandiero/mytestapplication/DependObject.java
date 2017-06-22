package com.ericbandiero.mytestapplication;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Eric Bandiero on 6/22/2017.
 */

class DependObject {
	public DependObject() {
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Instantiated depend object");
	}

	public String reversAString(String s)
	{
		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(s);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		return input1.toString();
	}
}
