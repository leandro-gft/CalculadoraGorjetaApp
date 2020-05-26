package br.com.gft.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etValor;
    private SeekBar seekBar;
    private TextView tvSeekBar;
    private TextView tvGorjeta;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValor = findViewById(R.id.etValor);
        seekBar = findViewById(R.id.seekBar);
        tvSeekBar = findViewById(R.id.tvSeekBar);
        tvGorjeta = findViewById(R.id.tvGorjeta);
        tvTotal = findViewById(R.id.tvTotal);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int taxaGorjeta = seekBar.getProgress();
                tvSeekBar.setText(taxaGorjeta+"%");

                try {
                    calcular(taxaGorjeta);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Entre com um valor.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calcular(int taxaGorjeta) {
        double valor = Double.parseDouble(etValor.getText().toString());
        double gorjeta = valor * taxaGorjeta/100;
        double total = gorjeta + valor;
        tvGorjeta.setText("R$"+gorjeta);
        tvTotal.setText("R$"+total);
    }


}
