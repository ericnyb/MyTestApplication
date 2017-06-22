package com.ericbandiero.mytestapplication;

import android.app.Application;

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

	}

	@Provides
	@Singleton
	ObjectForNewModule objectForNewModule(){
		return new ObjectForNewModule();
	}
}