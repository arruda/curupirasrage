package com.curupirasrage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;

public class GameActivity extends Activity {
	public Boolean gameover() {
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		ImageButton btn11 = (ImageButton) findViewById(R.id.btn11);
		ImageButton btn12 = (ImageButton) findViewById(R.id.btn12);
		ImageButton btn13 = (ImageButton) findViewById(R.id.btn13);
		ImageButton btn21 = (ImageButton) findViewById(R.id.btn21);
		ImageButton btn22 = (ImageButton) findViewById(R.id.btn22);
		ImageButton btn23 = (ImageButton) findViewById(R.id.btn23);
		ImageButton btn31 = (ImageButton) findViewById(R.id.btn31);
		ImageButton btn32 = (ImageButton) findViewById(R.id.btn32);
		ImageButton btn33 = (ImageButton) findViewById(R.id.btn33);
		ImageButton btn41 = (ImageButton) findViewById(R.id.btn41);
		ImageButton btn42 = (ImageButton) findViewById(R.id.btn42);
		ImageButton btn43 = (ImageButton) findViewById(R.id.btn43);
		
		List<ImageButton> list = new ArrayList<ImageButton>();

//		btn11.setVisibility(ImageButton.INVISIBLE);
		list.add(btn11);
		list.add(btn12);
		list.add(btn13);
		list.add(btn21);
		list.add(btn22);
		list.add(btn23);
		list.add(btn31);
		list.add(btn32);
		list.add(btn33);
		list.add(btn41);
		list.add(btn42);
		list.add(btn43);
		
		
		changeButtonVisibility(list);
		
		Log.i("visibilidade", String.valueOf(list.get(1).getVisibility()));

		Intent i = getIntent();
		int dificuldade = i.getIntExtra("Dificuldade", 1);
		if (dificuldade == 1) {
			/*
			 * while(!gameover()){ try { //4 segundos Thread.sleep(4000); }
			 * catch (InterruptedException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } }
			 */
		}
		if (dificuldade == 2) {
			/*
			 * while(!gameover()){ try { //2 segundos Thread.sleep(2000); }
			 * catch (InterruptedException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } }
			 */
		}
		if (dificuldade == 3) {
			/*
			 * while(!gameover()){ try { //1 segundos Thread.sleep(1000); }
			 * catch (InterruptedException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); } }
			 */
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public void changeButtonVisibility(List<ImageButton> list){
		
		
		
		list.get(1).setVisibility(0);
		
	}
		
	
	
//		for (Button button : list) {
//			
//			try {
//				button.setVisibility(0);
//				Thread.sleep(4000);
//				button.setVisibility(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	

}
