package com.ericbandiero.mytestapplication.dagger_modules;

import android.app.Application;
import android.util.Log;

import com.ericbandiero.mytestapplication.AppConstant;
import com.ericbandiero.mytestapplication.ObjectForNewModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Module
public class AnotherModule {

	Application mApplication;

	public AnotherModule(){
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","In another module!");
	}

	@Provides
	@Singleton
	ObjectForNewModule objectForNewModule(){
		return new ObjectForNewModule();
	}
}