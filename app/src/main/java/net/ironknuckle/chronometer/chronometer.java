package net.ironknuckle.chronometer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.ToggleButton;

import static net.ironknuckle.chronometer.R.raw;

/**
 * Created by galla_000 on 13-05-2015.
 */
public class chronometer extends ActionBarActivity implements View.OnClickListener {

    private Chronometer chR;
    private ToggleButton T_btn;
    private TextView text;
    private TextView timeElapsedView;

    private boolean start =false;
    private long total_vueltas;
    private int vueltas;
    private String tiempoVueltas="";

    private Button btnIniciar;
    private MalibuCountDownTimer timer;

    private long segundos;
    private long repetir =1000;
    private long timeElapsed;
    private boolean timerHasStarted=false;
    private MediaPlayer beep, alarma;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cronometro);
        beep = MediaPlayer.create(this, raw.beep);
        alarma = MediaPlayer.create(this, raw.alarma1);

        btnIniciar = (Button) this.findViewById(R.id.button);
        btnIniciar.setOnClickListener(this);
        text = (TextView) this.findViewById(R.id.timer);
        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);


        Bundle bundle = getIntent().getExtras();
        segundos =(Long.parseLong(bundle.getString("segundos")))*1000;
        //repetir  =Long.parseLong(bundle.getString("repetir"));
        timer = new MalibuCountDownTimer(segundos,repetir);
        text.setText(text.getText()+ String.valueOf(segundos));

































       /* chR = (Chronometer) findViewById(R.id.chronometer);
        T_btn = (ToggleButton) findViewById(R.id.toggleButton);
        ViewLaps = (TextView) findViewById(R.id.textView);*/

   /*     T_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(T_btn.isChecked()){
                    chStart();
                }else{
                    long ultima_vuelta = total_vueltas;
                    total_vueltas = chR.getBase()-SystemClock.elapsedRealtime();
                    long duracion_vuelta = total_vueltas-ultima_vuelta;
                    chStop();
                    vueltas++;
                    if (vueltas<=6){
                        showInterval(duracion_vuelta);
                    }else{
                        tiempoVueltas="";
                        vueltas=1;
                        showInterval(duracion_vuelta);
                    }
                }

            }
        });}

    private void showInterval(long duracion_vuelta) {
        tiempoVueltas += getResources().getText(R.string.interval)+"\tn°\t"+vueltas+":\t"+getTextMiliseconds(duracion_vuelta)+"\t segundos \n";
        ViewLaps.setText(tiempoVueltas);

    }

    private String getTextMiliseconds(long miliseconds) {
        float segundos=((float)miliseconds/(float)1000)*-1;
        String time="";
        time+=String.valueOf(segundos);
        return time;
    }

    private void chStop() {
        chR.stop();
    }

    public void chStart(){
            setTimeBase();
            chR.start();
    }
    public void setTimeBase(){
        if(!start){
            chR.setBase(SystemClock.elapsedRealtime());
            start=true;
        }else{
            chR.setBase(SystemClock.elapsedRealtime()+total_vueltas);
        }
    }
*/


/*
        final Chronometer m_chronometer;
        Button btIniciar, btPausar, btResetar;
        final boolean[] isClickPause = {false};
        final long[] tempoQuandoParado = {0};

        m_chronometer = (Chronometer) findViewById(R.id.chronometer);

        btIniciar = (Button) findViewById(R.id.btIniciar);
        btPausar = (Button) findViewById(R.id.btPausar);
        btResetar = (Button) findViewById(R.id.btResetar);

        //Botão INICIAR
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(isClickPause[0]){
                    m_chronometer.setBase(SystemClock.uptimeMillis() + tempoQuandoParado[0]);
                    m_chronometer.start();
                    tempoQuandoParado[0] = 0;
                    isClickPause[0] = false;
                }
                else{
                    m_chronometer.setBase(SystemClock.elapsedRealtime());
                    m_chronometer.start();
                    tempoQuandoParado[0] = 0;
                }

            }
        });

//Botão PAUSAR
        btPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(isClickPause[0] == false){ //entra para false;
                    tempoQuandoParado[0] = m_chronometer.getBase() - SystemClock.elapsedRealtime();
                }
                m_chronometer.stop();
                isClickPause[0] = true;
            }
        });

//Botão RESETAR
        btResetar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                m_chronometer.stop();
                m_chronometer.setText("Total: (00:00:000)");
                tempoQuandoParado[0] = 0;
            }
        });*/
    }
    @Override
    public void onClick(View v) {
        if (!timerHasStarted)
        {
            timer.start();
            timerHasStarted = true;
            btnIniciar.setText("Start");
        }
        else
        {

            timer.cancel();
            timerHasStarted = false;
            btnIniciar.setText("RESET");
        }
    }



    public class MalibuCountDownTimer extends CountDownTimer{
            public MalibuCountDownTimer (long segundos, long repetir){
                super(segundos, repetir);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain:" + millisUntilFinished);
            timeElapsed = segundos - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
            beep.start();

        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(segundos));
            alarma.start();
        }
    }


}



