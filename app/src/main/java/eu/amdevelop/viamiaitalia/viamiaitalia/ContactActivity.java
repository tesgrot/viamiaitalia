package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView address;
    TextView state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        address = (TextView) findViewById(R.id.address);
        state = (TextView) findViewById(R.id.state);

    }
}
