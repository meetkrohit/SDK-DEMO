package demoapplication.application.com.statlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangeTheme extends BaseActivity {

    private TextView textViewHello;
    private Button buttonClick;
    private static final String Theme_Current = "AppliedTheme";
    private static final String Theme_Dark = "DarkTheme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_theme);

        /*if (!PreferenceManager.preferenceGetString("AppliedTheme", "").equals("")) {
            if (PreferenceManager.preferenceGetString("AppliedTheme", "").equals("Green_Dark")) {
                setTheme(R.style.AppTheme_Base_Green_Dark);
            } else if (PreferenceManager.preferenceGetString("AppliedTheme", "").equals("Purple_Dark")) {
                setTheme(R.style.AppTheme_Base_Purple_Dark);
            }else {
                setTheme(R.style.AppTheme);
            }
        }*/


        setContentView(R.layout.activity_change_theme);

        textViewHello = findViewById(demoapplication.application.com.statlib.R.id.textViewHello);
        buttonClick = findViewById(demoapplication.application.com.statlib.R.id.buttonClick);

        textViewHello.setTextColor(getResources().getColor(demoapplication.application.com.statlib.R.color.colorAccent));
        buttonClick.setTextColor(getResources().getColor(demoapplication.application.com.statlib.R.color.colorAccent));
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*PreferenceManager.preferencePutString(Theme_Current, "Green_Dark");
                startActivity(new Intent(ChangeTheme.this, ChangeTheme.class));*/
            }
        });
        textViewHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*PreferenceManager.preferencePutString(Theme_Current, "Purple_Dark");
                startActivity(new Intent(ChangeTheme.this, ChangeTheme.class));*/
            }
        });


    }
}
