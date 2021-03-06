package com.ericbandiero.mytestapplication.dagger_components;

import com.ericbandiero.mytestapplication.activities.Main2Activity;
import com.ericbandiero.mytestapplication.activities.MainActivity;
import com.ericbandiero.mytestapplication.dagger_modules.AnotherModule;
import com.ericbandiero.mytestapplication.dagger_modules.AppModule;
import com.ericbandiero.mytestapplication.dagger_modules.DaggerTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Singleton
@Component(modules={AppModule.class, DaggerTestModule.class,AnotherModule.class})
public interface DaggerComponent {
	void inject(MainActivity activity);
	 void inject(Main2Activity activity);
	//void inject(DependObject dependObject);

	// void inject(MyService service);
}
