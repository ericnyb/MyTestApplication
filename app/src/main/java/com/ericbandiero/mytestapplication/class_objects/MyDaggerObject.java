package com.ericbandiero.mytestapplication.class_objects;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */


public class MyDaggerObject {
	private String userName;

	public MyDaggerObject(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
