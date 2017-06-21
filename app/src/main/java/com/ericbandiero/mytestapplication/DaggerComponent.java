package com.ericbandiero.mytestapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Singleton
@Component(modules={AppModule.class, DaggerTestModule.class})
public interface DaggerComponent {
	void inject(MainActivity activity);
	// void inject(MyFragment fragment);
	// void inject(MyService service);
}
