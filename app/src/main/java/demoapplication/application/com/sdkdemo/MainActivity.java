package demoapplication.application.com.sdkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import demoapplication.application.com.statlib.ChangeTheme;
import demoapplication.application.com.statlib.FirebStoreData;
import demoapplication.application.com.statlib.PreferenceManager;
import demoapplication.application.com.statlib.TestActivity;

public class MainActivity extends AppCompatActivity {

    private String message;
    private TextView textViewHello;
    private Button buttonClick;
    private static final String Theme_Current = "AppliedTheme";
    private static final String Theme_Dark = "DarkTheme";
    public static final String APP_AVALOQ = "AVALOQ";
    public static final String APP_NBL = "NBL";
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("themes/apps");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.NewAppTheme);

        /*ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();

        *//*for (int i = 0; i < 15; i++) {
            numbers.add(r.nextInt(7)+1);
        }
*//*
        numbers.add(1);
        double mean = CentralTendency.arithmeticMean(numbers).doubleValue();
        double median = CentralTendency.median(numbers);
        ArrayList<Integer> mode = CentralTendency.mode(numbers);

        Collections.sort(numbers);

        String res = String.format("Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
                numbers, mean, median, mode);

        TextView textView = (TextView)findViewById(R.id.text_view_result);
        textView.setText(res);*/
       /* if (!PreferenceManager.preferenceGetString("AppliedTheme", "").equals("")) {
            if (PreferenceManager.preferenceGetString("AppliedTheme", "").equals("Green_Dark")) {
                setTheme(R.style.AppTheme_Base_Green_Dark);
            } else if (PreferenceManager.preferenceGetString("AppliedTheme", "").equals("Purple_Dark")) {
                setTheme(R.style.AppTheme_Base_Purple_Dark);
            }else {
                setTheme(R.style.AppTheme);
            }
        }*/


        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, TestActivity.class));

       /* textViewHello = findViewById(demoapplication.application.com.statlib.R.id.textViewHello);
        buttonClick = findViewById(demoapplication.application.com.statlib.R.id.buttonClick);

        textViewHello.setTextColor(getResources().getColor(demoapplication.application.com.statlib.R.color.colorAccent));
        buttonClick.setTextColor(getResources().getColor(demoapplication.application.com.statlib.R.color.colorAccent));

        FirebaseMessaging.getInstance().subscribeToTopic("ANDROID_NEWS");
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*PreferenceManager.preferencePutString(Theme_Current, "Green_Dark");
                startActivity(new Intent(MainActivity.this, ChangeTheme.class));*//*
                changeTheme();


            }
        });*/

        /*textViewHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.preferencePutString(Theme_Current, "Purple_Dark");
                startActivity(new Intent(MainActivity.this, ChangeTheme.class));
            }
        });*/

        //pushNotification();
    }

    /*private void pushNotification(){

        try {
            message = "";

            final Intent intent = getIntent();
            message = intent.getExtras().getString("ms");
            if(!message.equals("") || !message.isEmpty()) {

                new AlertDialog.Builder(this)
                        .setTitle("Firebase MainActivity")
                        .setMessage(message)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(MainActivity.this, FirebaseCloudMessaging.class);
                                intent1.putExtra("ms",message);
                                startActivity(intent);
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .show();

            }else {

                Log.e("Message", "No Message To Display");

            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/


    private void changeTheme() {
        mDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    try {
                        if (documentSnapshot.getBoolean(APP_AVALOQ)) {
                            FirebStoreData.getInstance().setAppName(documentSnapshot.getString("appName"));
                            startActivity(new Intent(MainActivity.this, ChangeTheme.class));
                        } else if (documentSnapshot.getBoolean(APP_NBL)) {
                            FirebStoreData.getInstance().setAppName(documentSnapshot.getString("appName"));
                            startActivity(new Intent(MainActivity.this, ChangeTheme.class));
                        } else {
                            FirebStoreData.getInstance().setAppName(documentSnapshot.getString("appName"));
                            startActivity(new Intent(MainActivity.this, ChangeTheme.class));
                        }
                    } catch (NullPointerException e){
                        e.printStackTrace();
                    }

                }
            }
        });
    }

}

