package com.ericbandiero.mytestapplication.dagger_modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Module
public class AppModule {

	Application mApplication;

	public AppModule(Application application) {
		mApplication = application;
	}

	@Provides
	@Singleton
	Application providesApplication() {
		return mApplication;
	}
}