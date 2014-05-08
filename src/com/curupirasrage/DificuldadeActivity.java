package com.curupirasrage;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class DificuldadeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dificuldade);
		Button btnDificuldade1 = (Button) findViewById(R.id.btnFacil);
		Button btnDificuldade2 = (Button) findViewById(R.id.btnNormal);
		Button btnDificuldade3 = (Button) findViewById(R.id.btnDificil);
		
		btnDificuldade1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DificuldadeActivity.this, GameActivity.class);
				Bundle params = new Bundle(); 
				int dificuldade = 1;
				params.putInt("dificuldade",dificuldade);
				intent.putExtras(params); 
			    startActivity(intent);
			}
		});
		
		btnDificuldade2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DificuldadeActivity.this, GameActivity.class);
			    Bundle params = new Bundle(); 
				int dificuldade = 2;
				params.putInt("dificuldade",dificuldade);
				intent.putExtras(params); 
			    startActivity(intent);
			}
		});
		
		btnDificuldade3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DificuldadeActivity.this, GameActivity.class);
				Bundle params = new Bundle(); 
				int dificuldade = 3;
				params.putInt("dificuldade",dificuldade);
				intent.putExtras(params); 
			    startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dificuldade, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_dificuldade,
					container, false);
			return rootView;
		}
	}

}
