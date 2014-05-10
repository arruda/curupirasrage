package com.curupirasrage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;


public class GameActivity extends Activity {
	
	private Handler gameHandler;
	
	private int qtdPontos = 0;
	
	public int getQtdPontos()
	{
		return qtdPontos;
	}
	
	public void setQtdPontos(int qtdPontos)
	{
		this.qtdPontos = qtdPontos;
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

		for (ImageButton cacador : cacadores) {
			cacador.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					v.setVisibility(ImageButton.INVISIBLE);
					setQtdPontos(getQtdPontos()+1);
				}
			});
		}

		Intent i = getIntent();
		int dificuldade = i.getIntExtra("dificuldade", 1);
		
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
		int index = gerador.nextInt(cacadores.size());
		changeButtonVisibility(index, ImageButton.VISIBLE);
	}	
	
	
	 public boolean checkGameOver(){
		 return false;
	 }
	 
     public void gameOver(){
    	 
//		Intent intent = new Intent(GameActivity.this, FimActivity.class);
//	    Bundle params = new Bundle(); 
//        params.putInt("pontuacao", getQtdPontos());
//		intent.putExtras(params); 
//	    startActivity(intent);
    	 
    	 Log.i("GAMEOVEEEER", "deu gameover");
     }
}

