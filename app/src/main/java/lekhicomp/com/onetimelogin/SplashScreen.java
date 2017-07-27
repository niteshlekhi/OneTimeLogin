package lekhicomp.com.onetimelogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashScreen extends Activity {
    SharedPreferences preferences;
    String name = "";
    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        preferences = getSharedPreferences("music", MODE_PRIVATE);
        name = preferences.getString("keyName", "");
        email = preferences.getString("keyEmail", "");
        password = preferences.getString("keyPassword", "");
        handler.sendEmptyMessageAtTime(101, 3000);

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 101) {
                if (name.contentEquals("")) {
                    Intent intent = new Intent(SplashScreen.this, OneTimeLogin.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashScreen.this, HomeActivity.class);
                    intent.putExtra("keyName", name);
                    startActivity(intent);
                }
                finish();
            }

        }
    };
}

