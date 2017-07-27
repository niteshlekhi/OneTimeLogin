package lekhicomp.com.onetimelogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OneTimeLogin extends AppCompatActivity implements View.OnClickListener {

    EditText txtName,txtEmail,txtPassword;
    Button btnLogin;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    void initViews(){
        txtName=(EditText)findViewById(R.id.textViewName);
        txtEmail=(EditText)findViewById(R.id.textViewEmail);
        txtPassword=(EditText)findViewById(R.id.textViewPassword);
        btnLogin=(Button)findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(this);
        preferences=getSharedPreferences("music",MODE_PRIVATE);
        editor=preferences.edit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_login);
        initViews();

    }

    @Override
    public void onClick(View view) {
        String name=txtName.getText().toString().trim();
        if(name.contentEquals("") || (txtEmail.getText().toString().trim().contentEquals("")) ||((txtPassword.getText().toString().trim().contentEquals(""))))
            Toast.makeText(this,"No Fields must be Empty!!",Toast.LENGTH_LONG).show();
        else {
            editor.putString("keyName",name);
            editor.putString("keyEmail",txtEmail.getText().toString().trim());
            editor.putString("keyPassword",txtPassword.getText().toString().trim());
            editor.commit();
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("keyName", name);
            startActivity(intent);
        }
    }
}
