package com.parallelware.citizen;

import java.util.Locale;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parallelware.citizen.MainActivity.HomeSectionFragment;



public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	static ViewPager mViewPager;
	
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		
		public Fragment homeFragment;
		public Fragment mapFragment;
		

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
//			Fragment fragment = new DummySectionFragment();
//			Bundle args = new Bundle();
//			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
//			fragment.setArguments(args);
			
			
			Fragment fragment = null;

			// ++ = not implemented
			
			if (position == 0) {
				fragment = homeFragment = new HomeSectionFragment();
				
			} else if (position == 1) {
				// Me +++
				fragment = homeFragment = new HomeSectionFragment();
			} else if (position == 2) {
				// Proximity
				fragment = mapFragment = new MapsFragment();
				
			} else if (position == 3) {
				// Poll +++
				fragment = homeFragment = new HomeSectionFragment();
				
			}
		 else if (position == 4) {
			// Poll Results +++
				fragment = homeFragment = new HomeSectionFragment();
			
		}
	 else if (position == 5) {
		// Map
		 fragment = mapFragment = new MapsFragment();
	}
	 else if (position == 6) {
			// Submit Poll +++
			fragment = homeFragment = new HomeSectionFragment();
			
		}
	 else if (position == 7) {
			// Stats +++
			fragment = homeFragment = new HomeSectionFragment();
			
		}
			
			
			
			
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 8;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			case 5:
				return getString(R.string.title_section6).toUpperCase(l);
			case 6:
				return getString(R.string.title_section7).toUpperCase(l);
			case 7:
				return getString(R.string.title_section8).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			//dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			
	
			
			return rootView;
		}
	}
	
	
	/**
	 * Our Account fragment representing account section of CitiZen app
	 */
	public static class AccountFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public AccountFragment() {
			
			
			
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);

			
			
			
			return rootView;
		}
		
		

		
	}
	
	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class MapsFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";
		
		private GoogleMap map;
		FragmentManager myFM = null;
		SupportMapFragment myMAPF = null;
		
		public MapsFragment() {
		}

		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	    }

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View fragmentView = inflater.inflate(R.layout.fragment_map, container, false);


	        return fragmentView;
	    }

	    @Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	        
	        try {
	        myFM = getActivity().getSupportFragmentManager();
	        myMAPF = (SupportMapFragment) myFM.findFragmentById(R.id.map);
	        
	        map = myMAPF.getMap();

	        
	        LatLng toronto = new LatLng(43.70011,-79.4163);

	        map.setMyLocationEnabled(true);
	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(toronto, 13));

	        map.addMarker(new MarkerOptions()
	                .title("Toronto")
	                .snippet("The Great City of Toronto")
	                .position(toronto));
	        
	        }
	        catch (Exception ex) {
	          // Add toast widget..	
	        
	        }
	    }
		
		
	}
	

	public void populateAccounts() {
		
		AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
		Account[] list = manager.getAccounts();	

	
	}
	
	/*
	private String[] getAccountNames() {
	    mAccountManager = AccountManager.get(this);
	    Account[] accounts = mAccountManager.getAccountsByType(
	            GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
	    String[] names = new String[accounts.length];
	    for (int i = 0; i < names.length; i++) {
	        names[i] = accounts[i].name;
	    }
	    return names;
	}
	*/
	
	public static class HomeSectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public HomeSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container,false);
			// TextView dummyTextView = (TextView) rootView
			// .findViewById(R.id.section_label);
			// dummyTextView.setText(Integer.toString(getArguments().getInt(
			// ARG_SECTION_NUMBER)));
			
						
			return rootView;
		}
		
		
	}

	
	
	public void switchToHome(View view) {
		mViewPager.setCurrentItem(0, false);
	}
	public void switchToMe(View view) {
		mViewPager.setCurrentItem(1, false);

	}
	public void switchToProximity(View view) {
		mViewPager.setCurrentItem(2, false);
	}
	
	public void switchToPoll(View view) {
		mViewPager.setCurrentItem(3, false);
	}
	public void switchToPollResults(View view) {
		mViewPager.setCurrentItem(4, false);
	}
	public void switchToMap(View view) {
		mViewPager.setCurrentItem(5, false);
	}
	public void switchToSubmitPoll(View view) {
		mViewPager.setCurrentItem(6, false);
	}
	public void switchToStats(View view) {
		mViewPager.setCurrentItem(7, false);
	}
}
