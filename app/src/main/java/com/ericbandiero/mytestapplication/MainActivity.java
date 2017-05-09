package com.ericbandiero.mytestapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ExpandableListView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.ericbandiero.librarymain.adapters.Lib_ExpandableListAdapter_With_Ids;
import com.ericbandiero.librarymain.data_classes.Lib_ExpandableDataWithIds;
import com.ericbandiero.librarymain.*;
import com.ericbandiero.librarymain.interfaces.IPrepDataExpandableList;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity implements Serializable{

	Simple_ExpandableListAdapter listAdapter;
	transient ExpandableListView expListView;

	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	List<Lib_ExpandableDataWithIds> group;
	HashMap<Lib_ExpandableDataWithIds, List<Lib_ExpandableDataWithIds>> children;


	Map<List<Lib_ExpandableDataWithIds>,HashMap<Lib_ExpandableDataWithIds, List<Lib_ExpandableDataWithIds>>> d;

	//Change in develop branch
	//Change in master branch
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

/* String way
		// preparing list data
		prepareDataStrings();
		listAdapter = new Simple_ExpandableListAdapter(this, listDataHeader, listDataChild);
		*/

		//Using our custom object
		prepareDataWithIds();

		Snackbar snackbar=Snackbar.make(findViewById(android.R.id.content), "Data prepared!", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED)
				.setAction("Action", null);
		View snackbarView=snackbar.getView();
		snackbarView.setBackgroundColor(ContextCompat.getColor(this, R.color.Blue));
		snackbar.show();

		//if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Group o pkey:"+group.get(0).getpKey());

		Lib_ExpandableListAdapter_With_Ids listAdapter = new Lib_ExpandableListAdapter_With_Ids(this, group, children);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
										int groupPosition, int childPosition, long id) {
				if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Clicked!");
				String s = group.get(groupPosition).getTextStringGroup()
						+ " : "
						+ children.get(
						group.get(groupPosition)).get(
						childPosition).getTextStringChild().toString();

if (AppConstant.DEBUG) Log.d(this.getClass().getSimpleName()+">","Child string:"+s);

				Toast.makeText(
						getApplicationContext(),

						s, Toast.LENGTH_SHORT)
						.show();

				return false;
			}
		});

	}

	/*
		Used with old way and with simple_expandlableListAdaptor
	 */
	private void prepareDataStrings(){
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Top 250");
		listDataHeader.add("Now Showing");
		listDataHeader.add("Coming Soon..");

		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("The Shawshank Redemption");
		top250.add("The Godfather");
		top250.add("The Godfather: Part II");
		top250.add("Pulp Fiction");
		top250.add("The Good, the Bad and the Ugly");
		top250.add("The Dark Knight");
		top250.add("12 Angry Men");

		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("The Conjuring");
		nowShowing.add("Despicable Me 2");
		nowShowing.add("Turbo");
		nowShowing.add("Grown Ups 2");
		nowShowing.add("Red 2");
		nowShowing.add("The Wolverine");

		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("2 Guns");
		comingSoon.add("The Smurfs 2");
		comingSoon.add("The Spectacular Now");
		comingSoon.add("The Canyons");
		comingSoon.add("Europa Report");

		listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
	}




	private void prepareDataWithIds(){
		group=new ArrayList<>();
		group.add(new Lib_ExpandableDataWithIds("Cars"));
		group.add(new Lib_ExpandableDataWithIds("Planes"));
		group.add(new Lib_ExpandableDataWithIds("Trains"));


		List<Lib_ExpandableDataWithIds> cars=new ArrayList<>();
		cars.add(new Lib_ExpandableDataWithIds("Cars","Mustang"));
		cars.add(new Lib_ExpandableDataWithIds("Cars","Ford"));


		List<Lib_ExpandableDataWithIds> planes=new ArrayList<>();
		planes.add(new Lib_ExpandableDataWithIds("Planes","Boeing"));
		planes.add(new Lib_ExpandableDataWithIds("Planes","Lear"));
		planes.add(new Lib_ExpandableDataWithIds("Planes","Airbus"));

		List<Lib_ExpandableDataWithIds> trains=new ArrayList<>();
		trains.add(new Lib_ExpandableDataWithIds("Trains","Subway"));
		trains.add(new Lib_ExpandableDataWithIds("Trains","Metro"));


	    children=new HashMap<>();
		children.put(group.get(0),cars);
		children.put(group.get(1),planes);
		children.put(group.get(2),trains);



	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, Lib_Expandable_Activity.class);

			//We can use just this to handle a click event - we get group and child
			HandleClickTest handleClickTest=new HandleClickTest();

			//If we need to handle the click as well we can use either this
			//Passing in handle gets us best of both worlds.
			//ListenForClicks listenForClicks=new ListenForClicks(handleClickTest);
			//ListenForClicks listenForClicks=new ListenForClicks();
			/*
				We can pass in our own on click listener and handle child click
				We can also just pass in one of them
				We really just need to pass in the handle click test and use default listener and pass in handle class
			*/
			intent.putExtra(Lib_Expandable_Activity.EXTRA_TITLE,"Test of Expand");
			//intent.putExtra(Lib_Expandable_Activity.EXTRA_INTERFACE_LISTENER_CHILD_CLICK,listenForClicks);
			intent.putExtra(Lib_Expandable_Activity.EXTRA_INTERFACE_HANDLE_CHILD_CLICK,handleClickTest);

			//We can pass an interface like this with a concrete class
			//	IPrepData i=new PrepData();
			//	intent.putExtra("prep",i);
			//  or on the fly - we had to make expandlistview transient
			intent.putExtra(Lib_Expandable_Activity.EXTRA_DATA_PREPARE, new IPrepDataExpandableList() {
				@Override
				public List<Lib_ExpandableDataWithIds> prepData() {
					List<Lib_ExpandableDataWithIds> data=new ArrayList<>();

					Lib_ExpandableDataWithIds test = new Lib_ExpandableDataWithIds("Mexican");
					List<String> l=new ArrayList<String>();
					l.add("Test of getting back and object - in this case array list!");
					test.setAnyObject(l);

					data.add(test);
					//data.add(new Lib_ExpandableDataWithIds("Mexican"));
					data.add(new Lib_ExpandableDataWithIds("Indian"));
					data.add(new Lib_ExpandableDataWithIds("American"));
					data.add(new Lib_ExpandableDataWithIds("Mexican","Tacos"));
					data.add(new Lib_ExpandableDataWithIds("Mexican","Burrito"));
					data.add(new Lib_ExpandableDataWithIds("Indian","Somosa"));
					data.add(new Lib_ExpandableDataWithIds("Indian","Curry"));
					data.add(new Lib_ExpandableDataWithIds("Indian","Tika"));
					data.add(new Lib_ExpandableDataWithIds("American","Burgers"));
					data.add(new Lib_ExpandableDataWithIds("American","Fries"));
					data.add(new Lib_ExpandableDataWithIds("American","Coke"));
					return data;
				}
			});
					startActivity(intent);

			return true;
		}

		return super.onOptionsItemSelected(item);
	}


}
