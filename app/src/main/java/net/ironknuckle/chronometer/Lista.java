package net.ironknuckle.chronometer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by galla_000 on 13-05-2015.
 */
public class Lista extends Chrm_menu {

    public Button boton1, volver;
    //public Button cronometro;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        boton1 = (Button) findViewById(R.id.btn_opc_1);
        Bundle bundle = getIntent().getExtras();
        String nomAct = bundle.getString("actividad");
        boton1.setText(nomAct);

        boton1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                cronometro(null);
            }
        });
    }
    public void cronometro (View view){
        Intent i = new Intent(this, chronometer.class);
        startActivity(i);
    }
    public void volver (View view){
        finish();
    }

}
