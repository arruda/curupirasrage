package com.curupirasrage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;


public class GameActivity extends Activity {
	
	private Handler gameHandler = new Handler();
	
    private long startTime = 0L;
	long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    int MAX_CACADORES_VISIVEIS = 4;
    int cadadoresVisiveis = 0;

    //de quanto em quanto tempo vai rodar o timer em ms
    int timeTick = 250; 
    
    int secsParaDarGG = 10;
    
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

		Intent i = getIntent();
		int dificuldade = i.getIntExtra("dificuldade", 1);


		qtdPontos = 0;
	    cadadoresVisiveis = 0;
	    secsParaDarGG = 10;
		timeTick = timeTick/dificuldade;


		for (ImageButton cacador : cacadores) {
			cacador.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					int pos_cacador = cacadores.indexOf(v);
					changeButtonVisibility(pos_cacador, ImageButton.INVISIBLE);
					setQtdPontos(getQtdPontos()+1);
					secsParaDarGG+=1;
				}
			});
		}

		
		startTime = SystemClock.uptimeMillis();
        gameHandler.postDelayed(updateTimerThread, 250);
		
	 }
	
	private Runnable updateTimerThread = new Runnable() {

		public void run() {
			Log.i("TIMER", "começo");
			
			timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

			updatedTime = timeSwapBuff + timeInMilliseconds;
			
			randomizarCacadoresVisiveis();

			if(checkGameOver()){
				gameOver();
			}
			else{
				gameHandler.postDelayed(updateTimerThread, timeTick);
			}
		}

	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public void changeButtonVisibility(int pos, int visibility){
		ImageButton cacador = cacadores.get(pos);	
		if(cacador.getVisibility()!=visibility){

			cacador.setVisibility(visibility);
			if(visibility == ImageButton.VISIBLE){
				cadadoresVisiveis+=1;
			}
			else{
				cadadoresVisiveis-=1;			
			}
		}
	}
	
	public void randomizarCacadoresVisiveis(){
		randCacadorVisibility(selectRandomHunter());
	}
	
	public int selectRandomHunter()
	{
		Random gerador = new Random();
		int index = gerador.nextInt(cacadores.size());
		return index;
	}	
	
	public void randCacadorVisibility(int cacadorPos){

		Random gerador = new Random();
		int randomMax = 2;
		//se ja estiver visivel torna mais facil ficar invisivel
		// na proporcao de 2/3 no lugar de 1/2
		if(cacadores.get(cacadorPos).getVisibility() == ImageButton.VISIBLE){
			randomMax +=1;
		}
		int visible = gerador.nextInt(randomMax);
		
		if(cadadoresVisiveis <= MAX_CACADORES_VISIVEIS){

			if(visible == 0){
				changeButtonVisibility(cacadorPos, ImageButton.VISIBLE);
				return;
			}
		}
		//vem para ca caso tenha randomizado 1 de (0-1) ou 1, 2 de (0-2)
		changeButtonVisibility(cacadorPos, ImageButton.INVISIBLE);
	}
	
	
	 public boolean checkGameOver(){
		 

			int secs = (int) (updatedTime / 1000);

			String timerTxt = String.format("%02d", secs);
			
			Log.i("TIMER", timerTxt);

			return secs > secsParaDarGG;
			
	 }
	 
     public void gameOver(){
    	 
    	 gameHandler.removeCallbacks(updateTimerThread);
    	 Log.i("GAMEOVEEEER", "deu gameover");
    	 Log.i("GAMEOVEEEER", "pts: "+getQtdPontos());
    	 Log.i("GAMEOVEEEER", "secsTotais: "+secsParaDarGG);
		Intent intent = new Intent(GameActivity.this, FimActivity.class);
//	    Bundle params = new Bundle(); 
//        params.putInt("pontuacao", getQtdPontos());
//		intent.putExtras(params); 
	    startActivity(intent);
     }
}

