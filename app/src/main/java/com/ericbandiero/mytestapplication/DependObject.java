package com.ericbandiero.mytestapplication;

import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Eric Bandiero on 6/22/2017.
 */

public class DependObject {

	public DependObjectForDepend getDependObjectForDepend() {
		return dependObjectForDepend;
	}

	private DependObjectForDepend dependObjectForDepend;

	@Inject
	public DependObject(DependObjectForDepend dependObjectForDepend) {
		this.dependObjectForDepend=dependObjectForDepend;
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Instantiated depend object");
	}

	public String reversAString(String s)
	{
		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(s);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		dependObjectForDepend.doSomething();

		return input1.toString();
	}
}
