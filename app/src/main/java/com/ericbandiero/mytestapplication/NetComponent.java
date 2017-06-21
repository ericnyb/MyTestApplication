package com.ericbandiero.mytestapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eric Bandiero on 6/21/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
	void inject(MainActivity activity);
	// void inject(MyFragment fragment);
	// void inject(MyService service);
}
