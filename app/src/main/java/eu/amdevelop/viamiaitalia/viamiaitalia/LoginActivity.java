package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataService;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private Button mEmailSignInButton;
    private DataManager dataManager;
    private DataService dataService;
    private EditText loginTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Paper.init(this);

        setContentView(R.layout.activity_login);

        dataManager = DataManager.getInstance();
        dataService = new DataService();

        loginTV = (EditText) findViewById(R.id.email);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        loginTV.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    String code = loginTV.getText().toString();
                    Log.d("######", code);
                    dataService.setCode(code);
                    if (dataManager.verifyCode() == true) {
                        Intent intent = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(LoginActivity.this, "You entered incorrect code " + code + ", please re-enter", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


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
                    Toast.makeText(LoginActivity.this, "You entered incorrect code " + code + ", please re-enter", Toast.LENGTH_LONG).show();
            }
        });

        Glide.with(this).load(R.drawable.italy_pic_min).into((ImageView) findViewById(R.id.login_hero));
    }
}

