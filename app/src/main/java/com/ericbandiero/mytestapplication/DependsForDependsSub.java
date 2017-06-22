package com.ericbandiero.mytestapplication;

import android.util.Log;

/**
 * Created by Eric Bandiero on 6/22/2017.
 */

public class DependsForDependsSub extends DependObjectForDepend{
	public DependsForDependsSub() {

	}
	public void sayGoodby(){
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Bye!");
	}
}
