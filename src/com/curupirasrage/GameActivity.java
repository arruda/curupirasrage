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
import java.lang.Object;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;

public class GameActivity extends Activity {
	public Boolean gameover() {
		return false;
	}
	
	protected List<ImageButton> cacadores;

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
		
		cacadores = new ArrayList<ImageButton>();

		cacadores.add(btn11);
		cacadores.add(btn12);
		cacadores.add(btn13);
		cacadores.add(btn21);
		cacadores.add(btn22);
		cacadores.add(btn23);
		cacadores.add(btn31);
		cacadores.add(btn32);
		cacadores.add(btn33);
		cacadores.add(btn41);
		cacadores.add(btn42);
		cacadores.add(btn43);
		final Handler handler = new Handler();
		

		Log.i("visibilidade", String.valueOf(cacadores.get(1).getVisibility()));

		Intent i = getIntent();
		int dificuldade = i.getIntExtra("dificuldade", 1);
		
		if (dificuldade == 1) {
			final Runnable naoClicadoFacil = new Runnable()
			{
			    public void run() 
			    {
			    	hideHunter();
				    showRandomHunter();
				    handler.postDelayed(this, 3000);
			    }
			};
			handler.postDelayed(naoClicadoFacil, 3000);
			final Runnable ClicadoFacil = new Runnable()
			{
			    public void run() 
			    {
				    showRandomHunter();
				    handler.postDelayed(naoClicadoFacil, 3000);
			    }
			};
			
			for (ImageButton cacador : cacadores) {
				cacador.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						v.setVisibility(ImageButton.INVISIBLE);
						handler.removeCallbacks(naoClicadoFacil);
						handler.postDelayed(ClicadoFacil, 0);
					}
				});
			}
		}
		
		if (dificuldade == 2) {
			final Runnable naoClicadoNormal = new Runnable()
			{
			    public void run() 
			    {
			    	hideHunter();
				    showRandomHunter();
				    handler.postDelayed(this, 2000);
			    }
			};
			handler.postDelayed(naoClicadoNormal, 2000);
			
			final Runnable ClicadoNormal = new Runnable()
			{
			    public void run() 
			    {
				    showRandomHunter();
				    handler.postDelayed(naoClicadoNormal, 2000);
			    }
			};
			
			for (ImageButton cacador : cacadores) {
				cacador.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						v.setVisibility(ImageButton.INVISIBLE);
						handler.removeCallbacks(naoClicadoNormal);
						handler.postDelayed(ClicadoNormal, 0);
					}
				});
			}
		
		}
		
		if (dificuldade == 3) {
			final Runnable naoClicadoDificil = new Runnable()
			{
			    public void run() 
			    {
			    	hideHunter();
				    showRandomHunter();
				    handler.postDelayed(this, 1000);
			    }
			};
			handler.postDelayed(naoClicadoDificil, 1000);
			
			final Runnable ClicadoDificil = new Runnable()
			{
			    public void run() 
			    {
				    showRandomHunter();
				    handler.postDelayed(naoClicadoDificil, 1000);
			    }
			};
			
			for (ImageButton cacador : cacadores) {
				cacador.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						v.setVisibility(ImageButton.INVISIBLE);
						handler.removeCallbacks(naoClicadoDificil);
						handler.postDelayed(ClicadoDificil, 0);
					}
				});
			}
		
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public void changeButtonVisibility(int pos, int visibility){
		cacadores.get(pos).setVisibility(visibility);		
	}
	
	public void showRandomHunter()
	{
		Random gerador = new Random();
		int index = gerador.nextInt(12);
		changeButtonVisibility(index, ImageButton.VISIBLE);
	}
	public void hideHunter()
	{
		for(int i=0;i<12;i++){
		changeButtonVisibility(i, ImageButton.INVISIBLE);}
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
