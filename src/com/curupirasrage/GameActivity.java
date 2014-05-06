package com.curupirasrage;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;

public class GameActivity extends Activity {
	public Boolean gameover(){
		return false;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		/*ImageButton im1 = (ImageButton) findViewById(R.id.imBtn1);
		ImageButton im2 = (ImageButton) findViewById(R.id.imBtn2);
		ImageButton im3 = (ImageButton) findViewById(R.id.imBtn3);
		ImageButton im4 = (ImageButton) findViewById(R.id.imBtn4);
		ImageButton im5 = (ImageButton) findViewById(R.id.imBtn5);
		ImageButton im6 = (ImageButton) findViewById(R.id.imBtn6);
		ImageButton im7 = (ImageButton) findViewById(R.id.imBtn7);
		ImageButton im8 = (ImageButton) findViewById(R.id.imBtn8);
		ImageButton im9 = (ImageButton) findViewById(R.id.imBtn9);
		ImageButton im10 = (ImageButton) findViewById(R.id.imBtn10);*/		
		Intent i = getIntent(); 
		int dificuldade = i.getIntExtra("Dificuldade", 1);
		if(dificuldade==1){
			/*while(!gameover()){
					try {
						//4 segundos
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}*/
		}
		if(dificuldade==2){		
			/*while(!gameover()){
				try {
					//2 segundos
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}*/
		}
		if(dificuldade==3){	
			/*while(!gameover()){
				try {
					//1 segundos
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}*/
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

}
