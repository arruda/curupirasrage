package com.curupirasrage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class FimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fim);
		
		Intent i = getIntent();
		int pontos = i.getIntExtra("pontuacao", 0);
		String strPontuacao = String.valueOf(pontos);
		
		TextView txtPontos = (TextView) findViewById(R.id.textPontuacao);
		txtPontos.setText(strPontuacao);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fim, menu);
		return true;
	}

}
