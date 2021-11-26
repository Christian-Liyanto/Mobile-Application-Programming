package id.ac.umn.christianliyanto_00000033739_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetilAudioActivity extends AppCompatActivity {
    private VideoView vvDetil;
    private TextView etJudul;
    private TextView etKeterangan;
    private EditText etUri;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ChristianLiyanto_00000033739_If570_EL_UTS);
        setContentView(R.layout.activity_detil_audio);
        vvDetil = (VideoView) findViewById(R.id.audioPlayer);
        etJudul = (TextView) findViewById(R.id.judulAudio);
        etKeterangan = (TextView) findViewById(R.id.keteranganAudio);
        etUri = (EditText) findViewById(R.id.etUri);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberAudio sv = (SumberAudio) bundle.getSerializable("DetilVideo");
        etJudul.setText(sv.getJudul());
        etKeterangan.setText(sv.getKeterangan());
        etUri.setText(sv.getVideoURI());
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(vvDetil);
        vvDetil.setMediaController(controller);
        String judulActivity = sv.getJudul();
        getSupportActionBar().setTitle(judulActivity);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvDetil.setVideoURI(Uri.parse(sv.getVideoURI()));
                vvDetil.seekTo(100);
                vvDetil.start();
            }
        });
    }
}