package id.ac.umn.week05_33739;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar sbRed, sbGreen, sbBlue;
    RadioGroup rgBentuk;
    RadioButton rbPilih;
    ImageButton btnWarna;
    CustomView customView;
    int red =0, green =0, blue =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        btnWarna = findViewById(R.id.btnWarna);
        rgBentuk = findViewById(R.id.rgBentuk);
        customView = findViewById(R.id.customView);
        customView = new CustomView(this);

        rgBentuk.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup Group, int checkedGroup) {
                int intRb = rgBentuk.getCheckedRadioButtonId();
                rbPilih = findViewById(intRb);
                String bentuk = rbPilih.getText().toString();
                customView.gantiBentuk(bentuk);
            }
        });

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                red = sbRed.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });

        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                green = sbGreen.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });

        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blue = sbBlue.getProgress();
                customView.gantiWarna(red,green,blue);
                btnWarna.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
    }
}