package com.ericbandiero.mytestapplication;

import android.util.Log;

/**
 * Created by Eric Bandiero on 6/22/2017.
 */

public class DependObjectForDepend {

	public DependObjectForDepend() {

	}

	public void doSomething(){
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Hello!");
	}
}
