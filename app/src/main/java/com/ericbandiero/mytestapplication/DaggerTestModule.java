package com.ericbandiero.mytestapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

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
		//We can switch out an object here
		MyDaggerObject myDaggerObject=new MyDaggerObject(mBaseUrl);
		//MyDaggerObject2 myDaggerObject=new MyDaggerObject2(mBaseUrl);
		return myDaggerObject;
	}

	@Provides
	@Singleton
	MyDaggerObject2 myDaggerObject2(){
		if (AppConstant.DEBUG) Log.d(new Object() { }.getClass().getEnclosingClass()+">","Creating mydaggerobject2 object");
		//We can switch out an object here
		//MyDaggerObject myDaggerObject=new MyDaggerObject(mBaseUrl);
		MyDaggerObject2 myDaggerObject=new MyDaggerObject2(mBaseUrl);
		return myDaggerObject;
	}

	@Provides
	@Singleton
	DependObject dependObject(){
		if (AppConstant.DEBUG) Log.d(new Object() { }.getClass().getEnclosingClass()+">","Creating depend object");
		DependObject dependObject=new DependObject();
		return dependObject;
	}

	@Provides
	@Singleton
	MyDaggerObject3 myDaggerObject3(DependObject object){
		if (AppConstant.DEBUG) Log.d(new Object() { }.getClass().getEnclosingClass()+">","Creating mydaggerobject3 object");
		//We can switch out an object here
		//MyDaggerObject myDaggerObject=new MyDaggerObject(mBaseUrl);
		MyDaggerObject3 myDaggerObject=new MyDaggerObject3(mBaseUrl,object);
		return myDaggerObject;
	}
}
