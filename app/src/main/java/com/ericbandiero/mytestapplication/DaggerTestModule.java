package com.ericbandiero.mytestapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Module
public class DaggerTestModule {

	String mBaseUrl;

	// Constructor needs one parameter to instantiate.
	public DaggerTestModule(String baseUrl) {
		this.mBaseUrl = baseUrl;
	}

	// Dagger will only look for methods annotated with @Provides
	@Provides
	@Singleton
	// Application reference must come from AppModule.class
	SharedPreferences providesSharedPreferences(Application application) {
		return PreferenceManager.getDefaultSharedPreferences(application);
	}

	@Provides
	@Singleton
	MyDaggerObject myDaggerObject(){
		MyDaggerObject myDaggerObject=new MyDaggerObject(mBaseUrl);
		return myDaggerObject;
	}
}
