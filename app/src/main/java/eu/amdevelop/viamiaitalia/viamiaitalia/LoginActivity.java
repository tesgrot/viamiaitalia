package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataService;
import io.paperdb.Paper;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private Button mEmailSignInButton;
    private DataManager dataManager;
    private DataService dataService;
    private AutoCompleteTextView loginTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Paper.init(this);

        setContentView(R.layout.activity_login);

        dataManager = DataManager.getInstance();
        dataService = new DataService();

        loginTV = (AutoCompleteTextView) findViewById(R.id.email);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = loginTV.getText().toString();
                Log.d("######", code);
                dataService.setCode(code);
                if (dataManager.verifyCode() == true) {
                    Intent intent = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginActivity.this, "You entered incorrect code" + code, Toast.LENGTH_LONG).show();
            }
        });

        Glide.with(this).load(R.drawable.italy_pic_min).into((ImageView) findViewById(R.id.login_hero));
    }
}

