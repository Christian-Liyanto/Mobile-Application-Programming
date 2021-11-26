package id.ac.umn.christianliyanto_00000033739_if570_el_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {

    String usernameDiterima;
    RecyclerView rvDaftarAudio;
    DaftarAudioAdapter mAdapter;
    LinkedList<SumberAudio> daftarAudio = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_ChristianLiyanto_00000033739_If570_EL_UTS);
        setContentView(R.layout.library);
        Intent loginIntent = getIntent();
        usernameDiterima = loginIntent.getStringExtra("kirimUsername");
        getSupportActionBar().setTitle(usernameDiterima);
        Toast.makeText(LibraryActivity.this,"Selamat datang, "+usernameDiterima, Toast.LENGTH_SHORT).show();

        isiDaftarAudio();
        rvDaftarAudio = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarAudioAdapter(this, daftarAudio);
        rvDaftarAudio.setAdapter(mAdapter);
        rvDaftarAudio.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarAudio(){
        daftarAudio.add(new SumberAudio("Somebody touch my spageth","Meme","android.resource://"+getPackageName()+"/"+R.raw.audio1));
        daftarAudio.add(new SumberAudio("Pillar men intro","Meme/Anime","android.resource://"+getPackageName()+"/"+R.raw.audio2));
        daftarAudio.add(new SumberAudio("Kono dio da","Meme/Anime","android.resource://"+getPackageName()+"/"+R.raw.audio3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profileMenu:
                Intent intentProfile = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(intentProfile);
                return true;
            case R.id.homeMenu:
                Intent intentHome = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(intentHome);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
