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
		
		Button btn11 = (Button) findViewById(R.id.btn11);
		Button btn12 = (Button) findViewById(R.id.btn12);
		Button btn13 = (Button) findViewById(R.id.btn13);
		Button btn21 = (Button) findViewById(R.id.btn21);
		Button btn22 = (Button) findViewById(R.id.btn22);
		Button btn23 = (Button) findViewById(R.id.btn23);
		Button btn31 = (Button) findViewById(R.id.btn31);
		Button btn32 = (Button) findViewById(R.id.btn32);
		Button btn33 = (Button) findViewById(R.id.btn33);
		Button btn41 = (Button) findViewById(R.id.btn41);
		Button btn42 = (Button) findViewById(R.id.btn42);
		Button btn43 = (Button) findViewById(R.id.btn43);
		
		List<Button> list = new ArrayList<Button>();

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

	public void changeButtonVisibility(List<Button> list){
		
		
		
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
