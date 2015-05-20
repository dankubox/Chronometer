package net.ironknuckle.chronometer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Chrm_menu extends ActionBarActivity {

    private Spinner Item_Segundos, Item_Repetir;
    private EditText Nombre_Act;
    private Button btn_lista, btn_guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrm_menu);

        Nombre_Act = (EditText) findViewById(R.id.nomb_act);
        Item_Segundos = (Spinner) findViewById(R.id.spinner);
        Item_Repetir = (Spinner) findViewById(R.id.spinner2);
        btn_lista = (Button) findViewById(R.id.btn_lista);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.seg, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.rep, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Item_Segundos.setAdapter(adapter);
        Item_Repetir.setAdapter(adapter1);

        Item_Segundos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Item_Repetir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_lista.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                iniciarCronometro(null);
                //iniciarLista(null);
            }
        });

    }
    public void iniciarLista(View view){
        Intent i = new Intent(this, Lista.class);
        i.putExtra("actividad",Nombre_Act.getText().toString());
        startActivity(i);
    }
    public void iniciarCronometro (View view){
        Intent i = new Intent(this, chronometer.class);
        i.putExtra("segundos", Item_Segundos.getSelectedItem().toString());
        i.putExtra("repetir", Item_Repetir.getSelectedItem().toString());
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chrm_menu, menu);
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
}
