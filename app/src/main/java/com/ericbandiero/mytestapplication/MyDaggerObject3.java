package com.ericbandiero.mytestapplication;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

public class MyDaggerObject3 extends MyDaggerObject {


	DependObject dependObject;


	public MyDaggerObject3(String userName,DependObject dependObject) {
		super(userName);
		this.dependObject=dependObject;
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Created mydagger3 - in constructor");
		if(dependObject==null){
			if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","depend object is null");
		}
		else{
			if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Depends object:"+dependObject.reversAString("Hi"));
		}
	}

	@Override
	public String getUserName() {
		//return dependObject.reversAString("Benny");
		return super.getUserName().toLowerCase();
	}

	public String reverseAName(){
		return dependObject.reversAString(getUserName());
	}
}
