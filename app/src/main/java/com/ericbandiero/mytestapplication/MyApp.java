package com.ericbandiero.mytestapplication;

import android.app.Application;
import android.util.Log;

import com.ericbandiero.mytestapplication.dagger_components.DaggerComponent;
import com.ericbandiero.mytestapplication.dagger_components.DaggerDaggerComponent;
import com.ericbandiero.mytestapplication.dagger_modules.AppModule;
import com.ericbandiero.mytestapplication.dagger_modules.DaggerTestModule;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

public class MyApp extends Application {

	private DaggerComponent mNetComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Custom app object created...");
		// Dagger%COMPONENT_NAME%
		mNetComponent = DaggerDaggerComponent.builder()
				// list of modules that are part of this component need to be created here too
				.appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
				.daggerTestModule(new DaggerTestModule("Eric B."))
				.build();

		// If a Dagger 2 component does not have any constructor arguments for any of its modules,
		// then we can use .create() as a shortcut instead:
		//  mNetComponent = com.codepath.dagger.components.DaggerDaggerComponent.create();
	}

	public DaggerComponent getNetComponent() {
		return mNetComponent;
	}
}