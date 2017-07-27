package lekhicomp.com.onetimelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtWelcome;
    Button btnLogout;

    void initVews(){
        txtWelcome=(TextView)findViewById(R.id.textWelcome);
        btnLogout=(Button)findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initVews();
        Intent rcv=getIntent();
        txtWelcome.append(rcv.getStringExtra("keyName")+"!!");
    }

    @Override
    public void onClick(View view) {
        SharedPreferences preferences=getSharedPreferences("music",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.clear();
        Intent intent=new Intent(this,OneTimeLogin.class);
        startActivity(intent);
        //finish();
    }
}
