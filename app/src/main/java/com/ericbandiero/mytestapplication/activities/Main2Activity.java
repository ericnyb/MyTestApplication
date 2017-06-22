package com.ericbandiero.mytestapplication.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.ericbandiero.mytestapplication.AppConstant;
import com.ericbandiero.mytestapplication.DependObjectForDepend;
import com.ericbandiero.mytestapplication.DependsForDependsSub;
import com.ericbandiero.mytestapplication.MyApp;
import com.ericbandiero.mytestapplication.ObjectForNewModule;
import com.ericbandiero.mytestapplication.R;
import com.ericbandiero.mytestapplication.class_objects.MyDaggerObject3;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

	@Inject
	MyDaggerObject3 myDaggerObject3;

	@Inject
	ObjectForNewModule objectForNewModule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		//Dagger inject
		((MyApp) getApplication()).getNetComponent().inject(this);

		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Name in upper:"+myDaggerObject3.getUserName());
		if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Reverse name"+myDaggerObject3.reverseAName());

		DependObjectForDepend dependObjectForDepend = myDaggerObject3.getDependObject().getDependObjectForDepend();
		DependsForDependsSub c=(DependsForDependsSub)dependObjectForDepend;
		c.sayGoodby();

		objectForNewModule.sayHola();

//We should use this.
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
	}

}
