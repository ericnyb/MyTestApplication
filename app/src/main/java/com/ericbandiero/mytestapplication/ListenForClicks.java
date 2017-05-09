package com.ericbandiero.mytestapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.ericbandiero.librarymain.data_classes.Lib_ExpandableDataWithIds;
import com.ericbandiero.librarymain.interfaces.IHandleChildClicksExpandableIds;

import java.io.Serializable;

/**
 * Our handler
 * Created by ${"Eric Bandiero"} on 4/11/2017.
 */

public class ListenForClicks implements ExpandableListView.OnChildClickListener,Serializable {
		private Lib_ExpandableDataWithIds groupObjectClicked;
		private Lib_ExpandableDataWithIds childObjectClicked;
		private IHandleChildClicksExpandableIds iHandleChildClicksExpandableIds;

	public ListenForClicks() {

	}

	public ListenForClicks(IHandleChildClicksExpandableIds iHandleChildClicksExpandableIds) {
		this.iHandleChildClicksExpandableIds = iHandleChildClicksExpandableIds;
	}

	@Override
	public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
		ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
		groupObjectClicked = (Lib_ExpandableDataWithIds) expandableListAdapter.getGroup(groupPosition);
		childObjectClicked = (Lib_ExpandableDataWithIds) expandableListAdapter.getChild(groupPosition,childPosition);

		if (iHandleChildClicksExpandableIds!=null){
			iHandleChildClicksExpandableIds.handleClicks(view.getContext(),groupObjectClicked,childObjectClicked);
		}

		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Parent text:"+groupObjectClicked.getTextStringGroup());
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Parent text:"+childObjectClicked.getTextStringChild());
	//	Intent intent=new Intent(view.getContext(), Main2Activity.class);
	//	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","view context:"+view.getContext().getPackageName().toString());
		//view.getContext().startActivity(intent);
		return true;
	}
}
