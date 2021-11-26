package id.ac.umn.christianliyanto_00000033739_if570_el_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button next;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Design_Light_NoActionBar);
        setContentView(R.layout.login_page);
        next = findViewById(R.id.loginButton);
        username = findViewById(R.id.idUser);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(LoginActivity.this, LibraryActivity.class);
                String id =username.getText().toString();
                if(id.isEmpty()){
                    username.setError("Harap Di-isi");
                }
                else{
                    intentLogin.putExtra("kirimUsername", id);
                    startActivity(intentLogin);
                }
            }
        });
    }
}
