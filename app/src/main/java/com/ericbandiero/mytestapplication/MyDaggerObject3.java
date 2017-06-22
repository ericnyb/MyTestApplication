package com.ericbandiero.mytestapplication;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

public class MyDaggerObject3 extends MyDaggerObject {
	public MyDaggerObject3(String userName) {
		super(userName);
	}

	@Override
	public String getUserName() {
		return super.getUserName().toLowerCase();
	}
}
