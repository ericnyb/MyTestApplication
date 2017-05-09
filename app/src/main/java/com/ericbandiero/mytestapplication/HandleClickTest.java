package com.ericbandiero.mytestapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ericbandiero.librarymain.data_classes.Lib_ExpandableDataWithIds;
import com.ericbandiero.librarymain.interfaces.IHandleChildClicksExpandableIds;

import java.io.Serializable;
import java.util.ArrayList;

/** This handles a click.
 * Created by ${"Eric Bandiero"} on 4/12/2017.
 */

public class HandleClickTest implements IHandleChildClicksExpandableIds,Serializable {
	@Override
	public void handleClicks(Context context,Lib_ExpandableDataWithIds group, Lib_ExpandableDataWithIds child) {
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Hi:"+child.getTextStringChild());
		if (group.getAnyObject()!=null){
			if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">",((ArrayList)group.getAnyObject()).toString());
		}
		Intent intent=new Intent(context, Main2Activity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
}
