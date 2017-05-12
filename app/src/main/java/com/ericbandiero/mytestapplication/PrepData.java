package com.ericbandiero.mytestapplication;

import android.util.Log;

import com.ericbandiero.librarymain.data_classes.Lib_ExpandableDataWithIds;

import com.ericbandiero.librarymain.interfaces.IPrepDataExpandableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${"Eric Bandiero"} on 4/9/2017.
 * Interface to prepare data.
 */

public class PrepData implements IPrepDataExpandableList {
	/**
	 * This returns a list of Lib_ExpandableDataWithIds
	 * Commit to be chery picked for merge.
	 * @return
	 */
	@Override
	public List<Lib_ExpandableDataWithIds> prepData() {
		return null;
	}
	//This one one show up when we use cherry pick for previous.
}
