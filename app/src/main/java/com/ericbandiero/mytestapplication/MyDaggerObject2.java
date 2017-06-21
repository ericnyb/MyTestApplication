package com.ericbandiero.mytestapplication;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

public class MyDaggerObject2 extends MyDaggerObject {
	public MyDaggerObject2(String userName) {
		super(userName);
	}

	@Override
	public String getUserName() {
		return super.getUserName().toUpperCase();
	}
}
