package demoapplication.application.com.statlib;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class TestActivity extends AppCompatActivity {

    private TextView heading;
    private Button submit;
    private EditText name, password;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        heading = findViewById(R.id.heading);
        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        /*String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("Token", token);*/
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);

        long cacheExpiration = 3600;

        if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 0;
        }

        mFirebaseRemoteConfig.fetch(cacheExpiration).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(TestActivity.this, "Fetch Succeeded",
                            Toast.LENGTH_SHORT).show();

                    mFirebaseRemoteConfig.activateFetched();

                    updateData();
                } else {
                    Toast.makeText(TestActivity.this, "Fetch Failed",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public void updateData(){

        String nameString = mFirebaseRemoteConfig.getString("name");
        String headingString = mFirebaseRemoteConfig.getString("heading");
        String passwordString = mFirebaseRemoteConfig.getString("password");
        String submitString = mFirebaseRemoteConfig.getString("submit");
        name.setText(nameString);
        heading.setText(headingString);
        password.setText(passwordString);
        submit.setText(submitString);

    }
}
