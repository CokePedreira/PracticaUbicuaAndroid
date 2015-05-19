package com.example.cokepedreira.ocalimochoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Integer numJugadores;
    Button bComenzar;
    EditText etNumJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         bComenzar = (Button) findViewById(R.id.b_comenzar);
         etNumJugadores = (EditText) findViewById(R.id.et_num_jugadores);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void comenzar(View view){
        Context context = getApplicationContext();

        numJugadores = Integer.parseInt(etNumJugadores.getText().toString());
        if(numJugadores <= 8 && numJugadores >= 2 ) {
            Toast toast = Toast.makeText(context, "ok", Toast.LENGTH_SHORT);
            toast.show();
            Intent myIntent = new Intent(MainActivity.this, SeleccionJugadores.class);
            myIntent.putExtra("key", numJugadores); //Optional parameters
            MainActivity.this.startActivity(myIntent);
        }
        else {
            Toast toast = Toast.makeText(context, "introduce entre 2 y 8 jugadores", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}
